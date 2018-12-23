import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> source = Arrays.asList(1,2,3);
        List<Integer> destination = new ArrayList<>(Arrays.asList(4, 5, 6));
        CollectionUtils.addAll(source,destination);

        System.out.println(destination.toString()); // 4,5,6,1,2,3
        System.out.println(CollectionUtils.indexOf(destination,2)); //4

        List<Integer> limitedList = CollectionUtils.limit(destination,4);
        System.out.println(limitedList.toString());

        System.out.println(CollectionUtils.containsAll(destination,source));

        List<Integer> rangedList = CollectionUtils.range(destination,2,4);
        System.out.println(rangedList.toString());

    }
}
