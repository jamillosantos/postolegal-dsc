/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.domain;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

/**
 * @author jbull
 */
@Test
public class StationTest
{
	private static final long ID_1 = 1;
	private static final String NAME_1 = "Posto IFRN";
	private static final Float LATITUDE_1 = 1f;
	private static final Float LONGITUDE_1 = 2f;

	private static final long ID_2 = 2;
	private static final String NAME_2 = "Posto Corporativo";
	private static final Float LATITUDE_2 = 3f;
	private static final Float LONGITUDE_2 = 4f;

	public void testEquals()
	{
		assertThat(
			Station.builder()
				.id(ID_1)
				.name(NAME_1)
				.latitude(LATITUDE_1)
				.longitude(LONGITUDE_1)
				.build()
		)
			.isEqualTo(
				Station.builder()
					.id(ID_1)
					.name(NAME_2)
					.latitude(LATITUDE_2)
					.longitude(LONGITUDE_2)
					.build()
			);
	}

	public void testNotEquals()
	{
		assertThat(
			Station.builder()
				.id(ID_1)
				.name(NAME_1)
				.latitude(LATITUDE_1)
				.longitude(LONGITUDE_1)
				.build()
		)
			.isNotEqualTo(
				Station.builder()
					.id(ID_2)
					.name(NAME_1)
					.latitude(LATITUDE_1)
					.longitude(LONGITUDE_1)
					.build()
			);
	}

	public void compareTo()
	{
		Station s1 = Station.builder()
			.id(ID_1)
			.name(NAME_1)
			.latitude(LATITUDE_1)
			.longitude(LONGITUDE_1)
			.build();
		Station s2 = Station.builder()
			.id(ID_2)
			.name(NAME_2)
			.latitude(LATITUDE_2)
			.longitude(LONGITUDE_2)
			.build();

		Set<Station> stations = new TreeSet<>();
		stations.add(s1);
		stations.add(s2);
		assertThat(stations.iterator().next()).isEqualTo(s2);
	}
}
