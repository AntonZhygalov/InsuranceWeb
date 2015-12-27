package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.dao.InsuranceAmountDao;
import ua.lviv.lgs.entity.InsuranceAmount;

public interface InsuranceAmountService {
	void saveInsuranceAmount(String insuranceAmount);

	void removeInsuranceAmount(String insuranceAmount);

	void updateInsuranceAmount(InsuranceAmount insuranceAmount);

	InsuranceAmountDao findInsuranceAmountById(int id);

	List<InsuranceAmountDao> findAllInsuranceAmount();
}
