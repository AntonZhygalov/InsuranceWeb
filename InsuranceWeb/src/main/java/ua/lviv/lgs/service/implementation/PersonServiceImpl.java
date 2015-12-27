package ua.lviv.lgs.service.implementation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.PersonDao;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDao personDao;

	public void savePerson(String fNamelName, String number, String passportSeries, String passportNumber,
			String identification, String addres, String yearOfBirstday, String mounthOfBirstday,
			String dayOfBirstday) {

		personDao.savePerson(new Person(fNamelName, Integer.parseInt(number), passportSeries, passportNumber,
				identification, addres, new Date(), new GregorianCalendar(Integer.parseInt(yearOfBirstday),
						Integer.parseInt(mounthOfBirstday), Integer.parseInt(dayOfBirstday))));
	}

	public void removePerson(String id) {
		personDao.removePerson(personDao.findPersonById(Integer.parseInt(id)));

	}

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

	public Person findPersonById(String id) {
		personDao.findPersonById(Integer.parseInt(id));
		return null;
	}

	public List<Person> findAllPerson() {
		personDao.findAllPerson();
		return null;
	}

	public List<Person> findAllPersonOfDateRegistration() {

		return personDao.findAllPerson();
	}

}
