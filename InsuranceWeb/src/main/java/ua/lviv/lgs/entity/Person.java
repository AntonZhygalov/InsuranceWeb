package ua.lviv.lgs.entity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@NamedQueries({
	
	@NamedQuery(name = "Person.findByDate", query = "select a from Person a where a.dateOfRegistration = :dateRegistration")
	 })
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fNamelName;
	@Column(unique = true)
	private int number;
	private String passportSeries;
	private String passportNumber;
	private String identification;
	private String addres;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfRegistration;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirsthday;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	List<Tariff> tariff;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String fNamelName, int number, String passportSeries,
			String passportNumber, String identification, String addres,
			Date dateOfRegistration, Date dateOfBirsthday) {
		super();
		this.fNamelName = fNamelName;
		this.number = number;
		this.passportSeries = passportSeries;
		this.passportNumber = passportNumber;
		this.identification = identification;
		this.addres = addres;
		this.dateOfRegistration = dateOfRegistration;
		this.dateOfBirsthday = dateOfBirsthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfNamelName() {
		return fNamelName;
	}

	public void setfNamelName(String fNamelName) {
		this.fNamelName = fNamelName;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Date getDateOfBirsthday() {
		return dateOfBirsthday;
	}

	public void setDateOfBirsthday(Date dateOfBirsthday) {
		this.dateOfBirsthday = dateOfBirsthday;
	}

	public List<Tariff> getTariff() {
		return tariff;
	}

	public void setTariff(List<Tariff> tariff) {
		this.tariff = tariff;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPassportSeries() {
		return passportSeries;
	}

	public void setPassportSeries(String passportSeries) {
		this.passportSeries = passportSeries;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fNamelName=" + fNamelName + ", number="
				+ number + ", passportSeries=" + passportSeries
				+ ", passportNumber=" + passportNumber + ", identification="
				+ identification + ", addres=" + addres
				+ ", dateOfRegistration=" + dateOfRegistration
				+ ", dateOfBirsthday=" + dateOfBirsthday + "]";
	}

}
