package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Station;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StationFactory
{
	@Inject
	private StationRepository stationRepository;

	public Station station(String name)
	{
		Station result = this.stationRepository.findByName(name);
		if (result == null)
		{
			result = Station.builder().name(name).build();
			this.stationRepository.save(result);
		}
		return result;
	}

	public Station station()
	{
		return this.station("Posto 01");
	}
}
