package com.daveplaces.dao;

import java.util.List;

import com.daveplaces.dto.PlantDTO;

public interface IPlantDAO {

	List<PlantDTO> fetch(String searchFilter) throws Exception;

}