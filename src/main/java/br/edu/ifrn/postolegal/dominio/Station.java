package br.edu.ifrn.postolegal.dominio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

import java.util.Set;

/**
 * @author J. Santos <jamillo@gmail.com>
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Station
{
	private Set<StationProduct> products;

	private String name;

	private float latitude;

	private float longitude;
}
