/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.dominio;

import java.io.Serializable;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;
/**
 *
 * @author jbull
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Vehicle implements Serializable{
    public Set<Consumption> consumptions;

    private int year;
    private String engine;
    private String model;
    private User user;
}
