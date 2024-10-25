package com.daveplaces.dao;

import org.springframework.data.repository.CrudRepository;

import com.daveplaces.dto.PhotoDTO;

public interface PhotoRepository extends CrudRepository<PhotoDTO, Integer> {

}
