package edu.uao.edu.backend.Refugio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefugioRepository extends JpaRepository<Refugio, Long> {
    List<Refugio> findByPoblacionMax(int poblacionMax);
    List<Refugio> findByNombreContaining(String nombre);
    List<Refugio> findByDireccionContaining(String direccion);
}
