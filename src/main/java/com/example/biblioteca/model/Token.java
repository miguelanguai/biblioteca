package com.example.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * The value of the authentication token assigned to the user.
     */
    @Column(name = "token")
    private String token;

    /**
     * Indicates whether the user has logged out. true if the user is logged out,
     * false otherwise.
     */
    @Column(name = "is_logged_out")
    private boolean loggedOut;

    /**
     * The user associated with this token. The relationship is many-to-one, where a
     * user can have multiple tokens.
     */
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private UserEntity user;

    /**
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * @param token new value of {@link #getToken}.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 
     * @return isLoggedOut
     */
    public boolean getIsLoggedOut() {
        return loggedOut;
    }

    /**
     * 
     * @param isLoggedOut new value of {@link #getIsLoggedOut}.
     */
    public void setLoggedOut(boolean loggedOut) {
        this.loggedOut = loggedOut;
    }

    /**
     * 
     * @return {@link UserEntity}
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * 
     * @param {@link UserEntity} new value of {@link #getUser}.
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }
}
