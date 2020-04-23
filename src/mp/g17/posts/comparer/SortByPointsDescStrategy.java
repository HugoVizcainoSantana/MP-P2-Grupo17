package mp.g17.posts.comparer;

import mp.g17.posts.IVotable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByPointsDescStrategy<O> extends ASortingStrategy<IVotable, O> {

    @Override
    protected List<O> _sort(List<IVotable> unsorted) {
        List<IVotable> result = new ArrayList<>(unsorted);
        result.sort(Comparator.comparingInt(IVotable::getPoints));
        return (List<O>) result;
    }
}
