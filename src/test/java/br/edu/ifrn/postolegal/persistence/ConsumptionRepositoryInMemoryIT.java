package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Date;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class ConsumptionRepositoryInMemoryIT extends ITAbstract<Consumption>
{
	@Inject
	private ConsumptionRepository _repository;

	@Override
	protected Repository<Consumption> getRepository()
	{
		return this._repository;
	}

	@Override
	protected Consumption createObject()
	{
		return Consumption.builder()
			.vehicle(Vehicle.builder()
				.user(User.builder()
					.email("user@email.com")
					.name("João da Silva")
					.password("Password")
					.build()
				)
				.licensePlate("ABC1234")
				.build())
			.history(StationProductHistory.builder()
				.product(Product.builder().title("Gasolina").build())
				.station(Station.builder().name("Posto 01").build())
				.price(2.7f)
				.date(new Date())
				.build())
			.totalPaid(23f)
			.date(new Date())
			.odometer(23f)
			.build();
	}
}
