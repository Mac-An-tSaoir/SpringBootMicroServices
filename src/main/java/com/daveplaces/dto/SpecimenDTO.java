package com.daveplaces.dto;

public class SpecimenDTO {
	
	private int specimenId;
	private String latitude;
	private String longitude;
	private String description;
	private int plantId;
	
	public int getSpecimenId() {
		return specimenId;
	}
	public void setSpecimenId(int specimenId) {
		this.specimenId = specimenId;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SpecimenId: "+specimenId+"\n Latitude: "+latitude+"\nLongitude: "+longitude+
					"\nDescription: "+description+" Plant Id: "+plantId;
	}
	
	@Override
	public boolean equals(Object obj) {
		//assume they don't match
		boolean result = false;
		if (obj instanceof SpecimenDTO) {
			SpecimenDTO incomingDTO = (SpecimenDTO) obj;
			//compare incomingDTO's id our our id, if equal result is true
			result = (incomingDTO.getSpecimenId() == this.getSpecimenId());
		}
		System.out.println("SpecimenDTO's equals(): "+result);
		return result;
	}

}
