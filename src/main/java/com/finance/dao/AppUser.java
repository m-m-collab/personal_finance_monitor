package com.finance.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entity model of the AppUser table.
 */
@EqualsAndHashCode
@Entity
@Data
@NoArgsConstructor
@Table(name = "AppUser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private AppUserType appUserRole;

    @Column(name = "Locked", nullable = false)
    private Boolean locked;

    @Column(name = "Enabled", nullable = false)
    private Boolean enabled;
    ;

    public AppUser(Long id, String username, String email, String password, AppUserType appUserRole, Boolean locked, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    /**
     * Fluent style API fashion appUser builder.
     */
    public AppUser withId(Long id){
        this.id = id;
        return this;
    }

    public AppUser withUsername(String username){
        this.username = username;
        return this;
    }

    public AppUser withEmail(String email){
        this.email = email;
        return this;
    }

    public AppUser withPassword(String password){
        this.password = password;
        return this;
    }

    public AppUser withAppUserRole(AppUserType appUserRole){
        this.appUserRole = appUserRole;
        return this;
    }

    public AppUser isLocked(Boolean locked){
        this.locked = locked;
        return this;
    }

    public AppUser isEnabled(Boolean enabled){
        this.enabled = enabled;
        return this;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", appUserRole=" + appUserRole +
                ", locked=" + locked +
                ", enabled=" + enabled +
                '}';
    }
}
