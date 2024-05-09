package edu.uao.edu.backend.DuenoRefugio;



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
@Table(name = "DuenoRef")
public class DuenoRefugio {

    @Id
    @Column(name = "IdDuenoRef")
    private Long id;

    @Column(name = "NombreDelDueno")
    private String nombre;
}

