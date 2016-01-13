package ua.lviv.lgs.entity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tariff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Program program;
	@ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Franchise franchise;
	@ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Zone zone;
	@ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	private AdditionalConditions additionalConditions;
	@ManyToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	private InsuranceAmount insuranceAmount;
	private int limitDay;
	@Temporal(TemporalType.DATE)
	private Calendar fromDate;
	@Temporal(TemporalType.DATE)
	private Calendar untilDate;
	private int cost;
	@ManyToMany(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Person> person;

	public Tariff() {
		
	}

	public int getId() {
		return id;
	}

	

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Franchise getFranchise() {
		return franchise;
	}

	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public AdditionalConditions getAdditionalConditions() {
		return additionalConditions;
	}

	public void setAdditionalConditions(
			AdditionalConditions additionalConditions) {
		this.additionalConditions = additionalConditions;
	}

	public InsuranceAmount getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(InsuranceAmount insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public int getLimitDay() {
		return limitDay;
	}

	public void setLimitDay(int limitDay) {
		this.limitDay = limitDay;
	}

	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	public Calendar getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(Calendar untilDate) {
		this.untilDate = untilDate;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Tariff [limitDay=" + limitDay + ", fromDate=" + fromDate
				+ ", untilDate=" + untilDate + ", cost=" + cost + "]";
	}

}
