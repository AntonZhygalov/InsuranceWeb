package ua.lviv.lgs.dao;

import java.util.List;

import ua.lviv.lgs.entity.Person;

public interface PersonDao {
	void savePerson(Person person);

	void removePerson(Person person);

	void updatePerson(Person person);

	Person findPersonById(int id);

	List<Person> findAllPerson();
	
	List<Person> findAllPersonOfDateRegistration();
}
