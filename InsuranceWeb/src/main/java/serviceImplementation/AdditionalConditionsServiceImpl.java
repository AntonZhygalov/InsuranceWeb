package serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.implementation.AdditionalConditionsDaoImpl;
import ua.lviv.lgs.entity.AdditionalConditions;
import ua.lviv.lgs.service.AdditionalConditionsService;

@Service
public class AdditionalConditionsServiceImpl implements AdditionalConditionsService {
	@Autowired
	private AdditionalConditionsDaoImpl additionalConditions;

	public void saveAdditionalConditions(String additionalConditions) {
		this.additionalConditions.saveAdditionalConditions(new AdditionalConditions(additionalConditions));

	}

	public void removeAdditionalConditions(String additionalConditions) {
		this.additionalConditions.removeAdditionalConditions(new AdditionalConditions(additionalConditions));

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
