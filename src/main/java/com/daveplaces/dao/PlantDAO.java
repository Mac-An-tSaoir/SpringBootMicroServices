package com.daveplaces.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.PlantList;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class PlantDAO implements IPlantDAO {
	
	@Autowired
	NetworkDAO networkDAO;
	
	@Override
	public List<PlantDTO> fetch/*Manually*/(String searchFilter) throws Exception {
		List<PlantDTO> allPlants = new ArrayList<PlantDTO>();
		//System.out.println("\nfetch() "+searchFilter+", allPlants size is zero: "+ allPlants.size()+"\n");
		String rawJSON = networkDAO.request("https://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name="+searchFilter);
		
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
			//System.out.println(plant.toString());
		}
		//System.out.println("Size of collection: "+allPlants.size());
		return allPlants;
	}

	//@Override
	public List<PlantDTO> fetchManually(String searchFilter) throws Exception {
		//to fix MalformedJsonException
		//Gson gson = new GsonBuilder().setLenient().create();
		
		
		Retrofit retrofit = new Retrofit.Builder()
							.baseUrl("https://www.plantplaces.com/")
							.addConverterFactory(GsonConverterFactory.create())
							.build();
		
		GetPlants getPlants = retrofit.create(GetPlants.class);
		
		//to remove MalformedJsonException with JSON, trim whitespace off string.
		//String trimmedString = searchFilter.trim();
		
		Call<PlantList> allPlants = getPlants.getAllPlants(searchFilter);
		
		Response<PlantList> execute = allPlants.execute();
		PlantList plantList = execute.body();
		
		List<PlantDTO> plants = plantList.getPlants();
		// TODO Auto-generated method stub
		return plants;
	}
}
