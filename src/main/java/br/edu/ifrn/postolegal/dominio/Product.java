package br.edu.ifrn.postolegal.dominio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

/**
 * @author J. Santos <jamillo@gmail.com>
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Product
{
	private String title;
}
