package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.persistence.StationRepository;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author renato
 */
public class StationService extends Service<Station>{
    @Inject
    public StationService(StationRepository repository){
        super(repository);
    }
    
    @Override
    protected void validate(Station object) throws Exception{
        if (object.getName().equals("")) {
            throw new Exception("Preencha o nome do posto");
        }
    }
}
