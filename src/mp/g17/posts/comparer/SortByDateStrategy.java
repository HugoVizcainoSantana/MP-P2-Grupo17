package mp.g17.posts.comparer;

import mp.g17.posts.IDatable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByDateStrategy<O> extends ASortingStrategy<IDatable, O> {

    public SortByDateStrategy(SortType sortType) {
        super(sortType);
    }

    @Override
    protected List<O> _sortAscending(List<IDatable> unsorted) {
        List<IDatable> result = new ArrayList<>(unsorted);
        result.sort(Comparator.comparing(IDatable::getCreationDate));
        return (List<O>) result;
    }

    @Override
    protected List<O> _sortDescending(List<IDatable> unsorted) {
        List<O> result = _sortAscending(unsorted);
        Collections.reverse(result);
        return result;
    }

}
