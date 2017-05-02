package com.canvas8.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by mrnimelo on 30/04/17.
 */
@Entity
@Table(name = "CORPORATE_GROUPS")
public class CorporateGroup implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CG_ID", unique = true, nullable = false)
    private int id;

    @NotNull
    @Column(name = "CG_NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "CG_EMAIL", nullable = false)
    private String email;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "CG_CREATED_DATE", nullable = false)
    private Date createdDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "corporateGroup", cascade = CascadeType.REMOVE)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Set<User> users;

    @PrePersist
    protected void onCreate(){
        createdDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
