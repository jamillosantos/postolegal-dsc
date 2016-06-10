package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Vehicle;
import br.edu.ifrn.postolegal.persistence.VehicleRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class VehicleService extends Service<Vehicle, Long>
{
	@Inject
	public VehicleService(VehicleRepository repository)
	{
		super(repository);
	}

	@Override
	public void validate(Vehicle object) throws ValidationException
	{
		if ((object.getEngine() == null) || object.getEngine().equals(""))
			throw new RequiredException("motor");

		if ((object.getModel() == null) || object.getModel().equals(""))
			throw new RequiredException("modelo");

		if ((object.getLicensePlate() == null) || object.getLicensePlate().equals(""))
			throw new RequiredException("placa");

		if (object.getYear() == null)
			throw new RequiredException("ano");
	}
}