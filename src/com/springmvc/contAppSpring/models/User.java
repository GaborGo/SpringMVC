package com.springmvc.contAppSpring.models;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name="users")
public class User {
	    @Id
	    @Column(name="idUser")
	    private int id;
	    @Column(name="firmId")
	    private int firmId;
	    @Column(name="username")
	    private String username;
	    @Column(name="password")
	    private String password;
	    @Column(name="email")
	    private String email;
	    @Column(name="role")
	    private String role;

	    public User() {
	    }

	    public User(int id, int firmId, String username, String password, String email, String role) {
	        this.id = id;
	        this.firmId = firmId;
	        this.username = username;
	        this.password = password;
	        this.email = email;
	        this.role = role;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getFirmId() {
	        return firmId;
	    }

	    public void setFirmId(int firmId) {
	        this.firmId = firmId;
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

}
