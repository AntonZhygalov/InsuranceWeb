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
public class Franchise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String sumFranchise;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "franchise")
	private List<Tariff> tariff;

	public Franchise() {

	}

	public Franchise(String sumFranchise) {
		super();
		this.sumFranchise = sumFranchise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSumFranchise() {
		return sumFranchise;
	}

	public void setSumFranchise(String sumFranchise) {
		this.sumFranchise = sumFranchise;
	}

	public List<Tariff> getTariff() {
		return tariff;
	}

	public void setTariff(List<Tariff> tariff) {
		this.tariff = tariff;
	}

	@Override
	public String toString() {
		return "Franchise [id=" + id + ", suFranchise=" + sumFranchise
				+ ", tariff=" + tariff + "]";
	}

}
