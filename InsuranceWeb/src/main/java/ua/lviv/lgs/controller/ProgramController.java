package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import ua.lviv.lgs.service.ProgramService;

@Controller
public class ProgramController {
	@Autowired
	private ProgramService programService;

	@RequestMapping(value = "/createNewProgram")
	public String createProgramPage(Model model) {
		return "program-update";
	}

	@RequestMapping(value = "/insertProgram", method = RequestMethod.POST)
	public String createProgram(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "coef") String coef) 
	{

		programService.saveProgram(name, coef);

		return "redirect:/showAllWorkers";
	}

	@RequestMapping(value = "/removeProgram")
	public String pageRemoveProgram() {
		return "program-update";
	}

	@RequestMapping(value = "/insertRemoveProgram")
	public String removeProgram(@RequestParam(value = "name") String name) {
		programService.removeProgram(name);
		return "redirect:/showAllWorkers";
	}
}
