package com.daveplaces.dao;

import org.springframework.data.repository.CrudRepository;

import com.daveplaces.dto.SpecimenDTO;

public interface SpecimenRepository extends CrudRepository<SpecimenDTO, Integer> {

}
