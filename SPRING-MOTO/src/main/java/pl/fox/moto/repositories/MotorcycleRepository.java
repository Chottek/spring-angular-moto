package pl.fox.moto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fox.moto.models.Motorcycle;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

}
