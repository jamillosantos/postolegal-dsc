package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.StationProductHistory;

import javax.inject.Named;

@Named
public class StationProductHistoryRepositoryInMemory
	extends RepositoryInMemory<StationProductHistory>
	implements StationProductHistoryRepository
{ }
