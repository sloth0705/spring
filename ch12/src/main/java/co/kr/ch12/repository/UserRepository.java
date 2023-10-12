package kr.ch11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch11.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	public UserEntity findUserEntityByUidAndPass(String uid, String pass);
}