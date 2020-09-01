package fr.traitement.dao;

import java.io.IOException;
import java.util.List;

import fr.traitement.database.ManagerConnection;
import fr.traitement.entities.Magasin;
import fr.traitement.interfaces.migrationCrud.ICRUDMirgration;

/**
 * 
 * @author Jordan
 *
 */
public class AllergeneDAO implements ICRUDMirgration {

	@Override
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
