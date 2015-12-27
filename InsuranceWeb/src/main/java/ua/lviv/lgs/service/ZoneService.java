package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.entity.Zone;

public interface ZoneService {
	void saveZone(String zone);

	void removeZone(String zone);

	void updateZone(Zone zone);

	Zone findZoneById(int id);

	List<Zone> findAllZone();
}
