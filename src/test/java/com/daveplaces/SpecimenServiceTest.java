package com.daveplaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.daveplaces.dao.ISpecimenDAO;
import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.SpecimenDTO;
import com.daveplaces.service.ISpecimenService;


//@RunWith(SpringRunner.class) //needed for Junit4

@SpringBootTest
public class SpecimenServiceTest {
	
	@Autowired
	ISpecimenService specimenService;
	List<PlantDTO> plants;
	private SpecimenDTO specimenDTO;
	
	@MockBean
	private ISpecimenDAO specimenDAO;
	
	@Before
	public void setup() throws Exception {
		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setDescription("A real beautiful Whitethorn,");
		specimenDTO.setSpecimenId(45);
		Mockito.when(specimenDAO.save(specimenDTO)).thenReturn(true);
		
		specimenService.setSpecimenDAO(specimenDAO);
	}
	
	@Test 
	public void saveSpecimen_whenRedbudEntered() {
		givenUserIsLoggedIntoMyPlantDiary();
		whenUserSearchesForEasternRedbud();
		whenUserAddsTextDetails();
		//thenSpecimenIsSaved();
	}
	
	private void whenUserSearchesForEasternRedbud() {
		plants = specimenService.fetchPlants("Eastern Redbud");
		
	}

	private void whenUserAddsTextDetails() {
		specimenDTO = new SpecimenDTO();
		PlantDTO plantDTO = plants.get(0);
		specimenDTO.setPlantId(plantDTO.getGuid());
		//specimen.setSpecimenId(specimenId);
		specimenDTO.setDescription("A beautiful Whitethorn, ");
		specimenDTO.setSpecimenId(45);
		
	}

	private void thenSpecimenIsSaved() {
		try {
			boolean successfulSave = specimenService.save(specimenDTO);
			//if we have made it to this line the test passes,
			assertTrue(successfulSave);
		} catch (Exception ex) {
			// we should not get here if the test passes
			System.out.println("thenSpecimenIsSaved "+ex);
			fail();
		}
	}

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
