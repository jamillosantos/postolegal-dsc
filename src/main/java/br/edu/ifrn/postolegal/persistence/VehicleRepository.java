package br.edu.ifrn.postolegal.persistence;
import br.edu.ifrn.postolegal.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long>
{
}
