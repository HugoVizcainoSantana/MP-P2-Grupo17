/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts.comparer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author usuario
 */
public abstract class ASortingStrategy<I, O> implements Serializable {

    private final SortType sortType;

    public ASortingStrategy(SortType sortType) {
        this.sortType = sortType;
    }

    protected abstract List<O> _sortDescending(List<I> unsorted);

    public List<O> sort(List<O> unsorted) {
        if (sortType == SortType.DESCENDING) {
            return _sortDescending((List<I>) unsorted);
        } else if (sortType == SortType.ASCENDING) {
            return _sortAscending((List<I>) unsorted);
        }
        throw new RuntimeException("Unknown sorting type passed. " + sortType.name());
    }

    // Default implementation, in case the developer doesn't provide one
    protected List<O> _sortAscending(List<I> unsorted) {
        List<O> result = new ArrayList<>(_sortDescending(unsorted));
        Collections.reverse(result);
        return result;
    }
}
