/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts.comparer;

import mp.g17.posts.EntradaGenerica;

import java.util.Comparator;

/**
 *
 * @author usuario
 */
public class ComparePostsByValor implements Comparator<EntradaGenerica> {

    @Override
    public int compare(EntradaGenerica x, EntradaGenerica y) {
        if(x.getPoints() < y.getPoints()) return -1;
        if(x.getPoints() == y.getPoints()) return 0;
        if(x.getPoints() > y.getPoints()) return 1;
 
        return 0;
    }
        
    
}
