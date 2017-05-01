package com.canvas8.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrnimelo on 30/04/17.
 */
@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RLS_ID")
    private int id;

    @Column(name = "RLS_DESCRPTION", nullable = true)
    private String description;

    @Column(name = "RLS_ROLE", unique = true, nullable = false)
    private String role;

    @OneToMany(mappedBy = "role")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<UserRole> roleUsers = new HashSet<UserRole>();

    public Set<UserRole> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<UserRole> roleUsers) {
        this.roleUsers = roleUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
