package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.dto.FileDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "File")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;
    private int ano;
    private String oriName;
    private String newName;
    private int download;
    @CreationTimestamp
    private LocalDateTime rdate;

    public FileDTO toDTO() {
        return FileDTO.builder()
                .fno(fno)
                .ano(ano)
                .oriName(oriName)
                .newName(newName)
                .download(download)
                .rdate(rdate)
                .build();
    }
}