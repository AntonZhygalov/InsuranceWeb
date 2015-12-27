package ua.lviv.lgs.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.FranchiseDao;
import ua.lviv.lgs.entity.Franchise;

@Repository
public class FranchiseDaoImpl implements FranchiseDao {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;

	@Transactional
	public void saveFranchise(Franchise franchise) {

		em.persist(franchise);
	}

	@Transactional
	public void removeFranchise(Franchise franchise) {
		em.remove(franchise);
	}

	@Transactional
	public List<Franchise> findAllFranchise() {
		return em.createQuery("from Franchise", Franchise.class).getResultList();
	}

	@Transactional
	public void updateFranchise(Franchise franchise) {
		em.merge(franchise);

	}

	@Transactional
	public Franchise findFranchiseById(int id) {

		return em.find(Franchise.class, id);
	}

}
