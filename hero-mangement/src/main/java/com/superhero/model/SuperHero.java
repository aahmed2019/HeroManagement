package com.superhero.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
 
@Entity
@Table(name="TBL_HEROES")
public class SuperHero {
 
    @Id
    @GeneratedValue
    private Long id;
     
    @Column(name="first_name")
    private String firstName;
     
    @Column(name="last_name")
    private String lastName;
     
    @Column(name="superhero_name")
    private String superHeroName;
     
    
 
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "HEROES_MISSIONS",
            joinColumns = { @JoinColumn(name = "heroes_id") },
            inverseJoinColumns = { @JoinColumn(name = "missions_id") })
    private List<Mission> missions = new ArrayList<Mission>();

 
    public List<Mission> getMissions() {
		return missions;
	}



	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}



	@Override
    public String toString() {
        return "SuperHero [id=" + id + ", firstName=" + firstName +
                ", lastName=" + lastName + ", superHeroName=" + superHeroName   + "]";
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



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getSuperHeroName() {
		return superHeroName;
	}



	public void setSuperHeroName(String superHeroName) {
		this.superHeroName = superHeroName;
	}
}