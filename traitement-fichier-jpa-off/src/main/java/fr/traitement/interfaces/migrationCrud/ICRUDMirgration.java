package fr.traitement.interfaces.migrationCrud;

import java.io.IOException;
import java.util.List;

import fr.traitement.database.ManagerConnection;
import fr.traitement.entities.Magasin;

public interface ICRUDMirgration {
	public void insertCSV(List<Magasin> mag, ManagerConnection connection) throws IOException;
}
