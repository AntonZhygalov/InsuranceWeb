package ua.lviv.lgs.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.DTO.PersonDTO;
import ua.lviv.lgs.DTO.PersonToShow;
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

	
	
	
	
	
	
	
	
	List<PersonToShow> persons = new ArrayList<PersonToShow>();
    List<Person> listPersons =  personService.findAllPerson();
	for (int i=0;i<listPersons.size();i++) {
		Person person = listPersons.get(i);
		PersonToShow newperson = new PersonToShow();
		newperson.setfNamelName(person.getfNamelName());
		newperson.setAddres(person.getAddres());
		newperson.setTariff(person.getTariff());
		newperson.setIdentification(person.getIdentification());
		newperson.setPassportNumber(person.getPassportNumber());
		newperson.setPassportSeries(person.getPassportSeries());
		newperson.setId(person.getId());
		newperson.setNumber(person.getNumber());
		
		newperson.setDayOfBirthday(person.getDateOfBirsthday().get(2));
		newperson.setMountsOfBirthday(person.getDateOfBirsthday().get(1));
		newperson.setYearOfBirthday(person.getDateOfBirsthday().get(0));

		newperson.setDayOfregistration(person.getDateOfRegistration().getDay());
		newperson.setMountsOfregistration(person.getDateOfRegistration().getMonth());
		newperson.setYearOfregistration(person.getDateOfRegistration().getYear());
		persons.add(newperson);
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
		model.addAttribute("persons", persons);
		return "persons-all";
	}
	@RequestMapping(value = "/createNewPersons")
	public String createPersonPageNewPerson(){
		return "persons-new";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String createPerson(@RequestParam(value = "fNamelName")  String fNamelName,@RequestParam(value = "number") String number,@RequestParam(value = "passportSeries") String passportSeries, @RequestParam(value = "passportNumber")String passportNumber,
			@RequestParam(value = "identification")String identification,@RequestParam(value = "addres") String addres, @RequestParam(value = "yearOfBirstday")String yearOfBirstday, @RequestParam(value = "mounthOfBirstday")String mounthOfBirstday,
			@RequestParam(value = "dayOfBirstday")String dayOfBirstday) {
		personService.savePerson(fNamelName, number, passportSeries, passportNumber, identification, addres, yearOfBirstday, mounthOfBirstday, dayOfBirstday);
		return "redirect:/showAllPersons";
	}
	@RequestMapping(value = "/removePerson")
	public String createPersonPageRemovePerson(){
		return "persons-remove";
	}
	@RequestMapping(value = "/insertRemovePerson")
	public String removePerson(@RequestParam(value = "number") String number) {
		personService.removePerson(number);
		return "redirect:/showAllPersons";
	}

//	//@RequestParam отримує вхідне (введене) значення з веб сторінки, використовуючи ім'я input тегу.
//	@RequestMapping(value = "/showAllPersons", method = RequestMethod.POST)
//	public String createPerson(@RequestParam(value = "name") String name,
//			@RequestParam(value = "country") String country) {
//		personService.savePerson(fNamelName, number, passportSeries, passportNumber, identification, addres, dateOfRegistration, dateOfBirsthday);
//		return "redirect:/showAllPersons";
//	}
}
