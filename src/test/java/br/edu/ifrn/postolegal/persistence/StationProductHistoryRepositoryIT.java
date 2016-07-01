package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Date;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "stationProductHistory", dependsOnGroups = {"product", "station"})
public class StationProductHistoryRepositoryIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private StationProductHistoryRepository _repository;

	@Inject
	private ProductFactory productFactory;

	@Inject
	private StationFactory stationFactory;

	@Inject
	private StationProductHistoryFactory stationProductHistoryFactory;

	@BeforeMethod
	void deleteAll()
	{
		this._repository.deleteAll();
	}

	protected StationProductHistory createObject()
	{
		return StationProductHistory.builder()
			.product(this.productFactory.product())
			.station(this.stationFactory.station())
			.price(2.7f)
			.date(new Date())
			.build();
	}


	public void injection()
	{
		assertThat(this._repository).isNotNull();
	}

	public void deleteOne()
	{
		long count = this._repository.count();
		StationProductHistory object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
		this._repository.delete(object);
		assertThat(this._repository.count()).isEqualTo(count);
	}

	public void findAllByProduct()
	{
		Product
			p = this.productFactory.product(),
			p2 = this.productFactory.product();
		this.stationProductHistoryFactory.stationProductHistory(p);
		this.stationProductHistoryFactory.stationProductHistory(p);
		this.stationProductHistoryFactory.stationProductHistory(p2);
		Iterator<StationProductHistory> it = this._repository.findAllByProduct(p2).iterator();
		int i = 0;
		while (it.hasNext())
		{
			it.next();
			i++;
		}
		assertThat(i).isEqualTo(1);
	}

	public void findAllByStation()
	{
		Station
			s = this.stationFactory.station("Station 01"),
			s2 = this.stationFactory.station("Station 02");
		this.stationProductHistoryFactory.stationProductHistory(s);
		this.stationProductHistoryFactory.stationProductHistory(s);
		this.stationProductHistoryFactory.stationProductHistory(s2);
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
