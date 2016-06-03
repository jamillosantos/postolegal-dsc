package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Station;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class })

/**
 *
 * @author renato
 */
public class StationRepositoryInMemoryITest extends ITTest<Station>{
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
			.name("Posto 01")
                        .latitude(1.5f)
                        .longitude(1.3f)
			.build();
	}
}
