package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.Franchise;

public interface FranchiseService {
	void saveFranchise(String franchise, String coef);

	void removeFranchise(String franchise);

	void updateFranchise(String franchise);

	Franchise findFranchiseById(int id);

	List<Franchise> findAllFranchise();
}
