package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Station;

import javax.inject.Named;
/**
 *
 * @author renato
 */
@Named
public class StationRepositoryInMemory extends RepositoryInMemory<Station> implements StationRepository {
    
}
