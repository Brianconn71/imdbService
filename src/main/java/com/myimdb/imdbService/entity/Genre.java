package com.myimdb.imdbService.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Genres")
public class Genre implements Serializable {

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="genre_name")
	private String genreName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "film_genres",
		joinColumns = @JoinColumn(name = "genre_id"),
		inverseJoinColumns = @JoinColumn(name = "film_id"))
	private List<Film> films;
	
	public Genre()
    {
    }

    public Genre(String genreName)
    {
        this.genreName = genreName;
    }

    public Long getId()
    {
        return id;
    }

    public String getGenreName()
    {
        return genreName;
    }

    public void setGenreName(String genreName)
    {
        this.genreName = genreName;
    }
    public List<Film> getFilms()
    {
        return films;
    }

    public void setFilms(List<Film> films)
    {
        this.films = films;
    }
}
