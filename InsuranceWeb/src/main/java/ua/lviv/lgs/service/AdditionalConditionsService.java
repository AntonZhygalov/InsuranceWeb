package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.AdditionalConditions;

public interface AdditionalConditionsService {
	void saveAdditionalConditions(String additionalConditions, String coef);

	void removeAdditionalConditions(String additionalConditions, String coef);
	
	void updateAdditionalConditions(String IdAdditionalConditions);
	
	AdditionalConditions findAdditionalConditionsById (int id);

	List<AdditionalConditions> findAllAdditionalConditions();
}
