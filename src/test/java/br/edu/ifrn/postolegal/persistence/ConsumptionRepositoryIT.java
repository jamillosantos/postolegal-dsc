package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.time.Instant;
import java.util.Date;


@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class ConsumptionRepositoryIT extends IntegrationTest<Consumption, Long>
{
	@Inject
	DomainFactory factory;

	@Inject
	private ConsumptionRepository _repository;

	@Override
	protected CrudRepository<Consumption, Long> getRepository()
	{
		return this._repository;
	}

	@Override
	protected Consumption createObject()
	{
		return Consumption.builder()
			.vehicle(factory.vehicle())
			.history(factory.stationProductHistory())
			.totalPaid(23f)
			.date(new Date())
			.odometer(23f)
			.build();
	}

/*

	@Test
	public void testTotalPaid()
	{
		Vehicle v = factory.vehicle("ZZZ1234");
		this._repository.save(Consumption.builder()
			.vehicle(v)
			.history(factory.stationProductHistory())
			.totalPaid(1f)
			.date(Date.from(Instant.now()))
			.odometer(2f)
			.build());
		assertThat(this._repository.sumTotalPaid(v)).isEqualTo(1f);
		this._repository.save(Consumption.builder()
			.vehicle(v)
			.history(factory.stationProductHistory())
			.totalPaid(1.5f)
			.date(Date.from(Instant.now()))
			.odometer(4f)
			.build());
		assertThat(this._repository.sumTotalPaid(v)).isEqualTo(2.5f);
	}
*/
}
