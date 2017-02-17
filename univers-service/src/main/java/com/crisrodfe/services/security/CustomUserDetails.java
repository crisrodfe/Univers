package com.crisrodfe.services.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * The Class CustomUserDetails.
 */
public class CustomUserDetails extends User {

	/**
	 * Instantiates a new custom user details.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 * @param accountNonExpired the account non expired
	 * @param credentialsNonExpired the credentials non expired
	 * @param accountNonLocked the account non locked
	 * @param authorities the authorities
	 */
	public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
							 boolean credentialsNonExpired, boolean accountNonLocked,
							 Collection<? extends GrantedAuthority> authorities) 
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

	}

}
