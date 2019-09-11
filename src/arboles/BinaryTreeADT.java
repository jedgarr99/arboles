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
public interface BinaryTreeADT <T> {
   
    public boolean isEmpty();
     public int size();
      public boolean contains();
       public T find(T elemento);
        public Iterator<T> imorden();
         public ArrayList<T> preorden();
          public ArrayList<T> postorden();
      
     
   
}