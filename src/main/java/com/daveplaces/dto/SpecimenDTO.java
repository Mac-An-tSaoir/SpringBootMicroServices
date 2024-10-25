package com.daveplaces.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="specimens")
public class SpecimenDTO {
	
	@Id
	@GeneratedValue
	@Column(name="SPECIMEN_ID")
	private int specimenId;
	@Column(name="LATITUDE")
	private String latitude;
	@Column(name="LONGITUDE")
	private String longitude;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="PLANT_ID")
	private int plantId;
	@Column(name="PLANT_NAME")
	private String plantName;
	
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
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return specimenId+": "+plantName+";  \tLatitude: "+latitude+"  \nLongitude: "+longitude+
					"  \nDescription: "+description+"   Plant Id: "+plantId;
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
