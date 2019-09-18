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
 * @param <T>
 */
public class LinkedBST <T extends Comparable<T>> implements BSTADT<T>{
    private NodoBT<T> raiz;
    private int cont;
    
    public LinkedBST(){
        raiz=null;
        cont=0;
    }
    public NodoBT<T> getRaiz(){
        return raiz;
    }
    @Override
    public boolean isEmpty() {
        return raiz==null;
    }

    @Override
    public int size() {
        return cont;
    }
    @Override
    public T findMax() {
        Iterator<T> it= imorden();
        T res=null;
        while(it.hasNext())
            res=it.next();
        return res;
    }
    
    @Override
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
    
    
    
    public ArrayList<T> preordenA() {
        ArrayList<T> lista =new ArrayList<>();
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
     public Iterator<T> preorden() {
        ArrayList<T> lista =new ArrayList<T>();
        preorden(raiz, lista);
        return preordenA().iterator();
    }
     
     
     
    public ArrayList<T> postordenA() {
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
    public Iterator<T> postorden() {
        return postordenA().iterator();
       
    }

    
    
    public ArrayList<T> imordenA() {
        ArrayList<T> lista =new ArrayList<T>();
        imorden(raiz, lista);
        return lista;
       
    }
    public Iterator<T> imorden() {
        return imordenA().iterator();
       
    }
    private void imorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        imorden(actual.getIzq(),lista);
        lista.add(actual.getElement());
        imorden(actual.getDer(),lista);
        
    }  
    
    @Override
    public T remove(T elem) {
        NodoBT<T> borra = find(elem);
        if (borra != null) {
            cont--;
            if (borra.getIzq() == null && borra.getDer() == null) {
                if (borra == raiz) {
                    raiz = null;
                } else if (elem.compareTo(borra.getPapa().getElement()) < 0) {
                    borra.getPapa().setIzq(null);
                } else {
                    borra.getPapa().setDer(null);
                }
            } else {
                if (borra.getIzq() == null) {
                    if (borra == raiz) {
                        raiz = borra.getDer();
                        raiz.setPapa(null);
                    } else {
                        borra.getPapa().cuelga(borra.getDer());
                    }
                } else if (borra.getDer() == null) {
                    if (borra == raiz) {
                        raiz = borra.getIzq();
                        raiz.setPapa(null);
                    } else {
                        borra.getPapa().cuelga(borra.getIzq());
                    }
                    

                }
                else{//caso 3: tiene 2 hijos
                    NodoBT<T> suc=borra.getDer();
                    while(suc.getIzq()!=nul)
                    
                }


            }
        } else {
            return null;
        }


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
    public boolean contains() {
        return true;
    }
    

    @Override
    public NodoBT<T> find(T elemento) {
        if(elemento!=null)
            return find(raiz, elemento);
        else 
            return null;
        
  
    }
    private NodoBT<T> find(NodoBT<T> act, T elem){
        boolean enc=false;
        
        while(!enc&&act!=null){
            if(elem.compareTo(act.getElement())<0)
                act=act.getIzq();
            else
                if(elem.compareTo(act.getElement())>0)
                    act=act.getDer();
                else 
                    enc=true;     
        }
        return act;
        
    }
    
}
