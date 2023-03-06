package com.myimdb.imdbService.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myimdb.imdbService.entity.Film;

@Repository
public interface IMDBRepository extends JpaRepository<Film, Long> {

	List<Film> findByGenre(String genre);

}
