package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import br.edu.ifrn.postolegal.persistence.StationProductHistoryRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StationProductHistoryService extends Service<StationProductHistory, Long>
{
	@Inject
	public StationProductHistoryService(StationProductHistoryRepository repository)
	{
		super(repository);
	}

	@Override
	protected void validate(StationProductHistory object) throws ValidationException
	{
		if (object.getProduct() == null)
			throw new RequiredException("produto");

		if (object.getPrice() <= 0)
			throw new BiggerThanZeroException("preço");

		if (object.getStation() == null)
			throw new RequiredException("posto");

		if (object.getDate() == null)
			throw new RequiredException("data");
	}

	public Iterable<StationProductHistory> findAllByProduct(Product product)
	{
		return ((StationProductHistoryRepository)this.getRepository()).findAllByProduct(product);
	}

	public Iterable<StationProductHistory> findAllByStation(Station station)
	{
		return ((StationProductHistoryRepository)this.getRepository()).findAllByStation(station);
	}
}
