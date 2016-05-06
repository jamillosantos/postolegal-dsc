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
public class Consumption
{
	private Vehicle vehicle;

	private float totalPaid;
	private Date date;
	private int odometer;
	private boolean valid;
}
