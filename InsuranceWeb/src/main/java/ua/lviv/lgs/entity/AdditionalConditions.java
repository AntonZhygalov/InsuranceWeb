package ua.lviv.lgs.entity;
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

import org.hibernate.annotations.GeneratorType;

@Entity
public class AdditionalConditions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String additionalConditions;
	private double coef;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "additionalConditions")
	private List<Tariff> tariff;

	public AdditionalConditions() {
	}

	public AdditionalConditions(String additionalConditions, double coef) {
		super();
		this.additionalConditions = additionalConditions;
		this.coef = coef;
	}

	public int getId() {
		return id;
	}



	public String getAdditionalConditions() {
		return additionalConditions;
	}

	public void setAdditionalConditions(String additionalConditions) {
		this.additionalConditions = additionalConditions;
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
		return "AdditionalConditions [id=" + id + ", additionalConditions="
				+ additionalConditions + ", tariff=" + tariff + "]";
	}

}
