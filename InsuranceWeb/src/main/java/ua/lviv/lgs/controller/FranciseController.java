package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import ua.lviv.lgs.service.FranchiseService;

@Controller
public class FranciseController {
	@Autowired
	private FranchiseService franchiseService;

	@RequestMapping(value = "/createNewFranchise")
	public String createFranchisePage(Model model) {
		return "franchise-update";
	}

	@RequestMapping(value = "/insertFranchise", method = RequestMethod.POST)
	public String createFranchise(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "coef") String coef) 
	{

		franchiseService.saveFranchise(name, coef);

		return "redirect:/showAllWorkers";
	}

	@RequestMapping(value = "/removeFranchise")
	public String pageRemoveFranchise() {
		return "franchise-update";
	}

	@RequestMapping(value = "/insertRemoveFranchise")
	public String removeFranchise(@RequestParam(value = "name") String name) {
		franchiseService.removeFranchise(name);
		return "redirect:/showAllWorkers";
	}
}
