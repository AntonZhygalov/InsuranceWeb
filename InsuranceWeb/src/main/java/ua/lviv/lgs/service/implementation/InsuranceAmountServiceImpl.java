package ua.lviv.lgs.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.InsuranceAmountDao;
import ua.lviv.lgs.entity.InsuranceAmount;
import ua.lviv.lgs.service.InsuranceAmountService;

@Service
public class InsuranceAmountServiceImpl implements InsuranceAmountService {
	@Autowired
	public InsuranceAmountDao insuranceAmount;

	public void saveInsuranceAmount(String insuranceAmount, String coef) {
		this.insuranceAmount.saveInsuranceAmount(new InsuranceAmount(insuranceAmount, Double.parseDouble(coef)));
	}

	public void removeInsuranceAmount(String insuranceAmount, String coef) {
		this.insuranceAmount.removeInsuranceAmount(new InsuranceAmount(insuranceAmount, Double.parseDouble(coef)));
	}

	public void updateInsuranceAmount(String IDInsuranceAmount) {
		InsuranceAmount insuran = insuranceAmount.findInsuranceAmountById(Integer.parseInt(IDInsuranceAmount));
		insuran.setSumInsurance(IDInsuranceAmount);
		insuranceAmount.updateInsuranceAmount(insuran);

	}

	public InsuranceAmount findInsuranceAmountById(int id) {
		return insuranceAmount.findInsuranceAmountById(id);
	}

	public List<InsuranceAmount> findAllInsuranceAmount() {
		return insuranceAmount.findAllInsuranceAmount();
	}

}
