package com.myimdb.imdbService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMDBRepository extends JpaRepository<Film, Long> {

}
