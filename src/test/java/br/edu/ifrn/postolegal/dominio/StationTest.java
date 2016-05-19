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
    
    public void nomeIgual() {
        assertThat(Station.builder().name(NOME).build())
            .isEqualTo(Station.builder().name(NOME).build());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
