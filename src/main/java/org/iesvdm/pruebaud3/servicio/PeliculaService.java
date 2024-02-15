package org.iesvdm.pruebaud3.servicio;

import org.iesvdm.pruebaud3.modelo.Idioma;
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
    public long conteoPeliculas(){
        List<Pelicula> listadoPeliculas=peliculaDAO.getAll();
        long conteo=listadoPeliculas.stream().count();
        return conteo;
    }
    public List<Idioma> listAllIdioma(){
        return  peliculaDAO.getAllIdioma();
    }
    public List<Pelicula> peliculaPorCategoria(int id_categoria){
        List<Pelicula> listPel = peliculaDAO.getPeliculaByIdCategoria(id_categoria);
        return listPel;
    }
}
