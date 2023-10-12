package co.kr.ch12.repository;

import co.kr.ch12.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	public UserEntity findUserEntityByUidAndPass(String uid, String pass);
}