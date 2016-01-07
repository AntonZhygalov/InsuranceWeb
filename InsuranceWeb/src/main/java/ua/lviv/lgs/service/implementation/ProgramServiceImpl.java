package ua.lviv.lgs.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ProgramDao;
import ua.lviv.lgs.entity.Program;
import ua.lviv.lgs.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {
	@Autowired
	private ProgramDao programDao;

	public void saveProgram(String program) {
		this.programDao.saveProgram(new Program(program));
	}

	public void removeProgram(String program) {
		this.programDao.removeProgram(new Program(program));
	}

	public void updateProgram(String program) {
		Program prog = programDao.findProgramById(Integer.parseInt(program));
		prog.setType(program);
		programDao.updateProgram(prog);
	}

	public Program findProgramById(int id) {
		return programDao.findProgramById(id);
	}

	public List<Program> findAllProgram() {
		return programDao.findAllProgram();
	}

}
