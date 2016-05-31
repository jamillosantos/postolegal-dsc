package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.User;

import javax.inject.Named;

@Named
public class UserRepositoryInMemory extends RepositoryInMemory<User> implements UserRepository {
    
}
