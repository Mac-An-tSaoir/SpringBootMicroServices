package com.daveplaces.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
		
		String rawJSON = networkDAO.request("https://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Oak");
		
		JSONObject root = new JSONObject(rawJSON);
		
		JSONArray plants = root.getJSONArray("plants");
		
		for (int i = 0; i < plants.length(); i++) {
			// the JSON data
			JSONObject jsonPlant = plants.getJSONObject(i);
			
			// the Java Object that we build from the JSON data.
			PlantDTO plant = new PlantDTO();
			int guid = jsonPlant.getInt("id");
			String genus = jsonPlant.getString("genus");
			String species = jsonPlant.getString("species");
			String cultivar = jsonPlant.getString("cultivar");
			String common = jsonPlant.getString("common");
			
			// populate our DTO with this information
			plant.setGuid(guid);
			plant.setGenus(genus);
			plant.setSpecies(species);
			plant.setCultivar(cultivar);
			plant.setCommon(common);
			
			// add the populated plant to our collection
			allPlants.add(plant);
		}
		
		return allPlants;
	}
}
