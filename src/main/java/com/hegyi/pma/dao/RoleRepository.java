package com.hegyi.pma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hegyi.pma.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByName(String name);
	

}
