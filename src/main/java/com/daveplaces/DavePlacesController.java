package com.daveplaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DavePlacesController {
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read() {
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
	

}
