package com.soecode.lyf.entity;

public class User {
    private Integer userId;

    private Integer userDepartment;

    private String password;

    private String account;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userDepartment=" + userDepartment +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(Integer userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}