package ua.lviv.lgs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Worker  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	String workerName;
	String workerPassword;
	public Worker() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getWorkerPassword() {
		return workerPassword;
	}
	public void setWorkerPassword(String workerPassword) {
		this.workerPassword = workerPassword;
	}

}
