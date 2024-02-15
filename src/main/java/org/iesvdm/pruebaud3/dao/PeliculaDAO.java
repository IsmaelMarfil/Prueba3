package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.modelo.Idioma;
import org.iesvdm.pruebaud3.modelo.Pelicula;

import java.util.List;

public interface PeliculaDAO {
    public List<Pelicula> getAll();
    public void create(Pelicula pelicula);
    public List<Idioma> getAllIdioma();
    public List<Pelicula> getPeliculaByIdCategoria(int idCategoria);

}
