package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Station;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class StationRepositoryInMemoryIT extends ITAbstract<Station>
{
	@Inject
	private StationRepository _repository;

	@Override
	protected Repository<Station> getRepository()
	{
		return this._repository;
	}

	@Override
	protected Station createObject()
	{
		return Station.builder()
			.id(1l)
			.name("Posto 01")
			.latitude(1.5f)
			.longitude(1.3f)
			.build();
	}
}
