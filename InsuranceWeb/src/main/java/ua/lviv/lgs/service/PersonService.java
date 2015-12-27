package ua.lviv.lgs.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ua.lviv.lgs.entity.Person;

public interface PersonService {
	void savePerson(String fNamelName, int number, String passportSeries,
			String passportNumber, String identification, String addres,
			Date dateOfRegistration, Calendar dateOfBirsthday);

	void removePerson(int id);

	void updatePerson(Person person);

	Person findPersonById(int id);

	List<Person> findAllPerson();
	
	List<Person> findAllPersonOfDateRegistration();
}
