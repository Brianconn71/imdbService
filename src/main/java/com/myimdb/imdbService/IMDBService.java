package com.myimdb.imdbService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myimdb.imdbService.dao.IMDBRepository;
import com.myimdb.imdbService.dao.GenreRepository;
import com.myimdb.imdbService.exceptions.ResourceNotFoundException;
import com.myimdb.imdbService.entity.Film;
import com.myimdb.imdbService.entity.Genre;

@RestController
@Service
public class IMDBService {

	@Autowired
	IMDBRepository imdbRepo;
	
	@Autowired
	GenreRepository genreRepo;
	
	@GetMapping(value="/films")
	List<Film> getFilmsForGenres(){
		return imdbRepo.findAll();
	}
	
	@GetMapping(value="/genres")
	List<Genre> getGenres(){
		return genreRepo.findAll();
	}
	
	@GetMapping(value = "/{genre}")
	List<Film> getGenre(@PathVariable("genre") String genre) {
		return imdbRepo.findByGenre(genre);

	}
	
	@GetMapping(value="/films/{id}")
	public ResponseEntity<Film> getFilm(@PathVariable("id") Long id) throws ResourceNotFoundException {
		Optional<Film> film = imdbRepo.findById(id);
		if(film.isPresent())
            return ResponseEntity.ok().body(film.get());
        else
            throw new ResourceNotFoundException("Film was not found " + id);
	}
	
	@PostMapping(value="/films")
	ResponseEntity<Film> insertFilm(@RequestBody Film film){
		Film savedFilm = imdbRepo.save(film);
		return new ResponseEntity<Film>(savedFilm, HttpStatus.OK);
	}
	
//	Send back a link to the product in the header
//	@PostMapping(value="/films")
//	ResponseEntity<Film> insertFilm(@Valid @RequestBody Film film){
//		Film savedFilm = imdbRepo.save(film);
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedFilm.getId())
//				.toUri();
//		return ResponseEntity.created(location).build();
//	}
	
	@DeleteMapping(value="/films/{id}")
	ResponseEntity<Film> deleteFilm(@PathVariable("id") Long id){
		// Fetch film and then delete
		Optional<Film> optionalFilm = imdbRepo.findById(id);
		Film existingFilm=optionalFilm.get();
		
		// Return deleted Film
		imdbRepo.delete(existingFilm);
		return new ResponseEntity<Film>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/films/{id}")
	ResponseEntity updateFilm(@PathVariable("id") Long id, @RequestBody Film film) {
		// find an existing film to modify
		Optional<Film> optionalFilm = imdbRepo.findById(id);
		Film existingFilm=optionalFilm.get();
		existingFilm.setName(film.getName());
		Film savedFilm = imdbRepo.save(existingFilm);
		
		// return updated film
		return new ResponseEntity<Film>(savedFilm, HttpStatus.OK);
	}
	
}
