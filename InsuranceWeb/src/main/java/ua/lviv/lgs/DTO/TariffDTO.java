package ua.lviv.lgs.DTO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TariffDTO {
	private int id;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String program;
	private String franchise;
	private String zone;
	private String additionalConditions;
	private String insuranceAmount;
	private int limitDay;
	private String fromDate;
	private String untilDate;
	private int cost;
	private String personId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getFranchise() {
		return franchise;
	}

	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getAdditionalConditions() {
		return additionalConditions;
	}

	public void setAdditionalConditions(String additionalConditions) {
		this.additionalConditions = additionalConditions;
	}

	public String getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(String insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public int getLimitDay() {
		return limitDay;
	}

	public void setLimitDay(int limitDay) {
		this.limitDay = limitDay;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = dateFormat.format(fromDate.getTime());
	}

	public String getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(Calendar untilDate) {
		this.untilDate = dateFormat.format(untilDate.getTime());
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
