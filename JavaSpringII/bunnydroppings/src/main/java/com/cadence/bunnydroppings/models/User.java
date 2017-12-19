package com.cadence.bunnydroppings.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private String firstName;
    @Size(min=1)
    private String alias;
    
    
    @Size(min=8)
    private String password;
    @Transient
    private String passwordConfirmation;
    private Date lastSignedIn;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
   
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Idea> ideas;
    
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Like> likes;
    
    public User() {
    	
    }
    
    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getAlias() {
			return alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
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

		public Date getLastSignedIn() {
			return lastSignedIn;
		}

		public void setLastSignedIn(Date lastSignedIn) {
			this.lastSignedIn = lastSignedIn;
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

		public List<Idea> getIdeas() {
			return ideas;
		}

		public void setIdeas(List<Idea> ideas) {
			this.ideas = ideas;
		}

		public List<Like> getLikes() {
			return likes;
		}

		public void setLikes(List<Like> likes) {
			this.likes = likes;
		}
		
		
    	@PrePersist
        protected void onCreate(){
            this.createdAt = new Date();
        }
        @PreUpdate
        protected void onUpdate(){
            this.updatedAt = new Date();
          
    }

    }