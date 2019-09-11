/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author hca
 */
public interface BSTADT<T extends Comparable<T>> extends BinaryTreeADT<T> {
    public void add(T elem);
    public T remove(T elem);
    public T removeMin();
    public T findMin();
    public T removeMax();
    public T findMax();
    
            
    
    
    
}
