/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.meansparkwebsecure.readers;

import java.util.List;

/**
 *
 * @author J. Eduardo Arias
 */
public interface Reader {
    void read(String source);
    List<List<Double>> getData();
}
