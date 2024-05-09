package edu.uao.edu.backend.DuenoRefugio;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duenosrefugio")
public class DuenoRefugioController {

    private final DuenoRefugioRepository duenoRefugioRepository;

    public DuenoRefugioController(DuenoRefugioRepository duenoRefugioRepository) {
        this.duenoRefugioRepository = duenoRefugioRepository;
    }

    @GetMapping
    public List<DuenoRefugio> getAllDuenosRefugio() {
        return duenoRefugioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuenoRefugio> getDuenoRefugioById(@PathVariable Long id) {
        return duenoRefugioRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DuenoRefugio createDuenoRefugio(@RequestBody DuenoRefugio duenoRefugio) {
        return duenoRefugioRepository.save(duenoRefugio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DuenoRefugio> updateDuenoRefugio(@PathVariable Long id, @RequestBody DuenoRefugio updatedDuenoRefugio) {
        return duenoRefugioRepository.findById(id)
            .map(duenoRefugio -> {
                duenoRefugio.setNombre(updatedDuenoRefugio.getNombre());
                duenoRefugioRepository.save(duenoRefugio);
                return ResponseEntity.ok(duenoRefugio);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDuenoRefugio(@PathVariable Long id) {
        if (!duenoRefugioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        duenoRefugioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}