package com.crisrodfe.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crisrodfe.module.entity.User;


/**
 * The Interface UserRepository.
 * Hereda de JpaRepository, no tendremos que implementar métodos propios, haremos usos de los propios de la clase padre.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	@Query("select u from User u where u.username=:username")
	User findByUsername(@Param("username") String username);
}
