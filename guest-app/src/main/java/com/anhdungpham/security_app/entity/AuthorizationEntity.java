package com.anhdungpham.security_app.entity;

import javax.persistence.*;

@Entity
@Table(name="AUTH_USER")
public class AuthorizationEntity {
    @Id
    @Column(name="AUTH_USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="AUTH_GROUP", nullable = false)
    private String authGroup;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }
}