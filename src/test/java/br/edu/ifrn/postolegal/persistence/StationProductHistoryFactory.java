package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
public class StationProductHistoryFactory
{
	@Inject
	private StationFactory stationFactory;

	@Inject
	private ProductFactory productFactory;

	@Inject
	private StationProductHistoryRepository stationProductHistoryRepository;

	public StationProductHistory stationProductHistory()
	{
		StationProductHistory h = StationProductHistory.builder()
			.product(this.productFactory.product())
			.station(this.stationFactory.station())
			.price(2.7f)
			.date(new Date())
			.build();
		this.stationProductHistoryRepository.save(h);
		return h;
	}

	public StationProductHistory stationProductHistory(Product product)
	{
		StationProductHistory h = StationProductHistory.builder()
			.product(product)
			.station(this.stationFactory.station())
			.price(2.7f).date(new Date())
			.build();
		this.stationProductHistoryRepository.save(h);
		return h;
	}

	public StationProductHistory stationProductHistory(Station station)
	{
		StationProductHistory h = StationProductHistory.builder()
			.product(this.productFactory.product())
			.station(station)
			.price(2.7f)
			.date(new Date())
			.build();
		this.stationProductHistoryRepository.save(h);
		return h;
	}
}
