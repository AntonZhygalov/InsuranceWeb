package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.AdditionalConditions;
import ua.lviv.lgs.entity.Franchise;
import ua.lviv.lgs.entity.Program;
import ua.lviv.lgs.entity.Tariff;
import ua.lviv.lgs.entity.Zone;

public interface TariffService {
	void saveTariff(String program, String franchise,String zone,String additionalConditions,
			String insuranceAmount,String limitDay,String fromDay,String fromMounth,String fromYear,String person);

	void removeTariff(String tariff);

	void updateTariff(Tariff tariff);

	Tariff findTariffById(int id);

	List<Tariff> findAllTariff();
}
