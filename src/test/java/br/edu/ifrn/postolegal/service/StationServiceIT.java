package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Station;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class StationServiceIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private StationService _service;

	private final String NAME_VALID = "Nome 01";
	private final float LATITUDE_VALID = 1.3f;
	private final float LONGITUDE_VALID = 1.1f;

	@Test
	public void testSave_Success() throws Exception
	{
		this._service.save(Station.builder()
			.id(1l)
			.name(NAME_VALID)
			.latitude(LATITUDE_VALID)
			.longitude(LONGITUDE_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_NameNull() throws Exception
	{
		this._service.save(Station.builder()
			.latitude(LATITUDE_VALID)
			.longitude(LONGITUDE_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_NameEmpty() throws Exception
	{
		this._service.save(Station.builder()
			.name("")
			.latitude(LATITUDE_VALID)
			.longitude(LONGITUDE_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_LatitudeNull() throws Exception
	{
		this._service.save(Station.builder()
			.name(NAME_VALID)
			.longitude(LONGITUDE_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_LongitudeNull() throws Exception
	{
		this._service.save(Station.builder()
			.name(NAME_VALID)
			.latitude(LATITUDE_VALID)
			.build());
	}

	@Test
	public void deleteOne() throws Exception
	{
		Station object = Station.builder()
			.id(1L)
			.name(NAME_VALID)
			.latitude(LATITUDE_VALID)
			.longitude(LONGITUDE_VALID)
			.build();
		this._service.save(object);
		this._service.delete(object);
		assertThat(this._service.iterator().hasNext()).isFalse();
	}
}
