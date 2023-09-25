package ch06.mapper;

import org.apache.ibatis.annotations.Mapper;

import ch06.dto.User1DTO;

@Mapper
public interface User1Mapper {
	public User1DTO selectUser1s();
}