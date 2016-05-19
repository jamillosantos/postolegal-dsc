package br.edu.ifrn.postolegal.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author renato
 */
@Test
public class UserTest
{
	public static final String NAME_1 = "Alberto Roberto";
	public static final String NAME_2 = "Roberto Alberto";
	public static final String EMAIL_1 = "alberto@test.com";
	public static final String EMAIL_2 = "roberto@test.com";

	public void testEquals()
	{
		assertThat(User.builder().name(NAME_1).email(EMAIL_1).build())
			.isEqualTo(User.builder().name(NAME_2).email(EMAIL_1).build());
	}

	public void testNotEquals()
	{
		assertThat(User.builder().name(NAME_1).email(EMAIL_1).build())
			.isNotEqualTo(User.builder().name(NAME_2).email(EMAIL_2).build());
	}

	public void testCompareTo()
	{
		User user1 = User.builder().name(NAME_1).build();
		User user2 = User.builder().name(NAME_2).build();

		Set<User> s = new TreeSet<User>();
		s.add(user2);
		s.add(user1);
		assertThat(s.iterator().next())
			.isEqualTo(user1);
	}
}
