/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.meansparkwebsecure.structures;

/**
 *
 * @author J. Eduardo Arias
 */
public class NodeLinkedListG<E>  {
    private E valor;
    private NodeLinkedListG<E> next;
    
    /**
     * 
     * @param valor Encapsula el valor en el nodo
     */
    public NodeLinkedListG(E valor){
        this.valor=valor;
        next=null;
    }
    
    public NodeLinkedListG<E> getNext() {
        return next;
    }
    
    /**
     * @param next asigna a este nodo como siguiente. 
     */
    public void setNext(NodeLinkedListG<E> next) {
        this.next = next;
    }
    
 
    /**
     * 
     * @return devuelve el valor encapsulado
     */
    public E getValor() {
        return valor;
    }

    
}
