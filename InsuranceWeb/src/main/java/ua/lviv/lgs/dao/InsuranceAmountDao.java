package ua.lviv.lgs.dao;

import java.util.List;

import ua.lviv.lgs.entity.InsuranceAmount;

public interface InsuranceAmountDao {
	void saveInsuranceAmount(InsuranceAmount insuranceAmount);

	void removeInsuranceAmount(InsuranceAmount insuranceAmount);

	void updateInsuranceAmount(InsuranceAmount insuranceAmount);

	InsuranceAmount findInsuranceAmountById(int id);

	List<InsuranceAmount> findAllInsuranceAmount();
}
