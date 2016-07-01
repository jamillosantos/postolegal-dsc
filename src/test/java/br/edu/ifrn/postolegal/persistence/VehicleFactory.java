package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Vehicle;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class VehicleFactory
{
	@Inject
	private VehicleRepository vehicleRepository;

	@Inject
	private UserFactory userFactory;

	public Vehicle vehicle()
	{
		return this.vehicle("ABC1234");
	}

	public Vehicle vehicle(String plate)
	{
		Vehicle result = this.vehicleRepository.findByLicensePlate(plate);
		if (result == null)
		{
			result = Vehicle.builder()
				.user(this.userFactory.user())
				.licensePlate(plate)
				.model("Uno")
				.engine("1.0")
				.year(2012)
				.build();
			this.vehicleRepository.save(result);
		}
		return result;
	}
}
