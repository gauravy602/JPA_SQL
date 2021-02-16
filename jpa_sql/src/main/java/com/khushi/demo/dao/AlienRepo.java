package com.khushi.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.khushi.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
