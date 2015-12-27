package ua.lviv.lgs.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.TariffDao;

import ua.lviv.lgs.entity.Tariff;

@Repository
public class TariffDaoImpl implements TariffDao {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;

	@Transactional
	public void saveTariff(Tariff tariff) {

		em.persist(tariff);

	}

	@Transactional
	public void removeTariff(Tariff tariff) {

		em.remove(tariff);

	}

	@Transactional
	public List<Tariff> findAllTariff() {

		return em.createQuery("from Tariff", Tariff.class).getResultList();
	}

	@Transactional
	public void updateTariff(Tariff tariff) {
		em.merge(tariff);

	}

	@Transactional
	public Tariff findTariffById(int id) {
		return em.createQuery("from Tariff where id like :id", Tariff.class).setParameter("id", id).getSingleResult();
	}

}
