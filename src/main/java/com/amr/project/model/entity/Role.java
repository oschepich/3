package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true)
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
