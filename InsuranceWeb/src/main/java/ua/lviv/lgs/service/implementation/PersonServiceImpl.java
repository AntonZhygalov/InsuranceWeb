package ua.lviv.lgs.service.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ua.lviv.lgs.DTO.PersonDTO;
import ua.lviv.lgs.dao.PersonDao;
import ua.lviv.lgs.dao.TariffDao;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDao personDao;
	@Autowired
	TariffDao tariffDao;
	public static final String DEST = "results/simple_table.pdf";
@Transactional
	public void savePerson(String fNamelName, String number, String passportSeries, String passportNumber,
			String identification, String addres, String dateOfBirthsday) {

	DateFormat df = new SimpleDateFormat("yy-mm-dd");
	Date startDate = null;
	try {
		startDate = df.parse(dateOfBirthsday);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		personDao.savePerson(new Person(fNamelName, Integer.parseInt(number), passportSeries, passportNumber,
				identification, addres, new Date(), startDate)
				);
	}
@Transactional
	public void removePerson(String id) {
		personDao.removePerson(personDao.findPersonById(Integer.parseInt(id)));

	}
@SuppressWarnings("deprecation")
@Transactional
public void updatePerson(String id,String fNamelName, String number, String passportSeries, String passportNumber,
		String identification, String addres, String dateOfBirthsday) {
	Person person = findPersonById(id);
	person.setNumber(Integer.parseInt(number));
	person.setfNamelName(fNamelName);
	person.setAddres(addres);
	person.setIdentification(identification);
	person.setPassportNumber(passportNumber);
	person.setPassportSeries(passportSeries);
	personDao.updatePerson(person);
}
@Transactional
	public Person findPersonById(String id) {
		return personDao.findPersonById(Integer.parseInt(id));
		
	}
 

@Transactional
	public List<PersonDTO> findAllPerson() {
	List<PersonDTO> persons = new ArrayList<PersonDTO>();
	List<Person> listPersons = personDao.findAllPerson();
	for (int i = 0; i < listPersons.size(); i++) {
		Person person = listPersons.get(i);
		PersonDTO newperson = new PersonDTO();
		newperson.setfNamelName(person.getfNamelName());
		newperson.setAddres(person.getAddres());
		newperson.setTariff(person.getTariff());
		newperson.setIdentification(person.getIdentification());
		newperson.setPassportNumber(person.getPassportNumber());
		newperson.setPassportSeries(person.getPassportSeries());
		newperson.setId(person.getId());
		newperson.setNumber(person.getNumber());
		newperson.setDayOfBirthday(person.getDateOfBirsthday().toString());
		newperson.setDayOfregistration(person.getDateOfRegistration().toString());
		persons.add(newperson);
	}
		return persons;
		 
	}
@Transactional
	public List<Person> findAllPersonOfDateRegistration() {

		return personDao.findAllPerson();
	}

public List<Person> findAllPersons() {
	
	return personDao.findAllPerson();
}
public List<String> findAllIdPerson(){
	List<String> personsId=new ArrayList<String>();
	List<Person>persons=personDao.findAllPerson();
	for(int i=0;i<persons.size();i++)
	{
		personsId.add(String.valueOf(persons.get(i).getNumber()));
	}
	
	if(personsId.size()!=0)
	return personsId;
	else {
		return null;
	}
}
}
