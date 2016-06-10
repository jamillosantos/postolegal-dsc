package br.edu.ifrn.postolegal.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class StationProductId implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long stationId;

	private Long productId;
}
