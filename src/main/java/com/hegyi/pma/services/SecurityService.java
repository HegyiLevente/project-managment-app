package com.hegyi.pma.services;

public interface SecurityService {

	public boolean isAuthenticated();
	
	void autoLogin(String username, String password);
	
}
