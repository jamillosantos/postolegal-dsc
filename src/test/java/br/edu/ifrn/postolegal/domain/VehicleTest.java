package br.edu.ifrn.postolegal.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@Test
public class VehicleTest
{
	private static final String USER_NAME_1 = "Alberto Roberto";
	private static final String USER_EMAIL_1 = "roberto@test.com";
	private static final String USER_NAME_2 = "Roberto Alberto";
	private static final String USER_EMAIL_2 = "alberto@test.com";

	private static final Integer YEAR_1 = 2013;
	private static final String ENGINE_1 = "1.0";
	private static final String MODEL_1 = "Gol";
	private static final String LICENSE_PLATE_1 = "AAA0001";

	private static final Integer YEAR_2 = 2016;
	private static final String ENGINE_2 = "2.0";
	private static final String MODEL_2 = "Amarok";
	private static final String LICENSE_PLATE_2 = "BBB0002";

	private static final Integer YEAR_3 = 2016;
	private static final String ENGINE_3 = "2.0";
	private static final String MODEL_3 = "Amarok";
	private static final String LICENSE_PLATE_3 = "CCC0003";

	public void testEquals()
	{
		assertThat(Vehicle.builder()
			.user(User.builder().name(USER_NAME_1).email(USER_EMAIL_1).build())
			.year(YEAR_1)
			.engine(ENGINE_1)
			.model(MODEL_1)
			.licensePlate(LICENSE_PLATE_1)
			.build()
		)
			.isEqualTo(
				Vehicle.builder()
					.user(User.builder().name(USER_NAME_2).email(USER_EMAIL_2).build())
					.year(YEAR_2)
					.engine(ENGINE_2)
					.model(MODEL_2)
					.licensePlate(LICENSE_PLATE_1)
					.build()
			);
	}

	public void testNotEquals()
	{
		assertThat(Vehicle.builder()
			.user(User.builder()
				.name(USER_NAME_1)
				.email(USER_EMAIL_1)
				.build()
			)
			.year(YEAR_1)
			.engine(ENGINE_1)
			.model(MODEL_1)
			.licensePlate(LICENSE_PLATE_1)
			.build()
		)
			.isNotEqualTo(
				Vehicle.builder()
					.user(User.builder()
						.name(USER_NAME_1)
						.email(USER_EMAIL_1)
						.build()
					)
					.year(YEAR_1)
					.engine(ENGINE_1)
					.model(MODEL_1)
					.licensePlate(LICENSE_PLATE_2)
					.build()
			);
	}

	public void testCompareTo()
	{
		Vehicle v1 = Vehicle.builder()
			.user(User.builder()
				.name(USER_NAME_1)
				.email(USER_EMAIL_1)
				.build()
			)
			.year(YEAR_1)
			.engine(ENGINE_1)
			.model(MODEL_1)
			.licensePlate(LICENSE_PLATE_1)
			.build();
		Vehicle v2 = Vehicle.builder()
			.user(User.builder()
				.name(USER_NAME_2)
				.email(USER_EMAIL_2)
				.build()
			)
			.year(YEAR_2)
			.engine(ENGINE_2)
			.model(MODEL_2)
			.licensePlate(LICENSE_PLATE_2)
			.build();
		Vehicle v3 = Vehicle.builder()
			.user(User.builder()
				.name(USER_NAME_1)
				.email(USER_EMAIL_1)
				.build()
			)
			.year(YEAR_3)
			.engine(ENGINE_3)
			.model(MODEL_3)
			.licensePlate(LICENSE_PLATE_3)
			.build();

		Set<Vehicle> vehicles = new TreeSet<Vehicle>();
		vehicles.add(v3);
		vehicles.add(v2);
		vehicles.add(v1);
		Iterator<Vehicle> it = vehicles.iterator();
		assertThat(it.next()).isEqualTo(v2);
		assertThat(it.next()).isEqualTo(v3);
		assertThat(it.next()).isEqualTo(v1);
	}
}
