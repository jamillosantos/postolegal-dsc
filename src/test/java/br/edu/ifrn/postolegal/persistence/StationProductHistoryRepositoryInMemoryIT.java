package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Date;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class StationProductHistoryRepositoryInMemoryIT extends ITAbstract<StationProductHistory>
{
	@Inject
	private StationProductHistoryRepository _repository;

	@Override
	protected Repository<StationProductHistory> getRepository()
	{
		return this._repository;
	}

	@Override
	protected StationProductHistory createObject()
	{
		return StationProductHistory.builder()
			.product(Product.builder()
				.id(1l)
				.title("Gasolina")
				.build())
			.station(Station.builder()
				.id(1l)
				.name("Posto 01")
				.build())
			.price(2.7f)
			.date(new Date())
			.build();
	}
}
