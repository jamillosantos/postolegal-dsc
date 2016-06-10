package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{ }
