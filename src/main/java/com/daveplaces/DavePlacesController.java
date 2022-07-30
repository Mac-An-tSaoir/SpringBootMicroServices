package com.daveplaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.service.IBarcodeService;

@Controller
public class DavePlacesController {
	
	@Autowired
	private IBarcodeService barcodeServiceStub;
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET)
	@ResponseBody
	public BarcodeDTO read(Model model) {
		BarcodeDTO barcodeDTO = barcodeServiceStub.getScannedBarcode(9780321502797L);
		model.addAttribute("barcodeDTO", barcodeDTO);
		//model.addAttribute(barcodeDTO);)
		return barcodeDTO;
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, headers={"content-type=text/json"})
	public String readJSON() {
		return "start";
	}
	
	@RequestMapping(value="/addBarcode", method=RequestMethod.GET)
	public String addBarcode(Model model, @RequestParam(value="type", required=false, defaultValue="?_type") String type) {
		BarcodeDTO barcodeDTO = barcodeServiceStub.getScannedBarcode(9780321502797L);
		barcodeDTO.setType(type);
		model.addAttribute("barcodeDTO", barcodeDTO);
		return "start";
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET, params= {"loyalty=blue"})
	public String readBlue() {
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
		return "start";
	}
	
	/**
	 * Handle the / endpoint
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "default start";
	}
	
	/**
	 * Handle the /homePage endpoint
	 * @return
	 */
	@GetMapping("/homePage")
	public String storeBarcode() {
		return "homePage";
	}
}
