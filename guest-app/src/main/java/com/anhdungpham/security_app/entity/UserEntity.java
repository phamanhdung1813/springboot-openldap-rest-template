package com.anhdungpham.security_app.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="USER")
public class UserEntity {
    @Id
    @Column(name="USER_ID")
    private long id;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="USERNAME", nullable = false, unique = true)
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
