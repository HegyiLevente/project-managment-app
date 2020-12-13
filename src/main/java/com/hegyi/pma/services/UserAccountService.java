package com.hegyi.pma.services;

import com.hegyi.pma.entities.UserAccount;

public interface UserAccountService {
	
	void save(UserAccount user);
	
	UserAccount findByUsername(String username);

}
