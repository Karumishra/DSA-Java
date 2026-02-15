import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 5);
        map.put("Banana", 2);
        map.put("Orange", 8);
        map.put("Grapes", 1);

        // Convert map entries to a list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort list by values
        list.sort(Map.Entry.comparingByValue());

        // Create a LinkedHashMap to preserve the sorted order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        System.out.println("Sorted Map: " + sortedMap);

    }
}

