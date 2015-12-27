package ua.lviv.lgs.dao;

import java.util.List;

import ua.lviv.lgs.entity.AdditionalConditions;

public interface AdditionalConditionsDao {
	void saveAdditionalConditions(AdditionalConditions additionalConditions);

	void removeAdditionalConditions(AdditionalConditions additionalConditions);
	
	void updateAdditionalConditions(AdditionalConditions additionalConditions);
	
	AdditionalConditions findAdditionalConditionsById (int id);

	List<AdditionalConditions> findAllAdditionalConditions();
	
}
