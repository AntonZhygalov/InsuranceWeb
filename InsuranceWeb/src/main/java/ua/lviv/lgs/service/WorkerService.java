package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import ua.lviv.lgs.entity.Worker;



public interface WorkerService {
	void saveWorker(String workerName,String workerPassword );

	void removeWorker(String id);

	void updateWorker(int id,String workerName,String workerPassword );

	Worker findWorkerById(String id);

	List<Worker> findAllWorkers();
	
	UserDetails loadUserByUsername(String login);
	
}
