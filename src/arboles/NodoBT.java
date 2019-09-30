package arboles;

public class NodoBT <T extends Comparable<T>> {
    T element;
    NodoBT<T> izq, der,papa;
    int fe;
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
    public int noDescendientes(){
        return 1;
    }
    public void cuelga(NodoBT<T> n){
        if(n.getElement().compareTo(element)<0)
            izq = n;
        else
            der = n;
        n.setPapa(this);
    }


}
