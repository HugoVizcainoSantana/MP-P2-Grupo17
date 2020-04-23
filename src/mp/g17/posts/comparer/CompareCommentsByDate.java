package mp.g17.posts.comparer;
import mp.g17.posts.Comentario;
import java.util.Comparator;

public class CompareCommentsByDate implements Comparator<Comentario> {
    @Override
    public int compare(Comentario comment1, Comentario comment2) {
        return comment1.getCreationDate().compareTo(comment2.getCreationDate());
    }
}
