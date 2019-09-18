package arboles;

import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hca
 */
public interface BinaryTreeADT <T extends Comparable<T>> {
   
    public boolean isEmpty();
    public int size();
    public boolean contains();
    public NodoBT<T> find(T elemento);
    public Iterator<T> imorden();
    public Iterator<T> preorden();
    public Iterator<T> postorden();
      
     
   
}