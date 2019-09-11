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
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> b=new ArrayList();
        b.add("5");
        LinkedBST<String> a = new LinkedBST();
        a.add("9");
        a.add("7");
        a.add("4");
        a.add("8");
        a.add("3");
        a.add("5");
        System.out.println(b.toString());
        System.out.println(a.preorden().toString());
        
    }
}
