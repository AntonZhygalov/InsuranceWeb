package ua.lviv.lgs.service.implementation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.DTO.PersonToShow;
import ua.lviv.lgs.dao.PersonDao;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDao personDao;
@Transactional
	public void savePerson(String fNamelName, String number, String passportSeries, String passportNumber,
			String identification, String addres, String yearOfBirstday, String mounthOfBirstday,
			String dayOfBirstday) {

		personDao.savePerson(new Person(fNamelName, Integer.parseInt(number), passportSeries, passportNumber,
				identification, addres, new Date(), new GregorianCalendar(Integer.parseInt(yearOfBirstday),
						Integer.parseInt(mounthOfBirstday), Integer.parseInt(dayOfBirstday))));
	}
@Transactional
	public void removePerson(String id) {
		personDao.removePerson(personDao.findPersonById(Integer.parseInt(id)));

	}
@Transactional
	public void updatePerson(String fNamelName, String number, String passportSeries, String passportNumber,
			String identification, String addres, String yearOfBirstday, String mounthOfBirstday,
			String dayOfBirstday) {
		Person person = findPersonById(number);
		person.setfNamelName(fNamelName);
		person.setAddres(addres);
		person.setIdentification(identification);
		person.setPassportNumber(passportNumber);
		person.setPassportSeries(passportSeries);
		person.setDateOfBirsthday(new GregorianCalendar(Integer.parseInt(yearOfBirstday),
				Integer.parseInt(mounthOfBirstday), Integer.parseInt(dayOfBirstday)));
		personDao.updatePerson(person);
	}
@Transactional
	public Person findPersonById(String id) {
		return personDao.findPersonById(Integer.parseInt(id));
		
	}
 
@Transactional
	public List<PersonToShow> findAllPerson() {
	List<PersonToShow> persons = new ArrayList<PersonToShow>();
	List<Person> listPersons = personDao.findAllPerson();
	for (int i = 0; i < listPersons.size(); i++) {
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
		newperson.setDayOfBirthday(person.getDateOfBirsthday().get(1)+" - "+person.getDateOfBirsthday().get(2)+" - "+person.getDateOfBirsthday().get(0));
		newperson.setDayOfregistration(person.getDateOfRegistration().toString());
		persons.add(newperson);
	}
		return persons;
		 
	}
@Transactional
	public List<Person> findAllPersonOfDateRegistration() {

		return personDao.findAllPerson();
	}

}
