package ua.lviv.lgs.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.InsuranceAmountDao;
import ua.lviv.lgs.entity.InsuranceAmount;
import ua.lviv.lgs.service.InsuranceAmountService;

@Service
public class InsuranceAmountServiceImpl implements InsuranceAmountService {
	@Autowired
	public InsuranceAmountDao insuranceAmount;
	@Transactional
	public void saveInsuranceAmount(String insuranceAmount, String coef) {
		this.insuranceAmount.saveInsuranceAmount(new InsuranceAmount(insuranceAmount, Double.parseDouble(coef)));
	}
	@Transactional
	public void removeInsuranceAmount(String insuranceAmount) {
		InsuranceAmount add= this.findInsuranceAmountById(Integer.parseInt(insuranceAmount));
		this.insuranceAmount.removeInsuranceAmount(add);
	}
	@Transactional
	public void updateInsuranceAmount(String idInsuranceAmount) {
		InsuranceAmount insuran = insuranceAmount.findInsuranceAmountById(Integer.parseInt(idInsuranceAmount));
		insuran.setSumInsurance(idInsuranceAmount);
		insuranceAmount.updateInsuranceAmount(insuran);

	}
	@Transactional
	public InsuranceAmount findInsuranceAmountById(int id) {
		return insuranceAmount.findInsuranceAmountById(id);
	}
	@Transactional
	public List<InsuranceAmount> findAllInsuranceAmount() {
		return insuranceAmount.findAllInsuranceAmount();
	}

}
