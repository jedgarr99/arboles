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
public class ArbolAVL <T extends Comparable<T>> implements BinaryTreeADT<T> {
    private NodoBT<T> raiz;
    private int cont;
    
    public ArbolAVL(){
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

    public T findMax() {
        Iterator<T> it= imorden();
        T res=null;
        while(it.hasNext())
            res=it.next();
        return res;
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
                    while(suc.getIzq()!=null)
                    return null;
                }


            }
            return null;
        } else {
            return null;
        }


    }
    public boolean removeB(T elem) { //falta actualizar el apuntador al papá
        NodoBT<T> borrar = find(raiz, elem);
        if (borrar != null) {
            if (borrar.getDer() == null && borrar.getIzq() == null) { //caso 1: es una hoja
                if (borrar == raiz) { // la jhoja es la raíz
                    raiz = null;
                } else {
                    if (borrar.getPapa().getDer()==(borrar)) {
                        borrar.getPapa().setDer(null);
                    } else {
                        borrar.getPapa().setIzq(null);
                    }
                }
            } else {
                if (borrar.getIzq()==null){ //caso 2: solo tiene hijo derecho
                    if(borrar==raiz){
                        raiz = borrar.getDer();
                        raiz.setPapa(null);
                    }
                    else
                        borrar.getPapa().cuelga(borrar.getDer());
                }
                else{
                    if(borrar.getDer()==null){ //caso 2: solo tiene hijo izquierdo
                        if(borrar==raiz){
                            raiz = borrar.getIzq();
                            raiz.setPapa(null);
                        }
                    else
                        borrar.getPapa().cuelga(borrar.getIzq());
                    }
                    else{ //caso 3: tiene dos hijos
                        /**
                         * encontrar el sucesor inorden y ponerlo en donde esta el que quieres borrar
                         * eliminar ese nodo pero antes hacer cuelga
                         */
                        NodoBT<T> suc = borrar.getDer();
                        while(suc.getIzq()!=null)
                            suc = suc.getIzq();
                        borrar.setElement(suc.getElement());
                        if(suc==borrar.getDer())
                            borrar.setDer(suc.getDer());
                        else
                            suc.getPapa().setIzq(suc.getDer());
                       
                    }
                }
                   
            }
            cont--;
            return true;
        } else {
            return false;
        }
    }


    public T removeMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public T findMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


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
    private NodoBT<T>rotacion(NodoBT<T> n){
        NodoBT<T>beta=null,gamma,A,B,C,D,alfa,papa;
        //izquierda-izquierda
        if(n.getFe()==-2&& n.getIzq().getFe()==-1||n.getIzq().getFe()==0){
             alfa=n;
            papa=n.getPapa();
            beta=alfa.getIzq();
             gamma=beta.getIzq();
             A=gamma.getIzq();
            B=gamma.getDer();
             C=beta.getDer();
             D=alfa.getDer();
            gamma.cuelga(A);
            gamma.cuelga(B);
            alfa.cuelga(C);
            alfa.cuelga(D);
            beta.cuelga(alfa);
            beta.cuelga(gamma);
            if(papa!=null)
                papa.cuelga(beta);
            else{
                beta.setPapa(null);
                raiz=beta;
            }
            alfa.setFe(altura(alfa.getDer()) - altura(alfa.getIzq())); //FALTA ESTE METODO           
            beta.setFe(altura(beta.getDer()) - altura(beta.getIzq()));
            return beta;
        }
        //izquierda-derecha
        if(n.getFe()==-2&& n.getIzq().getFe()==1){
            alfa=n;
            papa=n.getPapa();
            beta=alfa.getIzq();
            gamma=beta.getIzq();
            A=beta.getIzq();
            B=gamma.getIzq();
            C=gamma.getDer();
            D=alfa.getDer();
            
            gamma.cuelga(beta);
            gamma.cuelga(alfa);
            alfa.cuelga(C);
            alfa.cuelga(D);
            beta.cuelga(A);
            beta.cuelga(B);
            if(papa!=null)
                papa.cuelga(gamma);
            else{
                gamma.setPapa(null);
                raiz=gamma;
            }
            alfa.setFe(altura(D.getDer()) - altura(C.getIzq())); //FALTA ESTE METODO           
            beta.setFe(altura(B) - altura(A));
            gamma.setFe(altura(alfa)-altura(beta));
            return gamma;
            
        }
          return beta;
    }
    public int altura(NodoBT<T> n){
        return 0;
    }
    
}
