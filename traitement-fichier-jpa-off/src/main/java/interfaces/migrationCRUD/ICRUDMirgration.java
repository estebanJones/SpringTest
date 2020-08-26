package interfaces.migrationCRUD;

import java.io.IOException;
import java.util.List;

import database.ManagerConnection;
import entities.Magasin;

public interface ICRUDMirgration {
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException;
}
