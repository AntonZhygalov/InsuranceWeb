package ua.lviv.lgs.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.DTO.PersonDTO;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.service.PersonService;


@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	// Ця анотація мапує (створює bean) веб запиту на метод нижче, який обробляє

	// цей запит. 2 головні параметри: URL i Http метод.
	// За замовчуванням HTTP методом є GET.
	@RequestMapping(value = "/showAllPersons")
	public String getPersons(Model model) {
		model.addAttribute("persons", personService.findAllPerson());
		return "persons-all";
	}

	@RequestMapping(value = "/createNewPersons")
	public String createPersonPageNewPerson() {
		return "persons-new";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String createPerson(@RequestParam(value = "fNamelName") String fNamelName,
			@RequestParam(value = "number") String number,
			@RequestParam(value = "passportSeries") String passportSeries,
			@RequestParam(value = "passportNumber") String passportNumber,
			@RequestParam(value = "identification") String identification,
			@RequestParam(value = "addres") String addres,
			@RequestParam(value = "dateOfBirthsday") String dateOfBirthsday
	) {
		if(personService.findAllIdPerson()!=null && personService.findAllIdPerson().contains(number))
		{
			return "persons-new"; 
		}
		else {
			personService.savePerson(fNamelName, number, passportSeries, passportNumber, identification, addres,
					dateOfBirthsday);
			return "redirect:/showAllPersons";
		}
	}

	@RequestMapping(value = "/removePerson")
	public String createPersonPageRemovePerson() {
		return "persons-remove";
	}

	@RequestMapping(value = "/insertRemovePerson")
	public String removePerson(@RequestParam(value = "number") String number) {
		personService.removePerson(number);
		return "redirect:/showAllPersons";
	}
	@RequestMapping(value = "/upadatePerson{id}")
	public String updatePagePerson(@PathVariable String id,Model model) {
		Person person= personService.findPersonById(id);
		model.addAttribute(person);
		return "persons-update";
	}
	@RequestMapping(value = "/insertUpdatePersonId",method = RequestMethod.POST)
	public String inserpUpdatePersonId(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "fNamelName") String fNamelName,
			@RequestParam(value = "number") String number,
			@RequestParam(value = "passportSeries") String passportSeries,
			@RequestParam(value = "passportNumber") String passportNumber,
			@RequestParam(value = "identification") String identification,
			@RequestParam(value = "addres") String addres,
			@RequestParam(value = "dateOfBirsthday") String dateOfBirsthday) {	
		personService.updatePerson(id,fNamelName, number, passportSeries, passportNumber, identification, addres, dateOfBirsthday);
		
		return "redirect:/showAllPersons";
	}
	
	
	@RequestMapping(value = "/insertPdfPerson")
	public String inserpPdfPerson(@RequestParam(value ="id")String id) 
		{
		personService.createPDF(id);		
		return "redirect:/showAllPersons";
	}

}
