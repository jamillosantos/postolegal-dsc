package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ProductFactory
{
	@Inject
	private ProductRepository productRepository;

	public Product product()
	{
		return this.product("Gasolina");
	}

	public Product product(String title)
	{
		Product p = Product.builder().title(title).build();
		this.productRepository.save(p);
		return p;
	}
}
