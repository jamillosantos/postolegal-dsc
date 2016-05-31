package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.StationProduct;

import javax.inject.Named;

@Named
public class StationProductRepositoryInMemory
	extends RepositoryInMemory<StationProduct>
	implements StationProductRepository
{ }
