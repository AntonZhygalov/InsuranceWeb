package ua.lviv.lgs.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.WorkerDao;
import ua.lviv.lgs.entity.Worker;
import ua.lviv.lgs.service.WorkerService;

@Service("userDetailsService")
public class WorkerServiceImpl implements WorkerService, UserDetailsService {
	@Autowired
	WorkerDao workerDao;

	@Transactional
	public void saveWorker(String workerName, String workerPassword) {
		Worker newWorker = new Worker();
		newWorker.setWorkerName(workerName);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		workerPassword = passwordEncoder.encode(workerPassword);
		newWorker.setWorkerPassword(workerPassword);
		workerDao.saveWorker(newWorker);
	}

	@Transactional
	public void removeWorker(String id) {
		workerDao.removeWorker(workerDao.findWorkerById(Integer.parseInt(id)));
	}

	@Transactional
	public void updateWorker(int id, String workerName, String workerPassword) {
		Worker worker = workerDao.findWorkerById(id);
		worker.setWorkerName(workerName);
		worker.setWorkerPassword(workerPassword);
		workerDao.updateWorker(worker);

	}

	@Transactional
	public Worker findWorkerById(String id) {
		return workerDao.findWorkerById(Integer.parseInt(id));
	}

	@Transactional
	public List<Worker> findAllWorkers() {
		return workerDao.findAllWorkers();
	}

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Worker usernew = null;
		try {

			usernew = workerDao.findByLogin(login);
		} catch (NoResultException e) {
			return null;
		}

		// Колекція ролей користувача. Використовується SimpleGrantedAuthority,
		// для створення об'єкту необхідно вказати назву ролі.
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		// User - клас зі Spring Security, об'єкт якого є поточним залогіненим
		// користувачем.
		// username може бути як і логін, та і id юзера в базі даних. Але id
		// буде оптимальніше.
		return new org.springframework.security.core.userdetails.User(String.valueOf(usernew.getId()),
				usernew.getWorkerPassword(), authorities);
	}



}
