package ua.lviv.lgs.dao;

import java.util.List;


import ua.lviv.lgs.entity.Zone;

public interface ZoneDao {
	void saveZone(Zone zone);

	void removeZone(Zone zone);

	void updateZone(Zone zone);

	Zone findZoneById(int id);

	List<Zone> findAllZone();
}
