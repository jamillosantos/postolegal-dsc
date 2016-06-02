package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.*;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.Date;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class })
public class ConsumptionRepositoryInMemoryITest extends ITTest<Consumption>
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
			.vehicle(Vehicle.builder().licensePlate("ABC1234").build())
			.history(StationProductHistory.builder()
				.product(Product.builder().title("Gasolina").build())
				.station(Station.builder().name("Posto 01").build())
				.price(2.7f)
				.date(new Date())
				.build())
			.build();
	}
}
