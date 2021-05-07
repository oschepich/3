package com.amr.project.service.abstracts;


import com.amr.project.model.entity.Role;

import java.util.List;

public interface RoleService<T>{

//    T getRoleById(Long id);

    Role getByRoleName(String name);

    public List<Role> getListRole();

}
