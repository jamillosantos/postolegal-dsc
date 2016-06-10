package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Consumption;
import br.edu.ifrn.postolegal.domain.Vehicle;
import br.edu.ifrn.postolegal.persistence.ConsumptionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ConsumptionService extends Service<Consumption, Long>
{
	@Inject
	public ConsumptionService(ConsumptionRepository repository)
	{
		super(repository);
	}

	public Iterable<Consumption> findAllByVehiclePlate(String vehiclePlate)
	{
		Consumption consumption = Consumption.builder()
			.vehicle(Vehicle.builder().licensePlate(vehiclePlate).build())
			.build();
		return ((QueryByExampleExecutor<Consumption>)this.getRepository()).findAll(Example.of(consumption));
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
