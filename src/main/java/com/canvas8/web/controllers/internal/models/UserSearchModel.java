package com.canvas8.web.controllers.internal.models;

import java.io.Serializable;

/**
 * Created by mrnimelo on 03/05/17.
 */
public class UserSearchModel implements Serializable{
    private String firstName;
    private String secondName;
    private String email;
    private Integer corporateGroupId;

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

    public Integer getCorporateGroupId() {
        return corporateGroupId;
    }

    public void setCorporateGroupId(Integer corporateGroupId) {
        this.corporateGroupId = corporateGroupId;
    }
}
