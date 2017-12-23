package com.cadence.unicorn.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	
	  @Id
	    @GeneratedValue
	    private Long id;
	    
	    private String email;
	    @Size(min=1)
	    private String firstName;
	    @Size(min=1)
	    private String lastName;
	    
	    
	  @Size(min=10)
	    private String password;
	    @Transient //throws away
	    private String passwordConfirmation;
	    private Date lastSignedIn;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "users_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private List<Role> roles;
	    
	    //getters and setters
}