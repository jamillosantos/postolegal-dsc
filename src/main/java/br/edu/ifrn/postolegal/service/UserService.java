package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.User;
import br.edu.ifrn.postolegal.persistence.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renato
 */
@Named
public class UserService extends Service<User>{
    @Inject
    public UserService(UserRepository repository){
        super(repository);
    }
    @Override
    protected void validate(User object) throws Exception{
        if (object.getName().equals("")) {
            throws new Exception("Preencha o nome do usuário");
        }
        if (object.getEmail().equals("")) {
            throws new Exception("Preencha o email do usuário");
        }
        if (object.getSenha().equals("")) {
            throws new Exception("Preencha a senha do usuário");
        }
        
    }
    
}
