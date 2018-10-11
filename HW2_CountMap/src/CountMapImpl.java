import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    private int size;
    private Map<T,Integer> map;

    public CountMapImpl() {
        this.size = 0;
        map = new HashMap<T, Integer>();
    }

    @Override
    public void add(T t) {
        if (map.containsKey(t)) {
            map.put(t,map.get(t)+1);
        } else {
            map.put(t,1);
            size++;
        }
    }

    @Override
    public int getCount(T t) {
        if (map.containsKey(t)){
            return map.get(t);
        } else {
            return 0;
        }
    }

    @Override
    public int remove(T t) {
//        int num = map.get(t);
        int num = getCount(t);
        if (num > 0) map.remove(t);
        return num;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        for (T t : map.keySet()) {
            destination.put(t,map.get(t));
        }
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (T t : source.toMap().keySet()) {
            if (map.containsKey(t)){
                map.put(t,getCount(t)+source.getCount(t));
            } else {
                map.put(t,source.getCount(t));
                size++;
            }
        }
    }
}
