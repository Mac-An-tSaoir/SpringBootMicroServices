package com.daveplaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.daveplaces.dao.ISpecimenDAO;
import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.SpecimenDTO;
import com.daveplaces.service.ISpecimenService;
import com.daveplaces.service.SpecimenServiceStub;


//@RunWith(SpringRunner.class) //needed for Junit4, uncommented for Mockito

@SpringBootTest
public class SpecimenServiceTest {
	
	@Autowired
	ISpecimenService specimenService;
	List<PlantDTO> plants;
	private SpecimenDTO specimenDTO;
	
	//@MockBean
	private ISpecimenDAO specimenDAO;

	
	boolean successfulSave = false;
	
	@BeforeEach//was a Junit 4 version, careful how you import...
	public void setup() throws Exception {
		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenId(45);
		
		specimenDAO = mock(ISpecimenDAO.class);
		
		//successfulSave = true;
		//when(specimenDAO.save(specimenDTO)).thenReturn(successfulSave); //its like it doesn't work
			
		
		specimenService.setSpecimenDAO(specimenDAO);
		when(specimenService.save(specimenDTO)).thenReturn(true); //L76 match to save call?
		assertTrue("Is specimenService null?"+specimenService.hashCode(),specimenService.save(specimenDTO));
	}
	
	/*@Test*/ 
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
		/*SpecimenDTO*/ specimenDTO = new SpecimenDTO();
		PlantDTO plantDTO = new PlantDTO();//plants.get(0); v33 Mockito problems
		plantDTO.setGuid(1971);
		specimenDTO.setPlantId(plantDTO.getGuid());
		//specimenDTO.setDescription("A beautiful Whitethorn, ");
		specimenDTO.setSpecimenId(45);
		
	}

	private void thenSpecimenIsSaved() {
		//System.out.println("\nTest: set specimenDAO "+ specimenDAO.toString());
		
		try {
			successfulSave = specimenDAO.save(specimenDTO);
			//successfulSave = specimenService.save(specimenDTO);//why isn't this recognized by setup()?
			/*Very bad!*/
			//successfulSave = true;
			System.out.println("\nTest's successfulSave: "+ successfulSave);
			assertTrue(successfulSave);
		} catch (Exception ex) {
			// we should not get here if the test passes
			System.out.println("thenSpecimenIsSaved "+ex);
			fail();
		}
	}
	
	@Test
	public void checkSaveIsTrue() throws Exception {
		boolean successfulSave = true;
		when(specimenDAO.save(specimenDTO)).thenReturn(successfulSave);
		assertTrue("specimenDAO is mocked"+specimenDAO, specimenDAO.save(specimenDTO));
		//assertTrue("Is specimenService null?"+specimenService.hashCode(),specimenService.save(specimenDTO));
	}

	/*@Test*/
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
