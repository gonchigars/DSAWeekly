import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Add entries
        map.put("Apple", 3);
        map.put("Banana", 5);

        // Retrieve a value
        System.out.println("Apples: " + map.get("Apple"));

        // Check if a key or value exists
        System.out.println("Has Apple? " + map.containsKey("Apple"));
        System.out.println("Has 10? " + map.containsValue(10));

        // Update a value
        map.put("Apple", 10);
        System.out.println("Updated Apples: " + map.get("Apple"));

        // Remove an entry
        map.remove("Banana");

        // Size of the map
        System.out.println("Size of map: " + map.size());

        // Iterate through entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Clear the map
        map.clear();
        System.out.println("Is map empty? " + map.isEmpty());
    }
}
