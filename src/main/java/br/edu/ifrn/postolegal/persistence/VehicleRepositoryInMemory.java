/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Vehicle;

import javax.inject.Named;
/**
 *
 * @author jbull
 */
@Named
public class VehicleRepositoryInMemory extends RepositoryInMemory<Vehicle> implements VehicleRepository
{ }
