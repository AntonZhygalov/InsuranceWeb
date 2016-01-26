package ua.lviv.lgs.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.FranchiseDao;
import ua.lviv.lgs.entity.AdditionalConditions;
import ua.lviv.lgs.entity.Franchise;
import ua.lviv.lgs.service.FranchiseService;
@Service
public class FranchiseServiceImpl implements FranchiseService {
	@Autowired
	public FranchiseDao franchiseDao;
	@Transactional
	public void saveFranchise(String franchise, String coef){
		franchiseDao.saveFranchise(new Franchise(franchise, Double.parseDouble(coef)));
	}
	@Transactional
public	void removeFranchise(String franchise){
	Franchise add =  franchiseDao.findFranchiseById(Integer.parseInt(franchise));
	this.franchiseDao.removeFranchise(add);
}
	@Transactional
	public void updateFranchise(String franchise){
		Franchise franch=franchiseDao.findFranchiseById(Integer.parseInt(franchise));
		franch.setSumFranchise(franchise);
		franchiseDao.updateFranchise(franch);
	} 
	@Transactional
public	Franchise findFranchiseById(int id){
		return franchiseDao.findFranchiseById(id);
	}
	@Transactional
	public List<Franchise> findAllFranchise(){
		return franchiseDao.findAllFranchise();
	}


}
