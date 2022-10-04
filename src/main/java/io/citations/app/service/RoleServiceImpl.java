package io.citations.app.service;

import io.citations.app.entity.Role;
import io.citations.app.entity.User;
import io.citations.app.repository.RoleRepository;
import io.citations.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role editRole(String roleName, String NewRoleName) {
        Role role = roleRepository.findByRoleName(roleName);
        role.setRoleName(NewRoleName);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user=userRepository.findByEmail(email);
        Role role=roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public void deleteRole(String roleName) {
        Role role = roleRepository.findByRoleName(roleName);
        roleRepository.deleteById(role.getId());
    }

    @Override
    public Role showOneRole(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> showAllRoles() {
        return roleRepository.findAll();
    }
}
