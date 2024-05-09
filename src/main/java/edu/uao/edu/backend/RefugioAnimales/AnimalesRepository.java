package edu.uao.edu.backend.RefugioAnimales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AnimalesRepository extends JpaRepository <Animales, Long> {
    List<Animales> findByRaza(String raza);
    List<Animales> findByVacunado(Boolean vacunado);
    List<Animales> findByEsterilizado(Boolean esterilizado);
}
