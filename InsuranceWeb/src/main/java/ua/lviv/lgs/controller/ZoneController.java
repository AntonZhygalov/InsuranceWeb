package ua.lviv.lgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.entity.AdditionalConditions;
import ua.lviv.lgs.entity.Franchise;
import ua.lviv.lgs.entity.InsuranceAmount;
import ua.lviv.lgs.entity.Program;
import ua.lviv.lgs.entity.Zone;
import ua.lviv.lgs.service.ZoneService;

@Controller
public class ZoneController {
	@Autowired
	private ZoneService zoneService;


	
	@RequestMapping(value = "/createNewZone")
	public String createZonePage(Model model) {
		return "zone-update";
	}

	@RequestMapping(value = "/insertZone" , method = RequestMethod.POST)
	public String createZone(
			@RequestParam(value = "name") String  name,
			@RequestParam(value = "coef") String coef
			
			) {
		
	zoneService.saveZone(name, coef);
		
		return "redirect:/showAllWorkers";
	}

	@RequestMapping(value = "/removeZone")
	public String createZonePageRemoveZone() {
		return "zone-update";
	}

	@RequestMapping(value = "/insertRemoveZone")
	public String removeZone(@RequestParam(value = "Id") String number) {
		zoneService.removeZone(number);
		return "redirect:/showAllWorkers";
	}
}
