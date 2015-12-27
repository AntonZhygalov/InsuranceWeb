package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.Program;

public interface ProgramService {

	void saveProgram(String program);

	void removeProgram(String program);
	
	void updateProgram(Program program);

	Program findProgramById(int id);

	List<Program> findAllProgram();
}
