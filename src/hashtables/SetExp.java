package hashtables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExp {
    public static <E> boolean unique(List<E> list) {

        Set<E> checklist = new HashSet<>();
        for (E item : list) {
            if (checklist.contains(item)) {
                return false;
            }
            else {
                checklist.add(item);
            }
        }
        return true;
    }
}
