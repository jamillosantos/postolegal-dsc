package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Consumption;
import br.edu.ifrn.postolegal.persistence.ConsumptionRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ConsumptionService extends Service<Consumption>
{
	@Inject
	public ConsumptionService(ConsumptionRepository repository)
	{
		super(repository);
	}

	@Override
	protected void validate(Consumption object) throws ValidationException
	{
		if (object.getVehicle() == null)
			throw new RequiredException("veículo");

		if (object.getHistory() == null)
			throw new RequiredException("histórico");

		if (object.getTotalPaid() <= 0)
			throw new BiggerThanZeroException("total pago");

		if (object.getDate() == null)
			throw new RequiredException("data");

		if (object.getOdometer() < 0)
			throw new NonNegativeException("odômetro");
	}
}
