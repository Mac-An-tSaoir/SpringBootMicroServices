package com.daveplaces;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.LabelValueDTO;
import com.daveplaces.dto.PhotoDTO;
import com.daveplaces.dto.PlantDTO;
import com.daveplaces.dto.ProductDTO;
import com.daveplaces.dto.SpecimenDTO;
import com.daveplaces.service.IProductService;
import com.daveplaces.service.ISpecimenService;

@Controller
public class DavePlacesController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ISpecimenService specimenService;

	private List<PlantDTO> allPlants;

	private String firstThreeCharacters;
	
	@PostMapping(value="/savespecimen")
	public ModelAndView saveSpecimen(@RequestParam("imageFile") MultipartFile imageFile, SpecimenDTO specimenDTO) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			specimenService.save(specimenDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("not able to save the specimen", e);
			e.printStackTrace();
			modelAndView.setViewName("viability"); //"error"
			return modelAndView;
		}
		//return "start";
		
		
		PhotoDTO photoDTO = new PhotoDTO();
		photoDTO.setFileName(imageFile.getOriginalFilename());
		photoDTO.setPath("/photos/"); //had commented this out, no need to do it.
		photoDTO.setSpecimenDTO(specimenDTO);
		modelAndView.setViewName("success");
		try {
			specimenService.saveImage(imageFile, photoDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error saving photo",e);
			modelAndView.setViewName("viability"); //"error"
		}
		modelAndView.addObject("photoDTO", photoDTO);
		modelAndView.addObject("specimenDTO", specimenDTO);
		return modelAndView;
	}

	
	/**
	 * Handle the /start endpoint
	 * @return
	 */

	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) {
		log.info("User has entered the /start endpoint");
		model.addAttribute("specimenDTO", new SpecimenDTO());
		return "start";
	}
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	
	 
	//@RequestMapping(value="/start", method=RequestMethod.GET)
	//@ResponseBody
	//public ProductDTO /*BarcodeDTO*/ read(Model model) { 
	//public ProductDTO read1(Model model) {
		//BarcodeDTO barcodeDTO = barcodeServiceStub.getScannedBarcode(9780321502797L);	
	//	List<ProductDTO> products = new ArrayList<>();
	//	products = barcodeServiceStub.fetchProduct(9780321502797L);
	//	ProductDTO sampleProduct = products.get(0);
		//model.addAttribute("barcodeDTO", barcodeDTO);
	//	model.addAttribute("productDTO", sampleProduct);
		//return barcodeDTO;
	//	return sampleProduct;
	//}
	
	
	@RequestMapping(value="/start", method=RequestMethod.GET, headers={"content-type=text/json"})
	@ResponseBody
	public SpecimenDTO readJSON(Model model) {
		SpecimenDTO specimenDTO = specimenService.fetchById(43);
		model.addAttribute("specimenDTO", specimenDTO);
		return specimenDTO;
	}
	
	/*@RequestMapping(value="/start", method=RequestMethod.GET, params={"loyalty=blue"})
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
	
	//@RequestMapping(value="/start", method=RequestMethod.GET)
	//public String read(Model model) {
	//	model.addAttribute("productDTO", new ProductDTO());

	public String read(Model model){
		log.info("User had entered the /start endpoint");
		model.addAttribute("specimenDTO", new SpecimenDTO());
		return "start";
	}
	
	/*
	@RequestMapping(value="/addBarcode", method=RequestMethod.GET)
	public String addBarcode(Model model, @RequestParam(value="type", required=false, defaultValue="?_type") String type) {
		BarcodeDTO barcodeDTO = barcodeServiceStub.getScannedBarcode(9780321502797L);
		barcodeDTO.setType(type);
		model.addAttribute("barcodeDTO", barcodeDTO);
		return "start";
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, params= {"loyalty=blue"})
	public String readBlue() {
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
	
	}
	
	@RequestMapping(value="/addspecimen", method=RequestMethod.GET)
	public String addSpecimen(Model model, @RequestParam(value="latitude", required=false, defaultValue="0.0") String latitude) {
		SpecimenDTO specimenDTO = specimenService.fetchById(43);
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		return "start";
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, params= {"loyalty=gold"})
	public ModelAndView readGold() {
		BarcodeDTO barcodeDTO = barcodeServiceStub.getScannedBarcode(9780321502797L);
		barcodeDTO.setBarcode(5333310580227L);
		barcodeDTO.setType("Dazoo");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("start");
		modelAndView.addObject("barcodeDTO", barcodeDTO);
		return modelAndView;
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
	
	/**
	 * Handle the /homePage endpoint
	 * @return
	 */
	@GetMapping("/homePage")
	public String storeBarcode() {
		return "homePage";
	}

	
	@RequestMapping("/viability")
	public String viability() {
		return "viability";
	}
	
	@RequestMapping("/showSpecimens")
	public ModelAndView showSpecimens() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Iterable<SpecimenDTO> allSpecimens = specimenService.fetchAllSpecimens();
			modelAndView.setViewName("showSpecimens");
			modelAndView.addObject("allSpecimens",allSpecimens);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("unable to retrieve specimens", e);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
	
	@RequestMapping("/plantNamesAutocomplete")
	@ResponseBody
	public List<LabelValueDTO> plantNamesAutocomplete(@RequestParam (value ="term", required = false, defaultValue = "") String term) {
		List<LabelValueDTO> suggestions = new ArrayList<LabelValueDTO>();
		try {
			//only update when term in three characters long
			if (term.length() == 3) {
				firstThreeCharacters = term;
				allPlants = specimenService.fetchPlants(term);
			}
			for (PlantDTO plantDTO : allPlants) {
				if (plantDTO.toString().contains(term)) {
					LabelValueDTO lv = new LabelValueDTO();
					lv.setLabel(plantDTO.toString());
					lv.setValue(String.valueOf(plantDTO.getGuid()));
					suggestions.add(lv);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Exception in autocomplete", e);
		}
		return suggestions;
	}
	
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
		String returnValue = "start";
		PhotoDTO photoDTO = new PhotoDTO();
		photoDTO.setFileName(imageFile.getOriginalFilename());
		photoDTO.setPath("/photos/");
		try {
			specimenService.saveImage(imageFile, photoDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error saving photo",e);
			returnValue = "error";
		}
		return returnValue;
	}
	
	@RequestMapping("/showSpecimenDetails")
	public String showSpecimenDetails(@RequestParam("plant_ID") int plantId) {
		String returnValue = "specimenDetails";
		List<SpecimenDTO> specimens = specimenService.fetchSpecimensByPlantId(plantId);
		return returnValue;
	}
	
	
	
	
	
	
	
	

}
