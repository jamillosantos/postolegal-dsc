package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Vehicle;
import br.edu.ifrn.postolegal.persistence.UserFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "vehicle")
public class VehicleServiceIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private VehicleService _service;

	private final String LICENSE_PLATE_VALID = "ABC1234";
	private final String ENGINE_VALID = "1.0";
	private final String MODEL_VALID = "Uno";
	private final int YEAR_VALID = 2012;

	@Inject
	private UserFactory userFactory;

	@Test
	public void testSave_Success() throws Exception
	{
		Vehicle object = Vehicle.builder()
			.user(this.userFactory.user())
			.licensePlate(LICENSE_PLATE_VALID)
			.model(MODEL_VALID)
			.engine(ENGINE_VALID)
			.year(YEAR_VALID)
			.build();
		this._service.save(object);
		assertThat(this._service.findAll().iterator().next()).isEqualTo(object);
	}

	@Test
	public void deleteOne() throws Exception
	{
		long count = this._service.count();
		Vehicle object = Vehicle.builder()
			.user(this.userFactory.user())
			.licensePlate(LICENSE_PLATE_VALID)
			.model(MODEL_VALID)
			.engine(ENGINE_VALID)
			.year(YEAR_VALID)
			.build();
		this._service.save(object);
		assertThat(this._service.count()).isEqualTo(count + 1);
		this._service.delete(object);
		assertThat(this._service.count()).isEqualTo(count);
	}
}
