package com.daveplaces;

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

@Controller
public class DavePlacesController {
	
	@Autowired
	private ISpecimenService specimenService;
	
	@RequestMapping(value="/savespecimen")
	public String saveSpecimen(SpecimenDTO specimenDTO) {
		specimenDTO.setPlantId(14);
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
	public String searchPlants(@RequestParam(value="searchTerm", required=false, defaultValue="") String searchTerm) {
		String url_Term = searchTerm + ", ";
		List<PlantDTO> fetchPlants = specimenService.fetchPlants(searchTerm); 
		return "start";
	}
	
	@RequestMapping("/searchPlantsAll")
	public String searchPlantsAll(@RequestParam Map<String, String> requestParams) {
		
		int params = requestParams.size();
		requestParams.get("searchTerm");
		return "start";
	}
	
	
	

}
