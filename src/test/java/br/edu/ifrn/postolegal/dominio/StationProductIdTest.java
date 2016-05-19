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
public class StationProductIdTest {
    private static final long ID = 12;
    
    public void idIgual() {
        assertThat(StationProductId.builder().productId(ID).build())
                .isEqualTo(StationProductId.builder().productId(ID).build());
    }
}
