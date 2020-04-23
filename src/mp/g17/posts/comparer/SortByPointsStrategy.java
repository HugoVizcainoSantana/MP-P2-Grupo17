package mp.g17.posts.comparer;

import mp.g17.posts.IVotable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByPointsStrategy<O> extends ASortingStrategy<IVotable, O> {

    public SortByPointsStrategy(SortType sortType) {
        super(sortType);
    }

    @Override
    protected List<O> _sortDescending(List<IVotable> unsorted) {
        List<IVotable> result = new ArrayList<>(unsorted);
        result.sort(Comparator.comparingInt(IVotable::getPoints));
        return (List<O>) result;
    }
}
