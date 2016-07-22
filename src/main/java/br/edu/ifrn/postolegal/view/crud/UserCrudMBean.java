/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.view.crud;


import br.edu.ifrn.postolegal.domain.User;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named

/**
 *
 * @author jbull
 */
public class UserCrudMBean extends CrudMBean<User, Long>
{
    @Override
	protected User createBean()
	{
		return User.builder().salt("123").build();
	}
    
}
