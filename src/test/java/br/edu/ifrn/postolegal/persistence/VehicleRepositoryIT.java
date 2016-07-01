package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Vehicle;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "vehicle", dependsOnGroups = "user")
public class VehicleRepositoryIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private VehicleRepository _repository;

	@Inject
	private UserFactory userFactory;

	protected Vehicle createObject()
	{
		return Vehicle.builder()
			.user(this.userFactory.user())
			.licensePlate("ABC1234")
			.model("Uno")
			.engine("1.0")
			.year(2012)
			.build();
	}

	@BeforeMethod
	void deleteAll()
	{
		this._repository.deleteAll();
	}

	public void injection()
	{
		assertThat(this._repository).isNotNull();
	}

	public void saveOne()
	{
		long count = this._repository.count();
		Vehicle object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
	}

	public void deleteOne()
	{
		long count = this._repository.count();
		Vehicle object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
		this._repository.delete(object);
		assertThat(this._repository.count()).isEqualTo(count);
	}
}
