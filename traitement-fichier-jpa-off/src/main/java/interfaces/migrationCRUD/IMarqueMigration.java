package interfaces.migrationCRUD;

import java.io.IOException;
import java.util.List;

import database.ConnectionDatabase;
import entities.Magasin;
import entities.Marque;
public interface IMarqueMigration {
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException;
}
