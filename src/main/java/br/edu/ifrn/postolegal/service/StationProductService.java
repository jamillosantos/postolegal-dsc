package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.*;
import br.edu.ifrn.postolegal.persistence.StationProductRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StationProductService extends Service<StationProduct, StationProductId>
{
	@Inject
	public StationProductService(StationProductRepository repository)
	{
		super(repository);
	}

	@Override
	public void validate(StationProduct object) throws ValidationException
	{
		if (object.getProduct() == null)
			throw new RequiredException("produto");

		if (object.getPrice() <= 0)
			throw new BiggerThanZeroException("preço");

		if (object.getStation() == null)
			throw new RequiredException("posto");
	}


	public Iterable<StationProduct> findAllByProduct(Product product)
	{
		return ((StationProductRepository)this.getRepository()).findAllByProduct(product);
	}

	public Iterable<StationProduct> findAllByStation(Station station)
	{
		return ((StationProductRepository)this.getRepository()).findAllByStation(station);
	}
}
