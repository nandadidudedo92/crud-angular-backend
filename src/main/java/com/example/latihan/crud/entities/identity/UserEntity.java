package com.example.latihan.crud.entities.identity;

import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.*;

@Entity
@Table(name = "sys_user")
public class UserEntity extends AuditableBase {


    @Column(name = "username", length = 15)
    private String username;

    @Column(name = "password", length = 15)
    private String password;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_profilet_id")
    private UserProfileEntity userProfile;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserProfileEntity getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileEntity userProfile) {
        this.userProfile = userProfile;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
