package ua.lviv.lgs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.DTO.PersonToShow;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.service.PersonService;
import ua.lviv.lgs.service.TariffService;

@Controller
public class TariffController {
	@Autowired
	private TariffService tariffService;
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/showAllTariff")
	public String getPersons(Model model) {
		model.addAttribute("persons", tariffService.findAllTariff());	
		return "tariff-all";
	}

	@RequestMapping(value = "/createNewTariff")
	public String createPersonPageNewPerson() {
		return "tariff-new";
	}

	@RequestMapping(value = "/insertTariff", method = RequestMethod.POST)
	public String createPerson(
			@RequestParam(value = "program ") String program ,
			@RequestParam(value = "franchise ") String franchise ,
			@RequestParam(value = "zone") String zone,
			@RequestParam(value = "additionalConditions") String additionalConditions,
			@RequestParam(value = "insuranceAmount") String insuranceAmount,
			@RequestParam(value = "limitDay") String limitDay,
			@RequestParam(value = "fromDay") String fromDay,
			@RequestParam(value = "fromMonth") String fromMonth,
			@RequestParam(value = " fromYear") String  fromYear
			) {
		tariffService.saveTariff( limitDay,  fromDay, fromMonth, fromYear);
		return "redirect:/showAllTariff";
	}

	@RequestMapping(value = "/removeTariff")
	public String createPersonPageRemovePerson() {
		return "persons-remove";
	}

	@RequestMapping(value = "/insertRemoveTariff")
	public String removePerson(@RequestParam(value = "number") String number) {
		tariffService.removeTariff(number);
		return "redirect:/showAllTariff";
	}
}
