package com.hegyi.pma.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hegyi.pma.dao.RoleRepository;
import com.hegyi.pma.dao.UserAccountRepository;
import com.hegyi.pma.entities.Role;
import com.hegyi.pma.entities.UserAccount;

@Service
public class UserAccountServiceImpl implements UserAccountService{
	
	private UserAccountRepository userAccountRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserAccountServiceImpl(UserAccountRepository userAccountRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
		this.userAccountRepository = userAccountRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.roleRepository = roleRepository;
	}

	@Override
	public void save(UserAccount user) {
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Role roleUser = this.roleRepository.findByName("USER");
		user.addRole(roleUser);
		
		this.userAccountRepository.save(user);
	}

	@Override
	public UserAccount findByUsername(String username) {
		return this.userAccountRepository.findByUsername(username);
	}

}
