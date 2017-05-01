package com.canvas8.models.notused;//package com.canvas8.models.notussed;
//
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//import org.hibernate.annotations.Type;
//import org.joda.time.LocalDate;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Set;
//
///**
// * Created by mrnimelo on 30/04/17.
// */
//@Entity
//@Table(name = "USERS")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "USR_ID", unique = true, nullable = false)
//    private int id;
//
//    @NotNull
//    @Size(max = 50)
//    @Column(name = "USR_FIRST_NAME", nullable = false)
//    private String firstName;
//
//    @NotNull
//    @Size(max = 50)
//    @Column(name = "USR_SECOND_NAME", nullable = false)
//    private String secondName;
//
//    @NotNull
//    @Column(name = "USR_EMAIL", nullable = false, unique = true)
//    private String email;
//
//    @NotNull
//    @Column(name = "USR_HASH_PASSWORD", nullable = false)
//    private String password;
//
//    @NotNull
//    @Column(name = "USR_LOCKED", nullable = false, columnDefinition = "boolean default false")
//    private Boolean locked = false;
//
//    @NotNull
//    @Column(name = "USR_ENABLED", nullable = false, columnDefinition = "boolean default true")
//    private Boolean enabled = true;
//
//    @NotNull
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Column(name = "USR_CREATED_DATE", nullable = false)
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
//    private LocalDate createdDate;
//
//    @NotNull
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Column(name = "USR_EXPIRY_DATE", nullable = false)
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
//    private LocalDate expiryDate;
//
//    @NotNull
//    @Column(name = "USR_POST_CODE", nullable = false)
//    private String postCode;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "USR_CG_ID", referencedColumnName = "CG_ID")
//    private CorporateGroup corporateGroup;
//
//    @OneToMany(mappedBy = "user")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<UserRole> userRoles;
//
//    public Set<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(Set<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Boolean getLocked() {
//        return locked;
//    }
//
//    public void setLocked(Boolean locked) {
//        this.locked = locked;
//    }
//
//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public LocalDate getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public LocalDate getExpiryDate() {
//        return expiryDate;
//    }
//
//    public void setExpiryDate(LocalDate expiryDate) {
//        this.expiryDate = expiryDate;
//    }
//
//    public String getPostCode() {
//        return postCode;
//    }
//
//    public void setPostCode(String postCode) {
//        this.postCode = postCode;
//    }
//
//    public CorporateGroup getCorporateGroup() {
//        return corporateGroup;
//    }
//
//    public void setCorporateGroup(CorporateGroup corporateGroup) {
//        this.corporateGroup = corporateGroup;
//    }
//}
