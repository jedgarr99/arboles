package arboles;

import java.util.ArrayList;
import java.util.Iterator;

public class NodoBT <T extends Comparable<T>> {
    T element;
    NodoBT<T> izq, der,papa;
    int fe,altura,cant;
    NodoBT(T elem) {
        element=elem;
        izq=null;
        der=null;
        fe=0;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }
    public void feS(){
        this.fe++;
    }
    public void feR(){
        this.fe--;
    }

    public T getElement() {
        return element;
    }

    public NodoBT<T> getIzq() {
        return izq;
    }

    public NodoBT<T> getDer() {
        return der;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setIzq(NodoBT<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoBT<T> der) {
        this.der = der;
    }

    public NodoBT<T> getPapa() {
        return papa;
    }

    public void setPapa(NodoBT<T> papa) {
        this.papa = papa;
    }
    public int compareTo(NodoBT<T> otro){
        return this.element.compareTo(otro.element);
    }
    @Override
    public String toString(){
        return element.toString();
    }
    public int noDescendientes() {
        ArrayList<T> lista =new ArrayList<T>();
        noDescendientes(this, lista);
        return lista.size()-1;
    }

    private void noDescendientes(NodoBT<T> act, ArrayList<T> lista) {
        if (act==null)
            return;
        noDescendientes(act.getIzq(),lista);
        noDescendientes(act.getDer(),lista);
        lista.add(act.getElement());
        
    }
    public void cuelga(NodoBT<T> n){
        if(n.getElement().compareTo(element)<0)
            izq = n;
        else
            der = n;
        n.setPapa(this);
    }
    public int retornarAltura() {
         altura = 0;
        retornarAltura(this, 1);
        return altura;
    }

    private void retornarAltura(NodoBT<T> reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDer(), nivel + 1);
        }
    }
    public int noDescendientes2() {
        cant = 0;
        noDescendientes2(this);
        return cant;
    }

    private void noDescendientes2(NodoBT<T> act) {
        if (act!= null) {
            cant++;
           noDescendientes2(act.getIzq());
           noDescendientes2(act.getDer());
        }
    }
    


}
