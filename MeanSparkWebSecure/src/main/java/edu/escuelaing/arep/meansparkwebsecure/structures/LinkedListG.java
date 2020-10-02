/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.meansparkwebsecure.structures;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 *
 * @author J. Eduardo Arias
 */
public class LinkedListG<E> implements List<E>{
    private NodeLinkedListG<E> head;
    private NodeLinkedListG<E> tail;
    private int size;
    
    /**
     * Crea la lista con cabeza y cola en nulo
     */
    public LinkedListG() {
       head=null;
       tail=null;
       size=0;
    }
    /**
     *
     * @return devuelve la cabeza del linked list
     */
    public NodeLinkedListG getHead(){
        return head;
    }
    
    /**
     * Con la estrategia de Linked List agrega elementos al final
     * @param e el valor del nodo
     * 
     */   
    @Override
    public boolean add(E e) {
        NodeLinkedListG<E> nuevo=new NodeLinkedListG(e);
        if (head==null){
            tail= head= nuevo;
        }else{
            tail.setNext(nuevo);
            tail=nuevo;
        }
        size++;
        return true;
    }
    
       
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /** 
     * @return devuelve el tamaño del LinkedListG
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    
    @Override
    public Iterator<E> iterator() {
           return new ListIteratorG<>(this);              
    }
    
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        int i=0;
        E ans=null;
        Iterator it=this.iterator();
        while(it.hasNext() && i<=index){           
            if (i==index){
                ans=(E) it.next();
            }else{
                it.next();
            }
            i++;
        }
        
        return ans;
    }
    
  

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        String ans = "";
        Iterator it = this.iterator();
        if(it.hasNext()){
           ans+=it.next();
        }        
        while (it.hasNext()) {            
            ans+=","+it.next();
        }
        return ans;
    }
    
    
    /**
     * Es una implementacion rapida de ListIterator
     * @param <E> del tipo que pueda contener LinkedListG
     */
    private class ListIteratorG<E> implements ListIterator<E> {
        private NodeLinkedListG<E> actual;
        
        /**
         * 
         * @param list en base de un LinkedListG toma como actual la cabeza de este.
         */
        private ListIteratorG(LinkedListG<E> list) {
            actual=list.getHead();
        }
        
         private ListIteratorG(LinkedListG<E> list,int index) {
            //actual=list.get(index) return NODE ;
        }

        @Override
        public boolean hasNext() {
            return actual != null; 
        }

        @Override
        public E next() {
           E data = actual.getValor(); 
           actual = actual.getNext(); 
           return data;   
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
      
    }

    
    
    
}

