package ua.lviv.lgs.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ua.lviv.lgs.DTO.PersonToShow;
import ua.lviv.lgs.entity.Person;

public interface PersonService {
	void savePerson(String fNamelName, String number, String passportSeries, String passportNumber,
			String identification, String addres, String dateOfBirthsday);

	void removePerson(String id);

	void updatePerson(String fNamelName, String number, String passportSeries, String passportNumber,
			String identification, String addres, String dateOfBirthsday);

	Person findPersonById(String id);

	List<PersonToShow> findAllPerson();
	
	List<Person> findAllPersonOfDateRegistration();
}
