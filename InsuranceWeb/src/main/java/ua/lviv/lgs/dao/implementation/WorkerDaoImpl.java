package ua.lviv.lgs.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.WorkerDao;
import ua.lviv.lgs.entity.Worker;


@Repository
public class WorkerDaoImpl implements WorkerDao {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;

	@Transactional
	public List<Worker> findAllWorkers() {
		return em.createQuery("from Worker", Worker.class).getResultList();	
	}
	@Transactional
	public void saveWorker(Worker worker) {
		em.persist(worker);
		
	}
	@Transactional
	public void removeWorker(Worker worker) {
		em.remove(worker);
		
	}
	@Transactional
	public void updateWorker(Worker worker) {
		em.merge(worker);
		
	}
	@Transactional
	public Worker findWorkerById(int id) {
		return em.find(Worker.class, id);
	
	}
	@Transactional
	public Worker findByLogin(String login) {
		return em
				.createQuery("select c from Worker c where c.workerName like :login",
						Worker.class).setParameter("login", login)
				.getSingleResult();
	}
}
