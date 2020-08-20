package interfaces;

import java.io.IOException;
import java.util.List;

import entities.Magasin;

public interface IIngredientMigration {
	public void insertCSVtoDB() throws IOException;
}
