package com.daveplaces;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.SpecimenDTO;
import com.daveplaces.service.ISpecimenService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Controller
public class DavePlacesController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ISpecimenService specimenService;
	
	@RequestMapping(value="/savespecimen")
	public String saveSpecimen(SpecimenDTO specimenDTO) {
		specimenDTO.setDescription("A Whitethorn Tree");
		specimenDTO.setPlantId(1971);
		specimenDTO.setLatitude("52.67");
		specimenDTO.setLongitude("-8.63");
		try {
			specimenService.save(specimenDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("not able to save the specimen", e);
			e.printStackTrace();
			return "error";
		}
		return "start";
	}
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET, headers={"content-type=text/json"})
	@ResponseBody
	public SpecimenDTO readJSON(Model model) {
		SpecimenDTO specimenDTO = specimenService.fetchById(43);
		model.addAttribute("specimenDTO", specimenDTO);
		return specimenDTO;
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, params={"loyalty=blue"})
	public String readBlue() {
		return "start";
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, params={"loyalty=silver"})
	public ModelAndView readSilver() {
		SpecimenDTO specimenDTO = specimenService.fetchById(43);
		specimenDTO.setSpecimenId(71);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("start");
		modelAndView.addObject("specimenDTO", specimenDTO);
		return modelAndView;
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model){
		log.info("User had entered the /start endpoint");
		model.addAttribute("specimenDTO", new SpecimenDTO());
		return "start";
	}
	
	@RequestMapping(value="/addspecimen", method=RequestMethod.GET)
	public String addSpecimen(Model model, @RequestParam(value="latitude", required=false, defaultValue="0.0") String latitude) {
		SpecimenDTO specimenDTO = specimenService.fetchById(43);
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		return "start";
	}
	
	@PostMapping("/start")
	public String create() {
		return "fallback"; //only works in Postman, doesn't in browser.
	}
	
	/**
	 * Handle the / endpoint
	 * @return
	 */
	@PostMapping("/default")
	public String index() {
		return "default";
	}
	
	@RequestMapping("/searchPlants")
	public ModelAndView searchPlants(@RequestParam(value="searchTerm", required=false, defaultValue="") String searchTerm) {
		log.debug("Entering search plants ");
		log.info("INFO searchTerm: "+ searchTerm + ", length: "+searchTerm.length());
		ModelAndView modelAndView = new ModelAndView();
		List<PlantDTO> plants = new ArrayList<PlantDTO>();
		try {
			 plants = specimenService.fetchPlants(searchTerm);
			 modelAndView.setViewName("plantResults"); //"viability" used as placeholder
			 if (plants.size() == 0 ) {
				 log.warn("Received 0 results for search string: "+searchTerm);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error happened in /searchPlants endpoint ", e);
			
			//e.printStackTrace();
			//modelAndView.setViewName("viability"); //"error" to be built
			modelAndView.setViewName("plantResults");
		} 
		modelAndView.addObject("plants",plants);
		log.debug("Exiting search plants ");
		return modelAndView;
	}
	
	@RequestMapping("/searchPlantsAll")
	public String searchPlantsAll(@RequestParam Map<String, String> requestParams) {
		
		int params = requestParams.size();
		requestParams.get("searchTerm");
		return "start";
	}
	
	@RequestMapping("/viability")
	public String viability() {
		return "viability";
	}
	
	
	

}
