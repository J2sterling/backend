package edu.uao.edu.backend.DuenoRefugio;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface DuenoRefugioRepository extends JpaRepository<DuenoRefugio, Long> {
    List<DuenoRefugio> findByNombreContaining(String nombre);
}

