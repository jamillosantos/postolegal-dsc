/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.dominio;

import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import java.util.Set;

/**
 *
 * @author jbull
 */
public class StationProductHistoryTest {
    private static final long ID = 12;
    private static final long CODIGO = 1254343;
    private static final long SENHA = 12345;
    
    public void idIgual() {
        assertThat(StationProductHistory.builder().id(ID).build())
            .isEqualTo(StationProductHistory.builder().id(ID).build());
    }
   
    public void compareTo() {
        Set<StationProductHistory> stationProductHistories = new TreeSet<>();
        
        StationProductHistory codigo = StationProductHistory.builder().id(CODIGO).build();
        stationProductHistories.add(codigo);
        StationProductHistory senha = StationProductHistory.builder().id(SENHA).build();
        stationProductHistories.add(senha);
        
        assertThat(stationProductHistories.iterator().next()).isEqualTo(senha);
    }
   
}
