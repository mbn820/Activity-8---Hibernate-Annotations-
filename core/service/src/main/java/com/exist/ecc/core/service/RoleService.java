package com.exist.ecc.core.service;

import com.exist.ecc.core.dao.RoleDao;
import com.exist.ecc.core.model.Role;
import java.util.List;

public class RoleService {
	public Integer addRole(Role role) {
		return new RoleDao().addRole(role);
	}

	public Role getRole(int id) {
		return new RoleDao().getRole(id);
	}

	public List<Role> getAllRoles() {
		return new RoleDao().getAllRoles();
	}

	public void updateRole(Role role) {
		new RoleDao().updateRole(role);
	}

	public void deleteRole(int id) throws Exception {
		if( !getRole(id).getPersons().isEmpty() ) {
			throw new Exception();
		} else {
			new RoleDao().deleteRole(id);
		}
	}

	public boolean roleAlreadyExists(Role role) {
		return getAllRoles().contains(role);
	}

	// public void viewRoles() {
	// 	System.out.printf("%-5s %-10s %s\n", "ID", "ROLE", "PERSONS");
	// 	getAllRoles().forEach(role -> System.out.printf("%-5s %-10s %s\n", role.getId(), role.getRoleName(), role.getPersons()));
	// }

	public void viewRoles() {
		System.out.printf("%-5s %-10s %s\n", "ID", "ROLE", "PERSONS");
		getAllRoles().forEach(role -> System.out.printf("%-5s %-10s\n", role.getId(), role.getRoleName()));
	}
}
