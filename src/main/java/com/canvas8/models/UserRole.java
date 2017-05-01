package com.canvas8.models;

import javax.persistence.*;

/**
 * Created by mrnimelo on 30/04/17.
 */
@Entity
@Table(name = "USER_ROLES",
        uniqueConstraints = @UniqueConstraint(columnNames = {"UR_USR_ID", "UR_RLS_ID"}))
public class UserRole {

    @Id
    @Column(name = "UR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "USR_ID", name = "UR_USR_ID")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "RLS_ID", name = "UR_RLS_ID")
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
