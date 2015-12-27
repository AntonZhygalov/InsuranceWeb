package ua.lviv.lgs.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String program;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "program")
	private List<Tariff> tariff;

	public Program() {

	}

	public Program(String type) {
		super();
		this.program = program;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgram() {
		return program;
	}

	public void setType(String type) {
		this.program = program;
	}

	public List<Tariff> getTariff() {
		return tariff;
	}

	public void setTariff(List<Tariff> tariff) {
		this.tariff = tariff;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", program=" + program + ", tariff="
				+ tariff + "]";
	}

}
