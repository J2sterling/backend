package edu.uao.edu.backend.Refugio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefugioService {

    private final RefugioRepository refugioRepository;

    public RefugioService(RefugioRepository refugioRepository) {
        this.refugioRepository = refugioRepository;
    }

    public List<Refugio> findAll() {
        return refugioRepository.findAll();
    }

    public Refugio findById(Long id) {
        return refugioRepository.findById(id).orElse(null);
    }

    public Refugio save(Refugio refugio) {
        return refugioRepository.save(refugio);
    }

    public void deleteById(Long id) {
        refugioRepository.deleteById(id);
    }

    public List<Refugio> findByPoblacionMax(int poblacionMax) {
        return refugioRepository.findByPoblacionMax(poblacionMax);
    }

    public List<Refugio> findByNombre(String nombre) {
        return refugioRepository.findByNombreContaining(nombre);
    }

    public List<Refugio> findByDireccion(String direccion) {
        return refugioRepository.findByDireccionContaining(direccion);
    }
}
