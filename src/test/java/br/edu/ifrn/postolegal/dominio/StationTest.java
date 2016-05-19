/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.dominio;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author jbull
 */
@Test
public class StationTest {
    private static final String NOME = "postoLegal";
    private static final String ENDERECO = "rua";
    private static final String CNPJ = "01634555333";
    
    public void nomeIgual() {
        assertThat(Station.builder().name(NOME).build())
            .isEqualTo(Station.builder().name(NOME).build());
    }
    
    public void compareTo() {
        Set<Station> stations = new TreeSet<>();
        
        Station endereco = Station.builder().name(ENDERECO).build();
        stations.add(endereco);
        Station cnpj = Station.builder().name(CNPJ).build();
        stations.add(cnpj);
        
        assertThat(stations.iterator().next()).isEqualTo(cnpj);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
