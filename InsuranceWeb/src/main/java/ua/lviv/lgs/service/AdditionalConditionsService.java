package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.AdditionalConditions;

public interface AdditionalConditionsService {
	void saveAdditionalConditions(String additionalConditions);

	void removeAdditionalConditions(String additionalConditions);
	
	void updateAdditionalConditions(AdditionalConditions additionalConditions);
	
	AdditionalConditions findAdditionalConditionsById (int id);

	List<AdditionalConditions> findAllAdditionalConditions();
}
