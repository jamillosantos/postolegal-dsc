package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.domain.StationProductId;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class StationProductRepositoryIT extends IntegrationTest<StationProduct, StationProductId>
{
	@Inject
	private StationProductRepository _repository;

	@Inject
	private DomainFactory factory;

	@Override
	protected CrudRepository<StationProduct, StationProductId> getRepository()
	{
		return this._repository;
	}

	@Override
	protected StationProduct createObject()
	{
		return StationProduct.builder()
			.product(this.factory.product())
			.station(this.factory.station())
			.price(2.7f)
			.build();
	}

	public void testFindAllByProduct()
	{
		Product
			productGasolina = this.factory.product("Gasolina"),
			productGas = this.factory.product("Gás");
		Station
			s1 = this.factory.station("Posto testFindAllByProduct 01"),
			s2 = this.factory.station("Posto testFindAllByProduct 02");
		this.factory.stationProduct(s1, productGas);
		this.factory.stationProduct(s1, productGasolina);
		this.factory.stationProduct(s2, productGas);
		this.factory.stationProduct(s2, productGasolina);
		Iterator<StationProduct> it = this._repository.findAllByProduct(productGas).iterator();
		int i = 0;
		while (it.hasNext())
		{
			it.next();
			i++;
		}
		assertThat(i).isEqualTo(2);
	}

	public void testFindAllByStation()
	{
		Product
			productGasolina = this.factory.product("Gasolina"),
			productGas = this.factory.product("Gás");
		Station
			s1 = this.factory.station("Posto testFindAllByProduct 01"),
			s2 = this.factory.station("Posto testFindAllByProduct 02");
		this.factory.stationProduct(s1, productGas);
		this.factory.stationProduct(s1, productGasolina);
		this.factory.stationProduct(s2, productGasolina);
		Iterator<StationProduct> it = this._repository.findAllByStation(s2).iterator();
		int i = 0;
		while (it.hasNext())
		{
			it.next();
			i++;
		}
		assertThat(i).isEqualTo(1);
	}
}
