package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import dev.entite.Plat;

public interface IPlatDao {
    List<Plat> listerPlats();
    
    void ajouterPlat(String nomPlat, Integer prixPlat);

}
