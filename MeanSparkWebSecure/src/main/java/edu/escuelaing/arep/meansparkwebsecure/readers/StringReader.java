/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.meansparkwebsecure.readers;

import edu.escuelaing.arep.meansparkwebsecure.structures.LinkedListG;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J. Eduardo Arias
 */
public class StringReader implements Reader{
    
    private String separator;
    private List<Double> data;
    
    public StringReader(){
        this(" ");
    }

    public StringReader(String separator) {
        this.separator = separator;
        data=new LinkedListG<>();
    }

    
    public void setSeparator(String separator) {
        this.separator = separator;
    }   
    
    /**
     * Lee apartir de un String separado por espacios va guardando los numeros
     * encontrados en la variable data
     * @param source 
     */
    @Override
    public void read(String source) {
        String[] separados=source.split(separator);       
        for (String s:separados){
            Double value;
            try {
                value = Double.parseDouble(s);         
                data.add(value);
            } catch (Exception e) {
                System.out.println("Ignorado: "+s);
            }
                   
        }
    }

    @Override
    public List<List<Double>> getData() {       
        return new ArrayList<List<Double>>(){
          {
              add(data);
          }
      };       
    }
    
}
