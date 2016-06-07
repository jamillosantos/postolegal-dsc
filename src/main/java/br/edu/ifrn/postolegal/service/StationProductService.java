package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.persistence.StationProductRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StationProductService extends Service<StationProduct>
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
}
