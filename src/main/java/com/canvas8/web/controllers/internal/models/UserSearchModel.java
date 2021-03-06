package com.canvas8.web.controllers.internal.models;

import java.io.Serializable;

public class UserSearchModel implements Serializable {
    private String firstName;
    private String secondName;
    private String email;
    private int corporateGroupId;

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

    public int getCorporateGroupId() {
        return corporateGroupId;
    }

    public void setCorporateGroupId(int corporateGroupId) {
        this.corporateGroupId = corporateGroupId;
    }
}
