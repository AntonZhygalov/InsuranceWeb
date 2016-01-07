package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.AdditionalConditions;
import ua.lviv.lgs.entity.Franchise;
import ua.lviv.lgs.entity.Program;
import ua.lviv.lgs.entity.Tariff;
import ua.lviv.lgs.entity.Zone;

public interface TariffService {
	void saveTariff(String limitDay, String fromDay, String fromMonth, String fromYear,String person,String program,String franchise,String zone,String additionalConditions,String insuranceAmount);

	void removeTariff(String tariff);

	void updateTariff(Tariff tariff);

	Tariff findTariffById(int id);

	List<Tariff> findAllTariff();
}
