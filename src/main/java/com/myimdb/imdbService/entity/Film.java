package com.myimdb.imdbService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Film implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Size(min=2, max=100)
	@Column(name = "film_name")
	private String name;
	
	@Column(name = "genre_id", nullable=false)
	private int genreId;
	
	public Film() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGenreId() {
		return genreId;
	}
	
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

}
