import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Если метод имеет аргументы с параметризованным типом (например, Collection или Predicate),
то в случае, если аргумент - производитель (producer), нужно использовать ? extends T,
а если аргумент - потребитель (consumer), нужно использовать ? super T.

Производитель и потребитель, кто это такие? Очень просто: если метод читает данные из аргумента,
то этот аргумент- производитель, а если метод передаёт данные в аргумент, то аргумент является потребителем.
Важно заметить, что определяя производителя или потребителя, мы рассматриваем только данные типа T.
 */

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    //list -- producer
    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    //что должен делать??
    public static<T> List<T> limit(List<T> source, int size) {
        return source.subList(0,size);
    }

    public static <T> void add(List<T> source, T t) {
        source.add(t);
    }

    //удаляет из removeFrom все, что есть в c2
    public static <T> void removeAll(List<? super T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }


    public static <T> boolean containsAll(List<T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<T> c1, List<T> c2) {
        for (T t : c2) {
            if (c1.contains(t)) {
                return true;
            }
        }
        return false;
    }

    //тоже не ясно, что должен делать??
    //Тут сверху ограничиваем Comparable<? super T>
    //<? super T> решает проблему: пусть кладем Integer, при этом хотим иметь возможность сравнить с Double и др.

    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if ((t.compareTo(min)>=0)&&(t.compareTo(max)<=0)) {
                newList.add(t);
            }
        }
        return newList;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if ((comparator.compare(t, min) >= 0) && (comparator.compare(t, max) <= 0)) {
                newList.add(t);
            }
        }
        return newList;
    }
}