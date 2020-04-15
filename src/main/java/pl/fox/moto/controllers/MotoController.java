package pl.fox.moto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.fox.moto.models.Motorcycle;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/motorcycles")
public class MotoController {

    @GetMapping
    public List<Motorcycle> list(){
        return new ArrayList<>();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Motorcycle motorcycle){

    }

    @GetMapping("/{id}")
    public Motorcycle get(@PathVariable("id") long id){
        return new Motorcycle();
    }


}
