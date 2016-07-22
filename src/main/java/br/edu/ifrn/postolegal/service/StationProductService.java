package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.*;
import br.edu.ifrn.postolegal.persistence.StationProductRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Date;

@Named
public class StationProductService extends Service<StationProduct, Long>
{
	@Inject
	private StationProductHistoryService _historyService;

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

	@Transactional
	@Override
	public void save(StationProduct object) throws Exception
	{
		this.validate(object);
		StationProductHistory history = StationProductHistory.builder()
			.product(object.getProduct())
			.date(new Date())
			.price(object.getPrice())
			.station(object.getStation())
			.build();
		this.getRepository().save(object);
		this._historyService.save(history);
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
