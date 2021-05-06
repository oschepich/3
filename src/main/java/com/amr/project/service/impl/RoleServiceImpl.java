package com.amr.project.service.impl;


import com.amr.project.dao.abstracts.RoleRepository;
import com.amr.project.model.entity.Role;
import com.amr.project.service.abstracts.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByRole(name);
    }

    @Override
    public List<Role> getListRole() {
        return roleRepository.findAll();
    }


}
