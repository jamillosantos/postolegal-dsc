package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Consumption;
import br.edu.ifrn.postolegal.domain.Vehicle;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class VehicleRepositoryIT extends IntegrationTest<Vehicle, Long>
{
	@Inject
	DomainFactory factory;

	@Inject
	private VehicleRepository _repository;

	@Inject
	private ConsumptionRepository consumptionRepository;

	@Override
	protected CrudRepository<Vehicle, Long> getRepository()
	{
		return this._repository;
	}

	@Override
	protected Vehicle createObject()
	{
		return Vehicle.builder()
			.user(this.factory.user())
			.licensePlate("ABC1234")
			.model("Uno")
			.engine("1.0")
			.year(2012)
			.build();
	}
}
