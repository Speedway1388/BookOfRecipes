package com.softserve.edu.items.dto;

public class UserDto {

    private String username;
    private String email;
    private String password;
    private Integer isactive;
    private Integer isadmin;

    public UserDto(String username, String email, String password, Integer isactive, Integer isadmin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isactive = isactive;
        this.isadmin = isadmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public Integer getIsadmin() {
        return isadmin;
    }
}
