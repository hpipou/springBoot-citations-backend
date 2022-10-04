package io.citations.app.service;

import io.citations.app.entity.Role;

import java.util.List;

public interface RoleService {
    Role addNewRole(Role role);
    Role editRole(String roleName, String NewRoleName);
    void addRoleToUser(String email, String roleName);
    void deleteRole(String roleName);
    Role showOneRole(Long id);
    List<Role> showAllRoles();
}
