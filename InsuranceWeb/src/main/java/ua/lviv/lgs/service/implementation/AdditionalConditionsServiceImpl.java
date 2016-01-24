package ua.lviv.lgs.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.AdditionalConditionsDao;
import ua.lviv.lgs.dao.implementation.AdditionalConditionsDaoImpl;
import ua.lviv.lgs.entity.AdditionalConditions;
import ua.lviv.lgs.service.AdditionalConditionsService;

@Service
public class AdditionalConditionsServiceImpl implements AdditionalConditionsService {
	@Autowired
	private AdditionalConditionsDao additionalConditions;

	public void saveAdditionalConditions(String additionalConditions, String coef) {
		this.additionalConditions.saveAdditionalConditions(new AdditionalConditions(additionalConditions, Double.parseDouble(coef)));

	}

	public void removeAdditionalConditions(String additionalConditions, String coef) {
		this.additionalConditions.removeAdditionalConditions(new AdditionalConditions(additionalConditions, Double.parseDouble(coef)));

	}

	public void updateAdditionalConditions(String IdAdditionalConditions) {
		AdditionalConditions additional=additionalConditions.findAdditionalConditionsById(Integer.parseInt(IdAdditionalConditions));
		additional.setAdditionalConditions(IdAdditionalConditions);
		additionalConditions.updateAdditionalConditions(additional);
	}

	public AdditionalConditions findAdditionalConditionsById(int id) {
		return additionalConditions.findAdditionalConditionsById(id);
	}

	public List<AdditionalConditions> findAllAdditionalConditions() {
		return additionalConditions.findAllAdditionalConditions();
	}

	

}
