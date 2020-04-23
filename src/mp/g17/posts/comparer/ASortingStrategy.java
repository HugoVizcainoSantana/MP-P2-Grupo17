/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts.comparer;

import java.util.List;

/**
 * @author usuario
 */
public abstract class ASortingStrategy<I, O> {
    protected abstract List<O> _sort(List<I> unsorted);

    public List<O> sort(List<O> unsorted) {
        return _sort((List<I>) unsorted);
    }
}
