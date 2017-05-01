package com.canvas8.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mrnimelo on 30/04/17.
 */
@Entity
@Table(name = "ROLES")
public class Role {
    public final static int ROLE_USER_ID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RLS_ID")
    private int id;

    @Column(name = "RLS_DESCRPTION", nullable = true)
    private String description;

    @Column(name = "RLS_ROLE", unique = true, nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
