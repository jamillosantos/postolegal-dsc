package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.persistence.ProductRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ProductService extends Service<Product, Long>
{
	@Inject
	public ProductService(ProductRepository repository)
	{
		super(repository);
	}

	@Override
	protected void validate(Product object) throws ValidationException
	{
		if ((object.getTitle() == null) || object.getTitle().equals(""))
			throw new RequiredException("título");
	}
}
