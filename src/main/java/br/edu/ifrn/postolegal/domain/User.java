package br.edu.ifrn.postolegal.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Getter
@Setter
@ToString(exclude = {"vehicles"})
@EqualsAndHashCode(of = {"email"})
@Builder
@Entity(name = "Users")
@SequenceGenerator(sequenceName = "seq_user", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements Serializable, Comparable<User>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String salt;

	@Singular
	@OneToMany(mappedBy = "user")
	private Collection<Vehicle> vehicles;

	@Override
	public int compareTo(User user)
	{
		return this.name.compareTo(user.name);
	}
}
