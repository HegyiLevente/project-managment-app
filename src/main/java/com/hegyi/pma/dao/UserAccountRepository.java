package com.hegyi.pma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hegyi.pma.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	public UserAccount findByUsername(String username);

}
