package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.persistence.ProductRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ProductService extends Service<Product>
{
	@Inject
	public ProductService(ProductRepository repository)
	{
		super(repository);
	}

	@Override
	protected void validate(Product object) throws Exception
	{
		if (object.getName().equals(""))
		{
			throw new Exception("Preencha o nome do produto.");
		}
	}
}
