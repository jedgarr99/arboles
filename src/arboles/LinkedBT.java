package arboles;


import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hca
 */
public class LinkedBT <T extends Comparable<T>> implements BinaryTreeADT<T> {
    private NodoBT<T> raiz;
    private int cont;
   
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return raiz==null;
    }

    @Override
    public boolean contains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodoBT<T> find(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public Iterator<T> imorden() {
        ArrayList<T> lista =new ArrayList<T>();
        imorden(raiz, lista);
        return lista. iterator();
       
    }
    private void imorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        imorden(actual.getIzq(),lista);
        imorden(actual.getDer(),lista);
        lista.add(actual.getElement());
    }  
    
    
    public Iterator<T> preorden() {
        ArrayList<T> lista =new ArrayList<T>();
        preorden(raiz, lista);
        return lista. iterator(); 
    }
    private void preorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        lista.add(actual.getElement());
        preorden(actual.getIzq(),lista);
        preorden(actual.getDer(),lista);
    }
    
    
     public Iterator<T> postorden() {
        ArrayList<T> lista =new ArrayList<T>();
        postorden(raiz, lista);
        return lista. iterator();
       
    }
    private void postorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        postorden(actual.getIzq(),lista);
        postorden(actual.getDer(),lista);
        lista.add(actual.getElement());
    }

    
   
}