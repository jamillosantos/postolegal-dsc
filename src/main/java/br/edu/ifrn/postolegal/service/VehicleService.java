/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.service;
import br.edu.ifrn.postolegal.domain.Vehicle;
import br.edu.ifrn.postolegal.persistence.VehicleRepository;

import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author jbull
 */
@Named
public class VehicleService extends Service<Vehicle>{
    @Inject
    public VehicleService(VehicleRepository repository){
        super(repository);
    }
    @Override
    protected void validate(Vehicle object) throws Exception{
        if (object.getEngine().equals("")) {
            throw new Exception("Informe o motor do veículo");
        }
        if (object.getModel().equals("")) {
            throw new Exception("Informe o modelo do veículo");
        }
        if (object.getLicensePlate().equals("")) {
            throw new Exception("Informe a placa do veículo");
        }
        if (object.getYear() == null) {
            throw new Exception("Informe o ano do veículo");
        }
    }
}