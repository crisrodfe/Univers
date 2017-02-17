package com.crisrodfe.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.User;
import com.crisrodfe.repository.security.UserRepository;

/**
 * The Class RegisterUserServiceImpl.
 */
@Service
public class RegisterUserServiceImpl implements RegisterUserService{

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The password encoder. */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.services.security.RegisterUserService#save(java.lang.String, java.lang.String)
	 * Guarda un usuario. Previamente encripta la contraseña antes de guardarla en la base de datos.
	 */
	public void save(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
	}

}
