/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts.comparer;

import java.util.List;
import mp.g17.posts.Comentario;
import mp.g17.posts.EntradaGenerica;

/**
 *
 * @author usuario
 */
public class Sorter <O> {
    
    Comparer<O> comparer;
    
    public void setComparer(Comparer <O> comparer) {
        this.comparer = comparer;
    }
 
    public Sorter(Comparer <O> comparer) {
        this.comparer = comparer;
    }
 
    private int performComparison(O x, O y) {
        return comparer.compare(x, y);
    }
    
    Sorter<EntradaGenerica> postSorter = new Sorter<>(new ComparePosts());
    Sorter<Comentario> comentSorter = new Sorter<>(new CompareComments());
    
    
    public void sort(List<O> votes) {
        
        O[] items = (O[]) votes.toArray();
        for (int i = 0; i < items.length; i++) { // Asumir de partida que el valor menor de la parte aun no ordenada del array esta en la primera posicion de la parte aun no ordenada
            int minVal = i;  // Recorrer el resto del vector para encontrar otro menor
            for (int j = i + 1; j < items.length; j++) // Si se encuentra un valor menor en la posicion j
                if (performComparison(items[j], items[minVal]) < 0)
                    minVal = j; // nueva posicion del menor jSi el valor de la posicion i no estaba en su sitio porque hemos encontrado en una posicion distinta otro valor aun menor intercambiar las posiciones
            if (i != minVal) {
                O aux = items[i];
                items[i] = items[minVal];
                items[minVal] = aux;
            }
        }
    }
}
