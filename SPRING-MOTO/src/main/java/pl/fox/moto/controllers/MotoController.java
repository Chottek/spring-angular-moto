package pl.fox.moto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.fox.moto.models.Motorcycle;
import pl.fox.moto.repositories.MotorcycleRepository;

import java.util.ArrayList;
import java.util.List;

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


}
