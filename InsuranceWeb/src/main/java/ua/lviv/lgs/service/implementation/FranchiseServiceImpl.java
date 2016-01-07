package ua.lviv.lgs.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FranchiseDao;
import ua.lviv.lgs.entity.Franchise;
import ua.lviv.lgs.service.FranchiseService;
@Service
public class FranchiseServiceImpl implements FranchiseService {
	@Autowired
	public FranchiseDao franchiseDao;
	
	public void saveFranchise(String franchise){
		franchiseDao.saveFranchise(new Franchise(franchise));
	}

public	void removeFranchise(String franchise){
	this.franchiseDao.removeFranchise(new Franchise(franchise));
}

	public void updateFranchise(String franchise){
		Franchise franch=franchiseDao.findFranchiseById(Integer.parseInt(franchise));
		franch.setSumFranchise(franchise);
		franchiseDao.updateFranchise(franch);
	} 

public	Franchise findFranchiseById(int id){
		return franchiseDao.findFranchiseById(id);
	}

	public List<Franchise> findAllFranchise(){
		return franchiseDao.findAllFranchise();
	}


}
