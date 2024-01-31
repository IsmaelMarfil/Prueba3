package org.iesvdm.pruebaud3.modelo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    private int id;
    @NotBlank
    @NotNull
    @Length(min = 3, message = "Debe tener mas de 3 caracteres")
    private String titulo;
    @Length(max = 300, message = "No puede tener mas de 300 caracteres")
    private String descripcion;
    private Date fechaLanzamiento;
    private int idIdioma;
    private int duracionAlquiler;
    @DecimalMin(value = "0", message = "Debe ser mayor a 0")
    private double rentalRate;
    @DecimalMin(value = "0", message = "La duracion debe ser mayor a 0")
    private int duracion;
    @DecimalMin(value = "19.99", message = "Debe ser mayor a  19.99")
    private double replacementCost;
    private Date ultimaActualizacion;

}
