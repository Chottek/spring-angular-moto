package pl.fox.moto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fox.moto.models.Motorcycle;
import pl.fox.moto.repositories.MotorcycleRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/motorcycles")
public class MotoController {

    private MotorcycleRepository motorcycleRepository;

    @Autowired
    public MotoController(MotorcycleRepository motorcycleRepository){
        this.motorcycleRepository = motorcycleRepository;
    }


    @GetMapping
    public List<Motorcycle> list() {
        return motorcycleRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Motorcycle motorcycle) {
        motorcycleRepository.save(motorcycle);
    }

    @GetMapping("/{id}")
    public Motorcycle get(@PathVariable("id") long id) {
        return motorcycleRepository.getOne(id);
    }


    @GetMapping("/search")
    public @ResponseBody List<Motorcycle> searchByParam(@RequestParam("by") String by){
        return motorcycleRepository.findAllByManufacturer(by);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorcycle(@PathVariable("id") Long id) {
        System.out.println("I guess i got an id: "+ id);
        Optional<Motorcycle> motorcycle = motorcycleRepository.findById(id);
        if (motorcycle.isPresent()) {
            System.out.println("I should delete: "+ id);
            motorcycleRepository.delete(motorcycle.get());
            return ResponseEntity.accepted().build();
        } else
            return ResponseEntity.notFound().build();

    }
}
