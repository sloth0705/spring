package kr.ch09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ch09.entiry.UserEntity;
import kr.ch09.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder encoder;
	
	public void insertUser(UserEntity user) {
		user.setPass(encoder.encode(user.getPass()));
		repo.save(user);
	}
	
	public void selectUser(String uid, String pass) {
		repo.findUserEntityByUidAndPass(uid, encoder.encode(pass));
	}
}