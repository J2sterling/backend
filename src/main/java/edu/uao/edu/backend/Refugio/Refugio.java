package edu.uao.edu.backend.Refugio;

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
@Table(name = "Refugio")
public class Refugio {

    @Id
    @Column(name = "IdDelRefugio")
    private Long id;

    @Column(name = "NombreDelRef")
    private String nombre;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "PoblacionMax")
    private Integer poblacionMaxima;
}

