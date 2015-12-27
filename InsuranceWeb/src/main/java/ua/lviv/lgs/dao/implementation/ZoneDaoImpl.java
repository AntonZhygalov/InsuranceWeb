package ua.lviv.lgs.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.ZoneDao;

import ua.lviv.lgs.entity.Zone;

@Repository
public class ZoneDaoImpl implements ZoneDao {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;

	@Transactional
	public void saveZone(Zone zone) {

		em.persist(zone);

	}

	@Transactional
	public void removeZone(Zone zone) {

		em.remove(zone);

	}

	@Transactional
	public List<Zone> findAllZone() {
		return em.createQuery("from Zone", Zone.class).getResultList();
	}

	@Transactional
	public void updateZone(Zone zone) {
		em.merge(zone);

	}

	@Transactional
	public Zone findZoneById(int id) {
		return em.find(Zone.class, id);
	}

}
