package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Date;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class StationProductHistoryRepositoryIT extends IntegrationTest<StationProductHistory, Long>
{
	@Inject
	private StationProductHistoryRepository _repository;

	@Inject
	private DomainFactory factory;

	@Override
	protected CrudRepository<StationProductHistory, Long> getRepository()
	{
		return this._repository;
	}

	@Override
	protected StationProductHistory createObject()
	{
		return StationProductHistory.builder()
			.product(this.factory.product())
			.station(this.factory.station())
			.price(2.7f)
			.date(new Date())
			.build();
	}

	@Test
	public void testFindAllByProduct()
	{
		Product
			p = this.factory.product(),
			p2 = this.factory.product();
		this.factory.stationProductHistory(p);
		this.factory.stationProductHistory(p);
		this.factory.stationProductHistory(p2);
		Iterator<StationProductHistory> it = this._repository.findAllByProduct(p2).iterator();
		int i = 0;
		while (it.hasNext())
		{
			it.next();
			i++;
		}
		assertThat(i).isEqualTo(1);
	}

	@Test
	public void testFindAllByStation()
	{
		Station
			s = this.factory.station("Station 01"),
			s2 = this.factory.station("Station 02");
		this.factory.stationProductHistory(s);
		this.factory.stationProductHistory(s);
		this.factory.stationProductHistory(s2);
		Iterator<StationProductHistory> it = this._repository.findAllByStation(s).iterator();
		int i = 0;
		while (it.hasNext())
		{
			it.next();
			i++;
		}
		assertThat(i).isEqualTo(2);
	}
}
