package edu.uao.edu.backend.RefugioAnimales;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animales")
public class AnimalesController {

    private final AnimalesRepository animalesRepository;

    public AnimalesController(AnimalesRepository animalesRepository) {
        this.animalesRepository = animalesRepository;
    }

    @GetMapping
    public List<Animales> getAllAnimales() {
        return animalesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animales> getAnimalById(@PathVariable Long id) {
        return animalesRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animales createAnimal(@RequestBody Animales animal) {
        return animalesRepository.save(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animales> updateAnimal(@PathVariable Long id, @RequestBody Animales updatedAnimal) {
        return animalesRepository.findById(id)
            .map(animal -> {
                animal.setNombre(updatedAnimal.getNombre());
                animal.setEspecie(updatedAnimal.getEspecie());
                animal.setRaza(updatedAnimal.getRaza());
                animal.setEdad(updatedAnimal.getEdad());
                animal.setVacunado(updatedAnimal.getVacunado());
                animal.setEsterilizado(updatedAnimal.getEsterilizado());
                return ResponseEntity.ok(animalesRepository.save(animal));
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Long id) {
        return animalesRepository.findById(id)
            .map(animal -> {
                animalesRepository.deleteById(id);
                return ResponseEntity.ok().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/raza/{raza}")
    public List<Animales> getAnimalesPorRaza(@PathVariable String raza) {
        return animalesRepository.findByRaza(raza);
    }

    @GetMapping("/vacunados/{estado}")
    public List<Animales> getAnimalesVacunados(@PathVariable Boolean estado) {
        return animalesRepository.findByVacunado(estado);
    }
}