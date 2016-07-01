package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Consumption;
import br.edu.ifrn.postolegal.domain.Vehicle;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.Instant;
import java.util.Date;

@Named
public class ConsumptionFactory
{
	@Inject
	private ConsumptionRepository consumptionRepository;

	@Inject
	private StationProductHistoryFactory stationProductHistoryFactory;

	public Consumption consumption(Vehicle vehicle)
	{
		Consumption consumption = Consumption.builder()
			.vehicle(vehicle)
			.history(this.stationProductHistoryFactory.stationProductHistory())
			.totalPaid(12f)
			.odometer(1.2f)
			.date(Date.from(Instant.now()))
			.build();
		this.consumptionRepository.save(consumption);
		return consumption;
	}
}
