package com.cadence.bunnydroppings.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="ideas")
public class Idea {
    
    @Id
    @GeneratedValue
    private Long id;
    

    private String firstName;
    @Size(min=1)
    private String body;
    private String likes;
   
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn (name="likes")
    private Idea idea;
    
    public User() {
    	
    }
public class Idea {

}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public String getLikes() {
	return likes;
}
public void setLikes(String likes) {
	this.likes = likes;
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

