package ua.lviv.lgs.DTO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ua.lviv.lgs.entity.Tariff;

public class PersonToShow {
		private int id;
		private String fNamelName;
		private int number;
		private String passportSeries;
		private String passportNumber;
		private String identification;
		private String addres;
		private int dayOfregistration;
		private int mountsOfregistration;
		private int yearOfregistration;
		private int dayOfBirthday;
		private int mountsOfBirthday;
		private int yearOfBirthday;
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
		public int getDayOfregistration() {
			return dayOfregistration;
		}
		public void setDayOfregistration(int dayOfregistration) {
			this.dayOfregistration = dayOfregistration;
		}
		public int getMountsOfregistration() {
			return mountsOfregistration;
		}
		public void setMountsOfregistration(int mountsOfregistration) {
			this.mountsOfregistration = mountsOfregistration;
		}
		public int getYearOfregistration() {
			return yearOfregistration;
		}
		public void setYearOfregistration(int yearOfregistration) {
			this.yearOfregistration = yearOfregistration;
		}
		public int getDayOfBirthday() {
			return dayOfBirthday;
		}
		public void setDayOfBirthday(int dayOfBirthday) {
			this.dayOfBirthday = dayOfBirthday;
		}
		public int getMountsOfBirthday() {
			return mountsOfBirthday;
		}
		public void setMountsOfBirthday(int mountsOfBirthday) {
			this.mountsOfBirthday = mountsOfBirthday;
		}
		public int getYearOfBirthday() {
			return yearOfBirthday;
		}
		public void setYearOfBirthday(int yearOfBirthday) {
			this.yearOfBirthday = yearOfBirthday;
		}
		public List<Tariff> getTariff() {
			return tariff;
		}
		public void setTariff(List<Tariff> tariff) {
			this.tariff = tariff;
		}
		

}
