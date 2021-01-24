package com.hegyi.pma.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
	private Long roleId;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, 
				mappedBy = "roles")
	private Set<UserAccount> userAccounts;

	public Role() {}
	
	public Role(String name, Set<UserAccount> userAccounts) {
		this.name = name;
		this.userAccounts = userAccounts;
	}

	public Long getId() {
		return roleId;
	}

	public void setId(Long id) {
		this.roleId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(Set<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", userAccounts=" + userAccounts + "]";
	}

	

	
	

}













