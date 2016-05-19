/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.dominio;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

/**
 * @author jbull
 */
public class StationProductTest
{
	private static final long ID = 12;
	private static final long CODIGO = 1254343;
	private static final long SENHA = 12345;

	public void idIgual()
	{
		assertThat(StationProduct.builder().productId(ID).build())
			.isEqualTo(StationProduct.builder().productId(ID).build());
	}

	public void compareTo()
	{
		Set<StationProduct> stationProducts = new TreeSet<>();

		StationProduct codigo = StationProduct.builder().productId(CODIGO).build();
		stationProducts.add(codigo);
		StationProduct senha = StationProduct.builder().productId(SENHA).build();
		stationProducts.add(senha);

		assertThat(stationProducts.iterator().next()).isEqualTo(senha);
	}

}
