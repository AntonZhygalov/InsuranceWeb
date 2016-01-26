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
import ua.lviv.lgs.service.AdditionalConditionsService;
import ua.lviv.lgs.service.FranchiseService;
import ua.lviv.lgs.service.InsuranceAmountService;
import ua.lviv.lgs.service.ProgramService;
import ua.lviv.lgs.service.TariffService;
import ua.lviv.lgs.service.ZoneService;

@Controller
public class TariffController {
	@Autowired
	private TariffService tariffService;
	@Autowired
	private ProgramService programService;
	@Autowired
	private AdditionalConditionsService additionalConditionsService;
	@Autowired
	private FranchiseService franchiseService;
	@Autowired
	private InsuranceAmountService insuranceAmountService;
	@Autowired
	private ZoneService zoneService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/showAllTariff")
	public String getTariffss(Model model) {
		model.addAttribute("tariffs", tariffService.findAllTariff());	
		return "tariff-all";
	}

	@RequestMapping(value = "/createNewTariff")
	public String createPersonPageNewPerson(Model model) {
		List<Program>programs=programService.findAllProgram();
		List<AdditionalConditions>additionalConditions=additionalConditionsService.findAllAdditionalConditions();
		List<Franchise>franchises=franchiseService.findAllFranchise();
		List<InsuranceAmount>insuranceAmounts=insuranceAmountService.findAllInsuranceAmount();
		List<Zone>zones=zoneService.findAllZone();
		model.addAttribute("programs",programs);
		model.addAttribute("additionalConditions",additionalConditions);
		model.addAttribute("franchises",franchises);
		model.addAttribute("insuranceAmounts", insuranceAmounts);
		model.addAttribute("zones", zones);
		return "tariff-new";
	}

	@RequestMapping(value = "/insertTafiff" , method = RequestMethod.POST)
	public String createPerson(
			@RequestParam(value = "program") String program ,
			@RequestParam(value = "franchise") String franchise ,
			@RequestParam(value = "zone") String zone,
			@RequestParam(value = "additionalConditions") String additionalConditions,
			@RequestParam(value = "insuranceAmount") String insuranceAmount,
			@RequestParam(value = "limitDay") String limitDay,
			@RequestParam(value = "date") String date,
			
			@RequestParam(value = "person") String  person
			
			) {
	String []newate=date.split("-");
		tariffService.saveTariff(limitDay, newate[2], newate[1], newate[0],person,program,franchise,zone,additionalConditions,insuranceAmount);
		
		return "redirect:/showAllTariff";
	}

	@RequestMapping(value = "/removeTariff")
	public String createPersonPageRemovePerson() {
		return "tariff-remove";
	}

	@RequestMapping(value = "/insertRemoveTariff")
	public String removePerson(@RequestParam(value = "Id") String number) {
		tariffService.removeTariff(number);
		return "redirect:/showAllTariff";
	}
}
