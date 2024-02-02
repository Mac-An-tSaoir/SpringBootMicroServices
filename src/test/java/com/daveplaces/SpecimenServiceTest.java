package com.daveplaces;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.daveplaces.dto.PlantDTO;
import com.daveplaces.service.ISpecimenService;

//@RunWith(SpringRunner.class) needed for Junit4
@SpringBootTest
public class SpecimenServiceTest {
	
	@Autowired
	ISpecimenService specimenService;
	List<PlantDTO> plants;
	
	@Test
	public void fetchPlants_validateNoResultsForJunkData() {
		givenUserIsLoggedIntoMyPlantDiary();
		whenTheUserSearchesForJunk();
		thenMyPlantDiaryReturnsZeroResults();
	}

	private void givenUserIsLoggedIntoMyPlantDiary() {
		
	}

	private void whenTheUserSearchesForJunk() {
		plants = specimenService.fetchPlants("kasdf;joiuern;al;kd");
	}

	private void thenMyPlantDiaryReturnsZeroResults() {
		assertEquals("Number of plants returned", 0, plants.size());
	}

}
