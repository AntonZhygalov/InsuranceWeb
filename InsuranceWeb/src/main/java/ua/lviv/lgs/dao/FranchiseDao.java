package ua.lviv.lgs.dao;

import java.util.List;


import ua.lviv.lgs.entity.Franchise;

public interface FranchiseDao {

	void saveFranchise(Franchise franchise);

	void removeFranchise(Franchise franchise);

	void updateFranchise(Franchise franchise);

	Franchise findFranchiseById(int id);

	List<Franchise> findAllFranchise();
}
