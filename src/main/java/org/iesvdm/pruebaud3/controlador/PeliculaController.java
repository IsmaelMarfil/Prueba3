package org.iesvdm.pruebaud3.controlador;

import jakarta.validation.Valid;
import org.iesvdm.pruebaud3.dao.PeliculaDAO;
import org.iesvdm.pruebaud3.modelo.Idioma;
import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.iesvdm.pruebaud3.servicio.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private PeliculaDAO peliculaDAO ;
    @GetMapping("/peliculas")
    public String listar(Model model) {

        List<Pelicula> listAllPel =  peliculaService.listAll();
        model.addAttribute("listaPeliculas", listAllPel);
        long conteo=peliculaService.conteoPeliculas();
        model.addAttribute("conteo",conteo);
        model.addAttribute("listaPeliculasHorror",peliculaDAO.getPeliculaByIdCategoria(5));
        model.addAttribute("conteoPelisTerror",peliculaService.peliculaPorCategoriaconteo(5));
        return "peliculas";

    }

    @GetMapping("/peliculas/crear")
    public String crear(Model model) {
        List<Idioma> listAllIdioma=peliculaService.listAllIdioma();
        Pelicula pelicula = new Pelicula();

        model.addAttribute("listaIdioma",listAllIdioma);
        model.addAttribute("pelicula", pelicula);

        return "crear-pelicula";

    }

    @PostMapping("/peliculas/crear")
    public String submitCrear(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("pelicula", pelicula);
            return "crear-pelicula";
        }

        peliculaService.newPelicula(pelicula);
        return "redirect:/peliculas?newPeliculaID=" + pelicula.getId();

    }
}
