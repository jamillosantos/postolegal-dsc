package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;

import javax.inject.Named;

@Named
public class ProductRepositoryInMemory
	extends RepositoryInMemory<Product>
	implements ProductRepository
{ }
