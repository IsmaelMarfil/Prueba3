package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.modelo.Pelicula;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilDAO {
    public static Pelicula newPelicula(ResultSet rs) throws SQLException {
        return new Pelicula(
                rs.getInt("id_pelicula"),
                rs.getString("titulo"),
                rs.getDate("fecha_lanzamiento"),
                rs.getInt("id_idioma"),
                rs.getInt("duracion_alquiler"),
                rs.getDouble("rental_rate"),
                rs.getInt("duracion"),
                rs.getDouble("replacement_cost"),
                rs.getDate("ultima_actualizacion")
        );
    }
}
