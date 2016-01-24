package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.dao.InsuranceAmountDao;
import ua.lviv.lgs.entity.InsuranceAmount;

public interface InsuranceAmountService {
	void saveInsuranceAmount(String insuranceAmount, String coef);

	void removeInsuranceAmount(String insuranceAmount, String coef);

	void updateInsuranceAmount(String insuranceAmount);

	InsuranceAmount findInsuranceAmountById(int id);

	List<InsuranceAmount> findAllInsuranceAmount();
}
