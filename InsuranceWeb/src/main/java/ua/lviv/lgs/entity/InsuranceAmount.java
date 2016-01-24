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
	private double coef;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY,mappedBy="insuranceAmount")
	private List<Tariff> tariff;
	public InsuranceAmount() {
	
	}
	public InsuranceAmount( String sumInsurance, double coef) {
		super();
		this.sumInsurance = sumInsurance;
		this.coef = coef;
	}
	public int getId() {
		return id;
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
	
	public double getCoef() {
		return coef;
	}
	public void setCoef(double coef) {
		this.coef = coef;
	}
	@Override
	public String toString() {
		return "InsuranceAmount [id=" + id + ", sumInsurance=" + sumInsurance + ", tariff=" + tariff + "]";
	}
	
}
