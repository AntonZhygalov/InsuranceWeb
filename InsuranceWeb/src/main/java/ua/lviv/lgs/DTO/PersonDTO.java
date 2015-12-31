package ua.lviv.lgs.DTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.PersonDao;
import ua.lviv.lgs.dao.implementation.PersonDaoImpl;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.service.PersonService;

public class PersonDTO {
	@Autowired
	PersonService personserw;


	@Transactional
	public List<PersonToShow> findAllPerson() {
		List<PersonToShow> persons = new ArrayList<PersonToShow>();
        List<Person> listPersons =  personserw.findAllPerson();
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

		return persons;
	}
}
