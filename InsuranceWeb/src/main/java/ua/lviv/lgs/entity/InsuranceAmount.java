package ua.lviv.lgs.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InsuranceAmount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String sumInsurance;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY,mappedBy="insuranceAmount")
	private List<Tariff> tariff;
	public InsuranceAmount() {
	
	}
	public InsuranceAmount(String sumInsurance) {
		super();
		this.sumInsurance = sumInsurance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSumInsurance() {
		return sumInsurance;
	}
	public void setSumInsurance(String sumInsurance) {
		this.sumInsurance = sumInsurance;
	}
	public List<Tariff> getTariff() {
		return tariff;
	}
	public void setTariff(List<Tariff> tariff) {
		this.tariff = tariff;
	}
	@Override
	public String toString() {
		return "InsuranceAmount [id=" + id + ", sumInsurance=" + sumInsurance + ", tariff=" + tariff + "]";
	}
	
}
