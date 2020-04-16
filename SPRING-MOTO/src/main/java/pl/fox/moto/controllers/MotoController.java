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

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @GetMapping
    public List<Motorcycle> list(){
       return motorcycleRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Motorcycle motorcycle){
        motorcycleRepository.save(motorcycle);
    }

    @GetMapping("/{id}")
    public Motorcycle get(@PathVariable("id") long id){
        return motorcycleRepository.getOne(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMotorcycle(@PathVariable("id") Long id){
        Optional<Motorcycle> motorycle = motorcycleRepository.findById(id);
        if(motorycle.isPresent()){
            motorcycleRepository.delete(motorycle.get());
            return ResponseEntity.accepted().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
