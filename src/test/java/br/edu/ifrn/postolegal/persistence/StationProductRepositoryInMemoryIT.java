package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class StationProductRepositoryInMemoryIT extends ITAbstract<StationProduct>
{
	@Inject
	private StationProductRepository _repository;

	@Override
	protected Repository<StationProduct> getRepository()
	{
		return this._repository;
	}

	@Override
	protected StationProduct createObject()
	{
		return StationProduct.builder()
			.product(Product.builder()
				.id(1l)
				.title("Gasolina")
				.build())
			.station(Station.builder()
				.id(1l)
				.name("Posto 01")
				.build())
			.price(2.7f)
			.build();
	}
}
