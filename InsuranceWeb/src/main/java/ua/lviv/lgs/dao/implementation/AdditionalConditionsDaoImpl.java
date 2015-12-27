package ua.lviv.lgs.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.AdditionalConditionsDao;
import ua.lviv.lgs.entity.AdditionalConditions;

@Repository
public class AdditionalConditionsDaoImpl implements AdditionalConditionsDao {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;

	@Transactional
	public void saveAdditionalConditions(AdditionalConditions additionalConditions) {
		em.persist(additionalConditions);

	}

	@Transactional
	public void removeAdditionalConditions(AdditionalConditions additionalConditions) {
		em.remove(additionalConditions);
	}

	@Transactional
	public List<AdditionalConditions> findAllAdditionalConditions() {
		return em.createQuery("from AdditionalConditions", AdditionalConditions.class).getResultList();
	}

	@Transactional
	public void updateAdditionalConditions(AdditionalConditions additionalConditions) {
		em.merge(additionalConditions);

	}

	@Transactional
	public AdditionalConditions findAdditionalConditionsById(int id) {
		return em.createQuery("from AdditionalConditions where id like :id", AdditionalConditions.class)
				.setParameter("id", id).getSingleResult();
	}

}
