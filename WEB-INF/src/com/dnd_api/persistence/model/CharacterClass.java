package com.dnd_api.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CHARACTER_CLASS")
public class CharacterClass {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy="increment")
	int id;
	
	@Column(name="CLASS_NAME") 
	String className;
	
	@Column(name="DESCRIPTION") 
	String description;
	
	public CharacterClass() {}
	
	public int getId() {
		return id;
	}
	public void setClassId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
