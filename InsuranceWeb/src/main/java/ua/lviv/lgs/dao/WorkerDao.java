package ua.lviv.lgs.dao;

import java.util.List;


import ua.lviv.lgs.entity.Worker;

public interface WorkerDao {
	void saveWorker(Worker worker);

	void removeWorker(Worker worker);

	void updateWorker(Worker worker);

	Worker findWorkerById(int id);

	List<Worker> findAllWorkers();
	
	Worker findByLogin(String login);
	
}
