package ua.lviv.lgs.DTO;


import java.util.List;

import ua.lviv.lgs.entity.Tariff;

public class PersonDTO {
		public PersonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

		private int id;
		private String fNamelName;
		private int number;
		private String passportSeries;
		private String passportNumber;
		private String identification;
		private String addres;
		
		private String dayOfregistration;
		
		private String dayOfBirthday;
		
		List<Tariff> tariff;

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

		public String getDayOfregistration() {
			return dayOfregistration;
		}

		public void setDayOfregistration(String dayOfregistration) {
			this.dayOfregistration = dayOfregistration;
		}

		public String getDayOfBirthday() {
			return dayOfBirthday;
		}

		public void setDayOfBirthday(String dayOfBirthday) {
			this.dayOfBirthday = dayOfBirthday;
		}

		public List<Tariff> getTariff() {
			return tariff;
		}

		public void setTariff(List<Tariff> tariff) {
			this.tariff = tariff;
		}
		
}
