package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long>
{ }
