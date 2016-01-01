package ua.lviv.lgs.service.implementation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.TariffDao;
import ua.lviv.lgs.entity.Tariff;
import ua.lviv.lgs.service.TariffService;
@Service
public class TariffServeceImpl implements TariffService {
@Autowired
private TariffDao tariffDao;
@Transactional
	public void saveTariff(String limitDay, String fromDay,String fromMonth,String fromYear) {
	Calendar fromDate=new  GregorianCalendar(Integer.parseInt(fromYear),Integer.parseInt(fromMonth), Integer.parseInt(fromDay));
	Calendar untilDate =new  GregorianCalendar(1+Integer.parseInt(fromYear),Integer.parseInt(fromMonth), Integer.parseInt(fromDay));
	int cost=0;
	Tariff tariff= new Tariff(Integer.parseInt(limitDay), fromDate,untilDate,cost);
	this.tariffDao.saveTariff(tariff);
		
	}
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

}
