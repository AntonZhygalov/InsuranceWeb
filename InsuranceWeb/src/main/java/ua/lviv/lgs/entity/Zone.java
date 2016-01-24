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
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String zone;
	private double coef;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY,mappedBy="zone")
	private List<Tariff> tariff;

	public Zone() {

	}

	public Zone(String zone, double coef) {
		super();
		this.zone = zone;
		this.coef = coef;
	}

	public int getId() {
		return id;
	}



	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
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
		return "Zone [id=" + id + ", zone=" + zone + ", tariff=" + tariff + "]";
	}

}
