package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.Tariff;

public interface TariffService {
	void saveTariff(String tariff);

	void removeTariff(String tariff);

	void updateTariff(Tariff tariff);

	Tariff findTariffById(int id);

	List<Tariff> findAllTariff();
}
