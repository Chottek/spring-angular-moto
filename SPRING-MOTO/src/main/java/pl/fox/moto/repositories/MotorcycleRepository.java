package pl.fox.moto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fox.moto.models.Motorcycle;

import java.util.List;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

    List<Motorcycle> findAllByManufacturer(String param);



}
