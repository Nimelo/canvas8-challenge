package com.canvas8.models;

import com.canvas8.utilis.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by mrnimelo on 30/04/17.
 */
@Entity
@Table(name = "USERS")
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID", unique = true, nullable = false)
    private int id;

    @Size(max = 50)
    @Column(name = "USR_FIRST_NAME")
    private String firstName;

    @Size(max = 50)
    @Column(name = "USR_SECOND_NAME")
    private String secondName;

    @NotNull
    @Column(name = "USR_EMAIL", unique = true)
    private String email;

    @NotNull
    @Column(name = "USR_HASH_PASSWORD", nullable = false)
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(name = "USR_LOCKED", columnDefinition = "boolean default false")
    private Boolean locked = false;

    @Column(name = "USR_ENABLED", columnDefinition = "boolean default true")
    private Boolean enabled = true;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "USR_CREATED_DATE")
    private Date createdDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "USR_EXPIRY_DATE")
    private Date expiryDate;

    @Column(name = "USR_POST_CODE")
    private String postCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USR_CG_ID", referencedColumnName = "CG_ID")
    private CorporateGroup corporateGroup;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "US_USER_ID",
                    foreignKey = @ForeignKey(name = "FK_US_USER_ID")),
            inverseJoinColumns = @JoinColumn(name = "US_ROLE_ID"),
            inverseForeignKey = @ForeignKey(name = "FK_US_ROLE_ID"))
    private Set<Role> roles;

    @PreRemove
    private void preRemove() {
        roles = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return DateUtils.isAfterCurrentTime(this.expiryDate);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isAccountNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public CorporateGroup getCorporateGroup() {
        return corporateGroup;
    }

    public void setCorporateGroup(CorporateGroup corporateGroup) {
        this.corporateGroup = corporateGroup;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
