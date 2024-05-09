package edu.uao.edu.backend.Refugio;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refugios")
public class RefugioController {

    private final RefugioRepository refugioRepository;

    public RefugioController(RefugioRepository refugioRepository) {
        this.refugioRepository = refugioRepository;
    }

    @GetMapping
    public List<Refugio> getAllRefugios() {
        return refugioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refugio> getRefugioById(@PathVariable Long id) {
        return refugioRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Refugio createRefugio(@RequestBody Refugio refugio) {
        return refugioRepository.save(refugio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refugio> updateRefugio(@PathVariable Long id, @RequestBody Refugio updatedRefugio) {
        return refugioRepository.findById(id)
            .map(refugio -> {
                refugio.setNombre(updatedRefugio.getNombre());
                refugio.setDireccion(updatedRefugio.getDireccion());
                refugio.setPoblacionMaxima(updatedRefugio.getPoblacionMaxima());
                refugioRepository.save(refugio);
                return ResponseEntity.ok(refugio);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRefugio(@PathVariable Long id) {
        if (!refugioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        refugioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
