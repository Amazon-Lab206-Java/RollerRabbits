package com.cadence.bunnydroppings.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
   
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "likes", 
            joinColumns = @JoinColumn(name = "idea_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id")
        )
    
    private List<Idea> ideas;
    
    @OneToMany(mappedBy="idea", fetch = FetchType.LAZY)
    private List<User> users;
    
   
    
}
