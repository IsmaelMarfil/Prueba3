package org.iesvdm.pruebaud3.servicio;

import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.iesvdm.pruebaud3.dao.PeliculaDAO;

import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaDAO peliculaDAO;

    public List<Pelicula> listAll() {

        return peliculaDAO.getAll();


    }
    public void newPelicula(Pelicula pelicula) {

        peliculaDAO.create(pelicula);

    }
}
