package ua.lviv.lgs.dao;


import java.util.List;


import ua.lviv.lgs.entity.Program;

public interface ProgramDao {

	void saveProgram(Program program);

	void removeProgram(Program program);
	
	void updateProgram(Program program);

	Program findProgramById(int id);

	List<Program> findAllProgram();
	
}
