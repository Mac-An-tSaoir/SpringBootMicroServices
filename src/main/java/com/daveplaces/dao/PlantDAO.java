package com.daveplaces.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daveplaces.dto.PlantDTO;

@Component
public class PlantDAO implements IPlantDAO {
	
	@Autowired
	NetworkDAO networkDAO;
	
	@Override
	public List<PlantDTO> fetch(String searchFilter) throws Exception {
		List<PlantDTO> allPlants = new ArrayList<PlantDTO>();
		
		networkDAO.request("https://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Oak");
		
		return allPlants;
	}
}
