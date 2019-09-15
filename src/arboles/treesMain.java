/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.ArrayList;

/**
 *
 * @author hca
 */
public class treesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        LinkedBST<String> a = new LinkedBST();
        a.add("9");
        a.add("7");
        a.add("4");
        a.add("8");
        a.add("3");
        a.add("5");
        a.add("b");
        a.add("c");
        a.add("d");
        


        System.out.println(a.preordenA().toString());
        System.out.println(a.postordenA().toString());
        System.out.println(a.imordenA().toString());
        System.out.println(a.size());
       
        
        
    }
}
