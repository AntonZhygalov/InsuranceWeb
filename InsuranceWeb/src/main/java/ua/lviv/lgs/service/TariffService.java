package ua.lviv.lgs.service;
import java.util.List;
import ua.lviv.lgs.DTO.TariffDTO;
import ua.lviv.lgs.entity.Tariff;
public interface TariffService {
	void saveTariff(String limitDay, String fromDay, String fromMonth, String fromYear,String person,String program,String franchise,String zone,String additionalConditions,String insuranceAmount);

	void removeTariff(String tariff);

	void updateTariff(Tariff tariff);

	Tariff findTariffById(String id);

	List<TariffDTO> findAllTariff();
}
