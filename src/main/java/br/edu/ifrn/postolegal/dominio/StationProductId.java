package br.edu.ifrn.postolegal.dominio;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class StationProductId implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long stationId;

	private Long productId;
}
