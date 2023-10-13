package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public PageResponseDTO findByParent(PageRequestDTO pageRequestDTO) {
        Page<ArticleEntity> result = articleRepository.findByParent(0, pageRequestDTO.getPageable("no"));
        List<ArticleDTO> dtoList =  result
                                    .getContent()
                                    .stream()
                                    .map(entity -> modelMapper.map(entity, ArticleDTO.class))
                                    .toList();
        int totalElement = (int) result.getTotalElements();
        return PageResponseDTO
                .builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    public void save(ArticleDTO dto) {
        FileDTO fileDTO = fileUpload(dto);
        ArticleEntity articleEntity = dto.toEntity();
        if (fileDTO != null) {
            articleEntity.setFile(1);
        }
        ArticleEntity savedEntity = articleRepository.save(articleEntity);
        if (fileDTO != null) {
            fileDTO.setAno(savedEntity.getNo());
            fileRepository.save(fileDTO.toEntity());
        }
    }

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public FileDTO fileUpload(ArticleDTO dto) {
        MultipartFile mf  = dto.getFname();
        if (!mf.isEmpty()) {
            // 파일 첨부 했을 경우
            String path = new File(filePath).getAbsolutePath();
            String oName = mf.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString() + ext;
            try {
                mf.transferTo(new File(path, sName));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            return FileDTO.builder()
                    .oriName(oName)
                    .newName(sName)
                    .build();
        }
        return null;
    }
}