package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class })
public class StationProductRepositoryInMemoryITest extends ITTest<StationProduct>
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
			.product(Product.builder().title("Gasolina").build())
			.station(Station.builder().name("Posto 01").build())
			.price(2.7f)
			.build();
	}
}
