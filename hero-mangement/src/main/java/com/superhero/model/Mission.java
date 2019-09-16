package com.superhero.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="TBL_MISSIONS")
public class Mission {
 
    @Id
    @GeneratedValue
    private Long id;
     
    @Column(name="mission_name")
    private String missionName;
     
    @Column(name="is_deleted")
    private Boolean isDeleted;
     
    @Column(name="is_completed")
    private Boolean isCompleted;
    
   
         
    @Override
    public String toString() {
        return "Mission [id=" + id + ", missionName=" + missionName +
                ", isDeleted=" + isDeleted + ", isCompleted=" + isCompleted   + "]";
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}