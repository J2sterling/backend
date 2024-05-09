package edu.uao.edu.backend.RefugioAnimales;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAnimales {

    private final AnimalesRepository animalesRepository;

    public ServicioAnimales(AnimalesRepository animalesRepository) {
        this.animalesRepository = animalesRepository;
    }

    public List<Animales> findAll() {
        return animalesRepository.findAll();
    }

    public Animales findById(Long id) {
        return animalesRepository.findById(id).orElse(null);
    }

    public Animales save(Animales animal) {
        return animalesRepository.save(animal);
    }

    public void deleteById(Long id) {
        animalesRepository.deleteById(id);
    }

    public List<Animales> findByRaza(String raza) {
        return animalesRepository.findByRaza(raza);
    }

    public List<Animales> findByVacunado(Boolean vacunado) {
        return animalesRepository.findByVacunado(vacunado);
    }

    public List<Animales> findByEsterilizado(Boolean esterilizado) {
        return animalesRepository.findByEsterilizado(esterilizado);
    }
}

