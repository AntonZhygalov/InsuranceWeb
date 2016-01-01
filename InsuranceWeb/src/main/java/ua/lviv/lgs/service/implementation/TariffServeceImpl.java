package ua.lviv.lgs.service.implementation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.PersonDao;
import ua.lviv.lgs.dao.TariffDao;
import ua.lviv.lgs.dao.implementation.PersonDaoImpl;
import ua.lviv.lgs.entity.Person;
import ua.lviv.lgs.entity.Tariff;
import ua.lviv.lgs.service.TariffService;
@Service
public class TariffServeceImpl implements TariffService {
@Autowired
private TariffDao tariffDao;
@Autowired
private PersonDao pesonDao;


@Transactional
	public void removeTariff(String idTariff) {
		this.tariffDao.removeTariff(tariffDao.findTariffById(Integer.parseInt(idTariff)));
		
	}
@Transactional
	public void updateTariff(Tariff tariff) {
		// TODO Auto-generated method stub
		
	}
@Transactional
	public Tariff findTariffById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
@Transactional
	public List<Tariff> findAllTariff() {
		return tariffDao.findAllTariff();
	}
@Transactional
public void saveTariff(String program, String franchise, String zone, String additionalConditions,
		String insuranceAmount, String limitDay, String fromDay, String fromMonth, String fromYear,String person) {
	Calendar fromDate=new  GregorianCalendar(Integer.parseInt(fromYear),Integer.parseInt(fromMonth), Integer.parseInt(fromDay));
	Calendar untilDate =new  GregorianCalendar(1+Integer.parseInt(fromYear),Integer.parseInt(fromMonth), Integer.parseInt(fromDay));
	int cost=0;
	Tariff tariff= new Tariff();
	tariff.setLimitDay(Integer.parseInt(limitDay));
	tariff.setFromDate(fromDate);
	tariff.setUntilDate(untilDate);
	List<Person>persons=new ArrayList<Person>();
	persons.add(pesonDao.findPersonById(Integer.parseInt(person)));
	tariff.setPerson(persons);
	this.tariffDao.saveTariff(tariff);
}

}
