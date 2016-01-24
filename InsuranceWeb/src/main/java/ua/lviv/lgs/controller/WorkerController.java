package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.service.WorkerService;

@Controller
public class WorkerController {
	@Autowired
	private WorkerService workerService;

	@RequestMapping(value = "/showAllWorkers")
	public String getUser(Model model) {
		model.addAttribute("workers", workerService.findAllWorkers());
		return "worker-all";
	}

	@RequestMapping(value = "/insertWorker", method = RequestMethod.POST)
	public String createWorker(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password

	) {
		workerService.saveWorker(name, password);
		return "redirect:/showAllWorkers";
	}

	@RequestMapping(value = "/insertRemoveWorker")
	public String removeUser(@RequestParam(value = "number") String number) {
		workerService.removeWorker(number);
		return "redirect:/showAllWorkers";
	}
}
