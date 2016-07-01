package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StationProductFactory
{
	@Inject
	private StationProductRepository stationProductRepository;

	public void stationProduct(Station station, Product product)
	{
		this.stationProductRepository.save(StationProduct.builder()
			.station(station)
			.product(product)
			.price(1.2f)
			.build());
	}
}
