package com.example.servingwebcontent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="myuser")
public class UserModel {
    private String username;
    private String mail;
    private String code_phone;
    private String phone;
    private String password;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    public UserModel(String username, String mail, String code_phone, String phone, String password) {
        this.username = username;
        this.mail = mail;
        this.code_phone = code_phone;
        this.phone = phone;
        this.password = password;
    }

    public UserModel() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode_phone() {
        return code_phone;
    }

    public void setCode_phone(String code_phone) {
        this.code_phone = code_phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
