package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.Program;

public interface ProgramService {

	void saveProgram(String program, String coef);

	void removeProgram(String program, String coef);
	
	void updateProgram(String program);

	Program findProgramById(int id);

	List<Program> findAllProgram();
}
