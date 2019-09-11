/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author hca
 */
public class LinkedBST <T extends Comparable<T>> implements BSTADT<T>{
    private NodoBT<T> raiz;
    private int cont;
    
    public LinkedBST(){
        raiz=null;
        cont=0;
    }
    public void add(T elem){
        if(elem!=null){
        NodoBT<T> nodo=new NodoBT(elem);
        cont++;
        if (raiz==null){
            raiz=nodo;      
        }
        else
            add(nodo, raiz);     
        }
    }
    private void add(NodoBT<T> nodo,NodoBT<T> act){
        if(nodo.compareTo(act)>0)
            if(act.der==null){
                act.der=nodo;
                nodo.setPapa(act);
                return;
            }
            else{
                add(nodo, act.der);  
            }
        else
            if(act.izq==null){
                act.izq=nodo;
                nodo.setPapa(act);
                return;
            }
            else{
                add(nodo, act.izq);      
            }
    }
    public ArrayList<T> preorden() {
        ArrayList<T> lista =new ArrayList<T>();
        preorden(raiz, lista);
        return lista; 
    }
    private void preorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        lista.add(actual.getElement());
        preorden(actual.getIzq(),lista);
        preorden(actual.getDer(),lista);
    }

    @Override
    public T remove(T elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T find(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> imorden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


     public ArrayList<T> postorden() {
        ArrayList<T> lista =new ArrayList<T>();
        postorden(raiz, lista);
        return lista;
       
    }
    private void postorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        postorden(actual.getIzq(),lista);
        postorden(actual.getDer(),lista);
        lista.add(actual.getElement());
    }

 
    
}
