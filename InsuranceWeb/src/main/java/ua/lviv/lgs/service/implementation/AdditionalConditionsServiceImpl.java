package ua.lviv.lgs.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.AdditionalConditionsDao;
import ua.lviv.lgs.dao.implementation.AdditionalConditionsDaoImpl;
import ua.lviv.lgs.entity.AdditionalConditions;
import ua.lviv.lgs.service.AdditionalConditionsService;

@Service
public class AdditionalConditionsServiceImpl implements AdditionalConditionsService {
	@Autowired
	private AdditionalConditionsDao additionalConditionsDao;
	@Transactional
	public void saveAdditionalConditions(String additionalConditions,String coef) {
		
		additionalConditionsDao.saveAdditionalConditions(new AdditionalConditions(additionalConditions, Double.parseDouble(coef)));

	}
	@Transactional
	public void removeAdditionalConditions(String additionalConditions) {
		
		AdditionalConditions add = additionalConditionsDao.findAdditionalConditionsById(Integer.parseInt(additionalConditions));
		
		this.additionalConditionsDao.removeAdditionalConditions(add);

	}
	@Transactional
	public void updateAdditionalConditions(String IdAdditionalConditions) {
		AdditionalConditions additional=additionalConditionsDao.findAdditionalConditionsById(Integer.parseInt(IdAdditionalConditions));
		additional.setAdditionalConditions(IdAdditionalConditions);
		additionalConditionsDao.updateAdditionalConditions(additional);
	}
	@Transactional
	public AdditionalConditions findAdditionalConditionsById(int id) {
		return additionalConditionsDao.findAdditionalConditionsById(id);
	}
	@Transactional
	public List<AdditionalConditions> findAllAdditionalConditions() {
		return additionalConditionsDao.findAllAdditionalConditions();
	}

	

	

	

}
