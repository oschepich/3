package com.amr.project.service.abstracts;


import com.amr.project.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService<T>{

    User findUserByEmail(String email);

//    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

}
