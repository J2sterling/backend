package edu.uao.edu.backend.RefugioAnimales;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Animal")
public class Animales {

    @Id
    @Column(name = "IdIndividuoAni")
    private Long id;

    @Column(name = "NombreAnimal")
    private String nombre;

    @Column(name = "Especie")
    private String especie;

    @Column(name = "Raza")
    private String raza;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Vacunado")
    private Boolean vacunado;

    @Column(name = "Esterilizado")
    private Boolean esterilizado;

    @Column(name = "EstSalud")
    private String estadoSalud;
}