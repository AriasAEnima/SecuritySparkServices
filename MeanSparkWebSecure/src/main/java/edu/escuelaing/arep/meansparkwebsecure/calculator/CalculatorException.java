/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.meansparkwebsecure.calculator;

/**
 *
 * @author J. Eduardo Arias
 */
public class CalculatorException extends Exception{
    public static final String LISTA_VACIA="Se requieren mas de un dato para calcular esta operacion";

    public CalculatorException(String string) {
        super(string);
    }
    
}
