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
//import java.util.Set;
//
///**
// * Created by mrnimelo on 30/04/17.
// */
//@Entity
//@Table(name = "CORPORATE_GROUPS")
//public class CorporateGroup {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CG_ID", unique = true, nullable = false)
//    private int id;
//
//    @NotNull
//    @Column(name = "CG_NAME", nullable = false)
//    private String name;
//
//    @NotNull
//    @Column(name = "CG_EMAIL", nullable = false)
//    private String email;
//
//    @NotNull
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Column(name = "CG_CREATED_DATE", nullable = false)
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
//    private LocalDate createdDate;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "corporateGroup")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<User> users;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
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
//    public LocalDate getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//}
