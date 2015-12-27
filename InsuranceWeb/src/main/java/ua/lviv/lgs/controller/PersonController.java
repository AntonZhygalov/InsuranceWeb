package ua.lviv.lgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.service.PersonService;



//Ця анотація вказує Spring context створити Контролер Bean, який призначений для обробки URL запитів.
@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	// Ця анотація мапує (створює bean) веб запиту на метод нижче, який обробляє
	// цей запит. 2 головні параметри: URL i Http метод.
	// За замовчуванням HTTP методом є GET.
	@RequestMapping(value = "/showAllPersons")
	public String getPersons(Model model) {
		List<Person> allPersons = personService.findAllPerson();
		model.addAttribute("persons", allPersons);
		// Методи контролера повертають стрічку, яка являє собою ім'я веб
		// сторінки, яка повинна відкритись. Саме до цієї стрічки дописується
		// префікс і суфікс.
		return "persons";
	}

	@RequestMapping(value = "/createNewPersons")
	public String createPersonPage(@RequestParam(value = "name") String name) {
		return "newPerson";
	}

//	//@RequestParam отримує вхідне (введене) значення з веб сторінки, використовуючи ім'я input тегу.
//	@RequestMapping(value = "/showAllPersons", method = RequestMethod.POST)
//	public String createPerson(@RequestParam(value = "name") String name,
//			@RequestParam(value = "country") String country) {
//		personService.savePerson(fNamelName, number, passportSeries, passportNumber, identification, addres, dateOfRegistration, dateOfBirsthday);
//		return "redirect:/showAllPersons";
//	}
}
