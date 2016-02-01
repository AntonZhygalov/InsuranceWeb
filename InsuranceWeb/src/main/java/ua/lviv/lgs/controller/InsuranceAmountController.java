package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import ua.lviv.lgs.service.InsuranceAmountService;

@Controller
public class InsuranceAmountController {
	@Autowired
	private InsuranceAmountService insuranceAmount;

	@RequestMapping(value = "/createNewInsuranceAmount")
	public String createInsuranceAmountPage(Model model) {
		return "insuranceAmount-update";
	}

	@RequestMapping(value = "/insertInsuranceAmount", method = RequestMethod.POST)
	public String createInsuranceAmount(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "coef") String coef) 
	{

		insuranceAmount.saveInsuranceAmount(name, coef);

		return "redirect:/showAllWorkers";
	}

	@RequestMapping(value = "/removeInsuranceAmount")
	public String pageRemoveInsuranceAmount() {
		return "insuranceAmount-update";
	}

	@RequestMapping(value = "/insertRemoveInsuranceAmount")
	public String removeInsuranceAmount(@RequestParam(value = "name") String name) {
		insuranceAmount.removeInsuranceAmount(name);
		return "redirect:/showAllWorkers";
	}
}
