package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.domain.StationProductId;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "stationProduct", dependsOnGroups = {"product", "station"})
public class StationProductRepositoryIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private StationProductRepository _repository;

	@Inject
	private ProductFactory productFactory;

	@Inject
	private StationFactory stationFactory;

	@Inject
	private StationProductFactory stationProductFactory;

	protected StationProduct createObject()
	{
		return StationProduct.builder()
			.product(this.productFactory.product())
			.station(this.stationFactory.station())
			.price(2.7f)
			.build();
	}

	@BeforeMethod
	void deleteAll()
	{
		this._repository.deleteAll();
	}

	public void injection()
	{
		assertThat(this._repository).isNotNull();
	}

	public void saveOne()
	{
		long count = this._repository.count();
		StationProduct object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
	}

	public void deleteOne()
	{
		long count = this._repository.count();
		StationProduct object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
		this._repository.delete(object);
		assertThat(this._repository.count()).isEqualTo(count);
	}

	public void findAllByProduct()
	{
		Product
			productGasolina = this.productFactory.product("Gasolina"),
			productGas = this.productFactory.product("Gás");
		Station
			s1 = this.stationFactory.station("Posto testFindAllByProduct 01"),
			s2 = this.stationFactory.station("Posto testFindAllByProduct 02");
		this.stationProductFactory.stationProduct(s1, productGas);
		this.stationProductFactory.stationProduct(s1, productGasolina);
		this.stationProductFactory.stationProduct(s2, productGas);
		this.stationProductFactory.stationProduct(s2, productGasolina);
		Iterator<StationProduct> it = this._repository.findAllByProduct(productGas).iterator();
		int i = 0;
		while (it.hasNext())
		{
			it.next();
			i++;
		}
		assertThat(i).isEqualTo(2);
	}

	public void findAllByStation()
	{
		Product
			productGasolina = this.productFactory.product("Gasolina"),
			productGas = this.productFactory.product("Gás");
		Station
			s1 = this.stationFactory.station("Posto testFindAllByProduct 01"),
			s2 = this.stationFactory.station("Posto testFindAllByProduct 02");
		this.stationProductFactory.stationProduct(s1, productGas);
		this.stationProductFactory.stationProduct(s1, productGasolina);
		this.stationProductFactory.stationProduct(s2, productGasolina);
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
