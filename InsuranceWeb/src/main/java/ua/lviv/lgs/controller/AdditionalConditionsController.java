package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.service.AdditionalConditionsService;
import ua.lviv.lgs.service.ZoneService;

@Controller
public class AdditionalConditionsController {
	@Autowired
	private AdditionalConditionsService additionalConditions;

	@RequestMapping(value = "/createNewAdditionalConditions")
	public String createAdditionalConditionsPage(Model model) {
		return "additionalConditions-update";
	}

	@RequestMapping(value = "/insertAdditionalConditions", method = RequestMethod.POST)
	public String createAdditionalConditions(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "coef") String coef) 
	{

		additionalConditions.saveAdditionalConditions(name, coef);

		return "redirect:/showAllWorkers";
	}

//	@RequestMapping(value = "/removeAdditionalConditions")
//	public String createZoneAdditionalConditionsRemoveAdditionalConditions() {
//		return "additionalConditions-update";
//	}

	@RequestMapping(value = "/insertRemoveAdditionalConditions")
	public String removeAdditionalConditions(@RequestParam(value = "name") String name) {
		additionalConditions.removeAdditionalConditions(name);
		return "redirect:/showAllWorkers";
	}
}
