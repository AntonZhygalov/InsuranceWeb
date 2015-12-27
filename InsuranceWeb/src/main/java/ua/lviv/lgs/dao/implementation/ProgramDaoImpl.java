package ua.lviv.lgs.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.ProgramDao;

import ua.lviv.lgs.entity.Program;

@Repository
public class ProgramDaoImpl implements ProgramDao {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;

	@Transactional
	public void saveProgram(Program program) {

		em.persist(program);

	}

	@Transactional
	public void removeProgram(Program program) {

		em.remove(program);

	}

	@Transactional
	public List<Program> findAllProgram() {
		return em.createQuery("from Program", Program.class).getResultList();
	}

	@Transactional
	public void updateProgram(Program program) {
		em.merge(program);

	}

	@Transactional
	public Program findProgramById(int id) {
		
		return em.createQuery("from Program where id like :id", Program.class).setParameter("id", id).getSingleResult();
	}

}
