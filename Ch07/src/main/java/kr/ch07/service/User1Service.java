package kr.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch07.dto.User1DTO;
import kr.ch07.mapper.User1Mapper;

@Service
public class User1Service {
	@Autowired
	private User1Mapper mapper;

	public void insertUser1(User1DTO dto) {
		mapper.insertUser1(dto);
	}

	public User1DTO selectUser1(String uid) {
		return mapper.selectUser1(uid);
	}

	public List<User1DTO> selectUser1s() {
		return mapper.selectUser1s();
	}

	public void updateUser1(User1DTO dto) {
		mapper.updateUser1(dto);
	}

	public void deleteUser1(String uid) {
		mapper.deleteUser1(uid);
	}
}