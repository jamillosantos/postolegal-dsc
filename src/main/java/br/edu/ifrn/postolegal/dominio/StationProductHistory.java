package br.edu.ifrn.postolegal.dominio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;

import java.sql.Date;

/**
 * @author J. Santos <jamillo@gmail.com>
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class StationProductHistory
{
	private Product product;

	private Station station;

	private float price;

	private Date date;
}
