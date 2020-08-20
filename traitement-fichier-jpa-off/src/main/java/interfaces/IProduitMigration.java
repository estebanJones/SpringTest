package interfaces;

import java.io.IOException;
import java.util.List;

import database.ConnectionDatabase;
import entities.Magasin;

public interface IProduitMigration {
	public void insertCSV(List<Magasin> mag, ConnectionDatabase connection) throws IOException;
}
