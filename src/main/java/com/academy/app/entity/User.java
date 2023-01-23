package com.academy.app.entity;

import com.academy.app.entity.enm.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usr")
public class User extends BaseEntity {
    private String username;
    private String password;
    private Role role;
}
