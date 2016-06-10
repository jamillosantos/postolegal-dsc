package br.edu.ifrn.postolegal.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationProductId implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long stationId;

	private Long productId;
}
