package br.edu.ifrn.postolegal.dominio;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_consumption", name = "ID_SEQUENCE", allocationSize = 1)
public class Consumption
{
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_consumption__vehicle"))
	private Vehicle vehicle;

	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_consumption__history"))
	private StationProductHistory history;

	@Column(nullable = false)
	private float totalPaid;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(nullable = false)
	private int odometer;

	private boolean valid;
}
