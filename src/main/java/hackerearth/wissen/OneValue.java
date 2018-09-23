package hackerearth.wissen;

import java.util.*;

public class OneValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WissenList list = new WissenList();
        for (int q = scanner.nextInt(); q > 0; q--) {
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    list.insert(scanner.nextInt());
                    break;
                case 2:
                    list.remove(scanner.nextInt());
                    break;
                case 3:
                    Integer leastFreqInteger = list.getLeastFreqInteger();
                    System.out.println(leastFreqInteger != null ? leastFreqInteger : -1);
                    break;
                case 4:
                    Integer highestFreqInteger = list.getHighestFreqInteger();
                    System.out.println(highestFreqInteger != null ? highestFreqInteger : -1);
                    break;
                default:
                    System.err.println("Unknown type: " + type);
            }
        }
    }
}

class WissenList {
    private Map<Integer, Integer> map = new HashMap<>();
    private Integer minFreqKey = null;
    private Integer maxFreqKey = null;

    void insert(Integer key) {
        map.putIfAbsent(key, 0);
        map.put(key, map.get(key) + 1);
        updateFreq(key);
    }

    void remove(Integer key) {
        map.putIfAbsent(key, 0);
        map.put(key, map.get(key) > 0 ? (map.get(key) - 1) : 0);
        updateFreq(key);
    }

    /**
     * Updates reference to minFreqKey and maxFreqKey values.
     *
     * @param key the potential maxFreqKey of minFreqKey value
     */
    private void updateFreq(Integer key) {
        if (minFreqKey == null
                || map.get(minFreqKey) > map.get(key)
                || (Objects.equals(map.get(minFreqKey), map.get(key)) && key > minFreqKey)) {
            minFreqKey = key;
        }

        if (maxFreqKey == null
                || map.get(maxFreqKey) < map.get(key)
                || (Objects.equals(map.get(maxFreqKey), map.get(key)) && key < maxFreqKey)) {
            maxFreqKey = key;
        }
    }

    Integer getLeastFreqInteger() {
        return minFreqKey;
    }

    Integer getHighestFreqInteger() {
        return maxFreqKey;
    }
}