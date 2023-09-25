package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User1DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User1MapperTest {
	@Autowired
	private User1Mapper mapper;
	
	@Test
	public void selectUser1s() {
		List<User1DTO> users =  mapper.selectUser1s();
		for (User1DTO user : users) {
			log.info(user.toString());
		}
	}
}