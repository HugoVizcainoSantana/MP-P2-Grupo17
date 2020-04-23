package mp.g17.posts.comparer;

import mp.g17.posts.EntradaGenerica;

import java.util.Comparator;

public class ComparePostByDate implements Comparator<EntradaGenerica> {

    @Override
    public int compare(EntradaGenerica t0, EntradaGenerica t1) {
        return t0.getCreationDate().compareTo(t1.getCreationDate());
    }
}
