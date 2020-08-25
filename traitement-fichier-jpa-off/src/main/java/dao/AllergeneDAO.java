package dao;

import java.io.IOException;
import java.util.List;

import database.ConnectionDatabase;
import entities.Magasin;
import interfaces.migrationCRUD.ICRUDMirgration;

public class AllergeneDAO implements ICRUDMirgration {

	@Override
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
