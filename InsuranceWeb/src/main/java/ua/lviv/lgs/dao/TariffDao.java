package ua.lviv.lgs.dao;

import java.util.List;


import ua.lviv.lgs.entity.Tariff;

public interface TariffDao {
	void saveTariff(Tariff tariff);

	void removeTariff(Tariff tariff);

	void updateTariff(Tariff tariff);

	Tariff findTariffById(int id);

	List<Tariff> findAllTariff();
}
