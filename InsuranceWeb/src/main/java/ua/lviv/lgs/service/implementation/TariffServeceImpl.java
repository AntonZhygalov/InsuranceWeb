package ua.lviv.lgs.service.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
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

import ua.lviv.lgs.DTO.TariffDTO;
import ua.lviv.lgs.dao.PersonDao;
import ua.lviv.lgs.dao.TariffDao;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.entity.Tariff;
import ua.lviv.lgs.service.AdditionalConditionsService;
import ua.lviv.lgs.service.FranchiseService;
import ua.lviv.lgs.service.InsuranceAmountService;
import ua.lviv.lgs.service.PersonService;
import ua.lviv.lgs.service.ProgramService;
import ua.lviv.lgs.service.TariffService;
import ua.lviv.lgs.service.ZoneService;

@Service
public class TariffServeceImpl implements TariffService {
	@Autowired
	private TariffDao tariffDao;
	@Autowired
	private PersonService pesonService;
	@Autowired
	private AdditionalConditionsService additionalConditionsService;
	@Autowired
	private FranchiseService franchiseService;
	@Autowired
	private InsuranceAmountService insuranceAmountService;
	@Autowired
	private ZoneService zoneService;
	@Autowired
	private ProgramService programService;
	@Autowired
	PersonDao personDao;
	public static final String DEST = "results/simple_table.pdf";
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Transactional
	public void removeTariff(String idTariff) {
		this.tariffDao.removeTariff(findTariffById(idTariff));

	}

	@Transactional
	public void updateTariff(Tariff tariff) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public Tariff findTariffById(String id) {
		return tariffDao.findTariffById(Integer.parseInt(id));
	}

	@Transactional
	public List<TariffDTO> findAllTariff() {
		List<TariffDTO> tariffDTOList = new ArrayList<TariffDTO>();
		List<Tariff> tariffs = tariffDao.findAllTariff();
		for (int i = 0; i < tariffs.size(); i++) {
			String	person = null;
			TariffDTO tariffDTO = new TariffDTO();
			tariffDTO.setId(tariffs.get(i).getId());
			tariffDTO.setAdditionalConditions(tariffs.get(i).getAdditionalConditions().getAdditionalConditions());
			tariffDTO.setFranchise(tariffs.get(i).getFranchise().getSumFranchise());
			tariffDTO.setInsuranceAmount(tariffs.get(i).getInsuranceAmount().getSumInsurance());
			tariffDTO.setProgram(tariffs.get(i).getProgram().getProgram());
			tariffDTO.setZone(tariffs.get(i).getZone().getZone());
			tariffDTO.setCost(tariffs.get(i).getCost());
			tariffDTO.setFromDate(dateFormat.format(tariffs.get(i).getFromDate().getTime()));
			tariffDTO.setUntilDate(dateFormat.format(tariffs.get(i).getUntilDate().getTime()));
			tariffDTO.setLimitDay(tariffs.get(i).getLimitDay());

			for (int j = 0; j < tariffs.get(i).getPerson().size(); j++) {

				person = tariffs.get(i).getPerson().get(j).getfNamelName();

			}
			tariffDTO.setPersonId(person);
			tariffDTOList.add(tariffDTO);
		}
		return tariffDTOList;
	}

	@Transactional
	public void saveTariff(String limitDay, String fromDay, String fromMonth, String fromYear, String person,
			String program, String franchise, String zone, String additionalConditions, String insuranceAmount) {
		Calendar fromDate = new GregorianCalendar(Integer.parseInt(fromYear), Integer.parseInt(fromMonth),
				Integer.parseInt(fromDay));
		Calendar untilDate = new GregorianCalendar(1 + Integer.parseInt(fromYear), Integer.parseInt(fromMonth),
				Integer.parseInt(fromDay));

		Tariff tariff = new Tariff();

		tariff.setCoef(2);
		tariff.setLimitDay(Integer.parseInt(limitDay));
		tariff.setFromDate(fromDate);
		tariff.setUntilDate(untilDate);
		List<Person> persons = new ArrayList<Person>();
		persons.add(pesonService.findPersonById(person));
		tariff.setPerson(persons);
		tariff.setAdditionalConditions(
				additionalConditionsService.findAdditionalConditionsById(Integer.parseInt(additionalConditions)));
		tariff.setFranchise(franchiseService.findFranchiseById(Integer.parseInt(franchise)));
		tariff.setInsuranceAmount(insuranceAmountService.findInsuranceAmountById(Integer.parseInt(insuranceAmount)));
		tariff.setProgram(programService.findProgramById(Integer.parseInt(program)));
		tariff.setZone(zoneService.findZoneById(Integer.parseInt(zone)));
		tariff.setCost(costByTariff(tariff));
		this.tariffDao.saveTariff(tariff);
		pesonService.findPersonById(person).getTariff().add(tariff);
	}

	public double costByTariff(Tariff tariff) {
		double sum = tariff.getAdditionalConditions().getCoef() * tariff.getFranchise().getCoef()
				* tariff.getInsuranceAmount().getCoef() * tariff.getProgram().getCoef() * tariff.getZone().getCoef()
				* tariff.getCoef() * tariff.getLimitDay();
		return Math.round(sum * Math.pow(10, 2)) / Math.pow(10, 2);
	}
	@Transactional
	public void createPDF(String id) {
		Tariff newTariff = tariffDao.findTariffById(Integer.parseInt(id));
		Person newPerson=newTariff.getPerson().get(0);
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(DEST));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}

	
		document.open();
		PdfPTable table = new PdfPTable(8);
		PdfPTable tableTariff = new PdfPTable(10);
		tableTariff.setWidthPercentage(100);

		table.setWidthPercentage(100);
		table.addCell("Number");
		table.addCell("Full name");
		table.addCell("Date Of Birsthday");
		table.addCell("Date Of Registration");
		table.addCell("Addres");
		table.addCell("Identification");
		table.addCell("PassportSeries");
		table.addCell("PassportNumber");
		String p1= String.valueOf(newPerson.getNumber()) ;
		String p2=""+ newPerson.getfNamelName() ;
		String p3= newPerson.getDateOfBirsthday().toString() ;
		String p4= newPerson.getDateOfRegistration().toString() ;
		String p5=""+ newPerson.getAddres() ;
		String p6= newPerson.getIdentification() ;
		String p7= newPerson.getPassportSeries() ;
		String p8= newPerson.getPassportNumber() ;
		table.addCell(p1);
		table.addCell(p2);
		table.addCell(p3);
		table.addCell(p4);
		table.addCell(p5);
		table.addCell(p6);
		table.addCell(p7);
		table.addCell(p8);

		
		

		tableTariff.addCell("LimitDay");
		tableTariff.addCell("FromDate");
		tableTariff.addCell("UntilDate");
		tableTariff.addCell("Coef");
		tableTariff.addCell("AdditionalConditions");
		tableTariff.addCell("Franchise");
		tableTariff.addCell("InsuranceAmount");
		tableTariff.addCell("Program");
		tableTariff.addCell("Zone");
		tableTariff.addCell("Cost");
		String a1=String.valueOf(newTariff.getLimitDay())  ;
		String a2=dateFormat.format( newTariff.getFromDate().getTime()) ;
		String a3= dateFormat.format( newTariff.getUntilDate().getTime()) ;
		String a4=String.valueOf(newTariff.getCoef())  ;
		String a5= newTariff.getAdditionalConditions().getAdditionalConditions() ;
		String a6= newTariff.getFranchise().getSumFranchise() ;
		String a7= newTariff.getInsuranceAmount().getSumInsurance() ;
		String a8= newTariff.getProgram().getProgram() ;
		String a9= newTariff.getZone().getZone() ;
		String a10= String.valueOf(newTariff.getCost()) ;
		tableTariff.addCell(a1);
		tableTariff.addCell(a2);
		tableTariff.addCell(a3);
		tableTariff.addCell(a4);
		tableTariff.addCell(a5);
		tableTariff.addCell(a6);
		tableTariff.addCell(a7);
		tableTariff.addCell(a8);
		tableTariff.addCell(a9);
		tableTariff.addCell(a10);

Paragraph paragraph3 = new  Paragraph();
Paragraph paragraph4 = new  Paragraph();
Paragraph paragraph5 = new  Paragraph();
paragraph4.add("Tariff :");
paragraph5.add("Person :");
paragraph3.add("Date(_______________________________)");
paragraph3.add("Sunskription(_______________________________)");
		try {
		document.add(paragraph5);	
		document.add(table);
		document.add(paragraph4);
		document.add(tableTariff);
		document.add(paragraph3);
		
		} catch (DocumentException e) {
		
			e.printStackTrace();
		}
		document.close();

	}
}
