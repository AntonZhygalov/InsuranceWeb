package ua.lviv.lgs.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.PersonDao;
import ua.lviv.lgs.entity.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;

	@Transactional
	public void savePerson(Person person) {

		em.persist(person);

	}

	@Transactional
	public void removePerson(Person person) {

		em.remove(person);

	}

	@Transactional
	public List<Person> findAllPerson() {

		return em.createQuery("from Person", Person.class).getResultList();

	}

	@Transactional
	public void updatePerson(Person person) {
		em.merge(person);

	}

	@Transactional
	public Person findPersonById(int id) {
		return em.createQuery("from Person where id like :id", Person.class).setParameter("id", id).getSingleResult();
	}

	public List<Person> findAllPersonOfDateRegistration() {
		
		return em.createNamedQuery("Person.findAllPersonOfDateRegistration", Person.class).getResultList();
	}

}
