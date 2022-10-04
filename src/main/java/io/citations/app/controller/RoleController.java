package io.citations.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.citations.app.entity.Role;
import io.citations.app.service.RoleService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/")
    public Role addNewRole(@RequestBody Role role){
        return roleService.addNewRole(role);
    }

    @PatchMapping("/")
    public void editRole(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String roleName = request.getParameter("roleName");
        String NewRoleName = request.getParameter("newRoleName");
        roleService.editRole(roleName, NewRoleName);
        new ObjectMapper().writeValue(response.getOutputStream(),"Role Edited SUCCESS");
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String email = request.getParameter("email");
        String roleName = request.getParameter("roleName");
        roleService.addRoleToUser(email,roleName);
        new ObjectMapper().writeValue(response.getOutputStream(), "Role Add to Used SUCCESS");
    }

    @DeleteMapping("/")
    public void deleteRole(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String roleName=request.getParameter("roleName");
        roleService.deleteRole(roleName);
        new ObjectMapper().writeValue(response.getOutputStream(),"Role Name Deleted");
    }

    @GetMapping("/{id}")
    public Role showOneRole(@PathVariable Long id){
        return roleService.showOneRole(id);
    }

    @GetMapping("/")
    public List<Role> showAllRoles(){
        return roleService.showAllRoles();
    }
}
