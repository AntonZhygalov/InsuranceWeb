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
public void createPDF(String id) {
	Person newPerson = personDao.findPersonById(Integer.parseInt(id));
//	Tariff newTariff = tariffDao.findTariffById(5);
	File file = new File(DEST);
	file.getParentFile().mkdirs();
	Document document = new Document();
	try {
		PdfWriter.getInstance(document, new FileOutputStream(DEST));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
	Paragraph paragraph = new Paragraph("Text text text text text text text text text text", paragraphFont);

	document.open();
	PdfPTable table = new PdfPTable(8);
//	PdfPTable tableTariff = new PdfPTable(10);
	table.setWidthPercentage(100);
	table.addCell("Number");
	table.addCell("Full name");
	table.addCell("Date Of Birsthday");
	table.addCell("Date Of Registration");
	table.addCell("Addres");
	table.addCell("Identification");
	table.addCell("PassportSeries");
	table.addCell("PassportNumber");
	table.addCell(String.valueOf(newPerson.getNumber()));
	table.addCell(newPerson.getfNamelName());
	table.addCell(newPerson.getDateOfBirsthday().toString());
	table.addCell(newPerson.getDateOfRegistration().toString());
	table.addCell(newPerson.getAddres());
	table.addCell(newPerson.getIdentification());
	table.addCell(newPerson.getPassportSeries());
	table.addCell(newPerson.getPassportNumber());

//	tableTariff.addCell("LimitDay");
//	tableTariff.addCell("FromDate");
//	tableTariff.addCell("UntilDate");
//	tableTariff.addCell("Coef");
//	tableTariff.addCell("AdditionalConditions");
//	tableTariff.addCell("Franchise");
//	tableTariff.addCell("InsuranceAmount");
//	tableTariff.addCell("Program");
//	tableTariff.addCell("Zone");
//	tableTariff.addCell("Cost");
//
//	tableTariff.addCell(String.valueOf(newTariff.getLimitDay()));
//	tableTariff.addCell(newTariff.getFromDate().toString());
//	tableTariff.addCell(newTariff.getUntilDate().toString());
//	tableTariff.addCell(String.valueOf(newTariff.getCoef()));
//	tableTariff.addCell(newTariff.getAdditionalConditions().getAdditionalConditions());
//	tableTariff.addCell(newTariff.getFranchise().getSumFranchise());
//	tableTariff.addCell(newTariff.getInsuranceAmount().getSumInsurance());
//	tableTariff.addCell(newTariff.getProgram().getProgram());
//	tableTariff.addCell(newTariff.getZone().getZone());
//	tableTariff.addCell(String.valueOf(newTariff.getCost()));

	try {
//		document.add(paragraph);
		document.add(table);
//		document.add(tableTariff);
		document.add(new Paragraph("Date(_______________________________)"));
		document.add(new Paragraph("Sunskription(_______________________________)"));

	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	document.close();

}
}
