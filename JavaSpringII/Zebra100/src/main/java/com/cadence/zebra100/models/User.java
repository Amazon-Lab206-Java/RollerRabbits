package com.cadence.zebra100.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
    private String name;
    
    @Size(min=8)
    private String password;
    @Transient
    private String passwordConfirmation;
    
    @Size(min=2)
    private String description;
    
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
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "network", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "network_id"))
    private List<User> network;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "network", 
        joinColumns = @JoinColumn(name = "network_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userNetwork;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "invites", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "invite_id"))
    private List<User> myInvites;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "invites", 
        joinColumns = @JoinColumn(name = "invite_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> invitesToMe;
    
    public User() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }
    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<User> getNetwork() {
		return network;
	}
	public void setNetwork(List<User> network) {
		this.network = network;
	}
	public List<User> getUserNetwork() {
		return userNetwork;
	}
	public void setUserNetwork(List<User> userNetwork) {
		this.userNetwork = userNetwork;
	}
	public List<User> getMyInvites() {
		return myInvites;
	}
	public void setMyInvites(List<User> myInvites) {
		this.myInvites = myInvites;
	}
	public List<User> getInvitesToMe() {
		return invitesToMe;
	}
	public void setInvitesToMe(List<User> invitesToMe) {
		this.invitesToMe = invitesToMe;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Date getLastSignedIn() {
		return lastSignedIn;
	}
	public void setLastSignedIn(Date lastSignedIn) {
		this.lastSignedIn = lastSignedIn;
	}
    
}
