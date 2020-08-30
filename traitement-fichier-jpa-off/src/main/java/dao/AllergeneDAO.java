package dao;

import java.io.IOException;
import java.util.List;

import database.ManagerConnection;
import entities.Magasin;
import interfaces.migrationCRUD.ICRUDMirgration;

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
