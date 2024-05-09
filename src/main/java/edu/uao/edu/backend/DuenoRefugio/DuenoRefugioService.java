package edu.uao.edu.backend.DuenoRefugio;

import edu.uao.edu.backend.DuenoRefugio.DuenoRefugioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoRefugioService {

    private final DuenoRefugioRepository duenoRefugioRepository;

    public DuenoRefugioService(DuenoRefugioRepository duenoRefugioRepository) {
        this.duenoRefugioRepository = duenoRefugioRepository;
    }

    public List<DuenoRefugio> findAll() {
        return duenoRefugioRepository.findAll();
    }

    public List<DuenoRefugio> findByNombre(String nombre) {
        return duenoRefugioRepository.findByNombreContaining(nombre);
    }

    public DuenoRefugio findById(Long id) {
        return duenoRefugioRepository.findById(id).orElse(null);
    }

    public DuenoRefugio save(DuenoRefugio duenoRefugio) {
        return duenoRefugioRepository.save(duenoRefugio);
    }

    public void deleteById(Long id) {
        duenoRefugioRepository.deleteById(id);
    }
}

