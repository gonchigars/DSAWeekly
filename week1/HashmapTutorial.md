## **Introduction to HashMap**

### What is a `HashMap`?

Think of a `HashMap` like a locker room with numbered lockers (keys) and items inside (values). Each locker number (key) helps you quickly find what’s inside (value) without searching through every locker.

In Java, a `HashMap` stores data as key-value pairs, where each unique key has a value associated with it. `HashMap` is efficient because it allows you to get or put items in constant time, `O(1)`, on average.

---

## **Creating a HashMap**

Here’s how to create a `HashMap`:

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Explanation: This map will store String keys and Integer values.
        // Example: You might store ("Apple", 3) to show you have 3 apples.
    }
}
```

---

## **Operations in HashMap**

### 1. **Adding Entries (Put Operation)**

Use the `put()` method to add a key-value pair.

```java
map.put("Apple", 3);    // Adds key "Apple" with value 3
map.put("Banana", 5);   // Adds key "Banana" with value 5
```

**How it works:** When you put a new entry, `HashMap` calculates a “hash code” for the key (like a locker number) and places the value in that slot.

- If the key already exists, the `put` method **replaces** the old value with the new one.

---

### 2. **Retrieving Values (Get Operation)**

Use `get()` to retrieve the value for a given key.

```java
int apples = map.get("Apple"); // Returns 3
System.out.println("Apples: " + apples);
```

**How it works:** The `HashMap` calculates the hash code for "Apple" and directly retrieves the associated value (3) from that slot, so it's fast.

---

### 3. **Checking for Keys or Values**

To see if a key or value exists, use `containsKey()` and `containsValue()`:

```java
boolean hasApple = map.containsKey("Apple");     // true
boolean hasTen = map.containsValue(10);          // false
```

**Explanation:** `containsKey` is like asking, “Is there a locker for ‘Apple’?” and `containsValue` asks, “Is there any locker containing ‘10’?”

---

### 4. **Removing Entries (Remove Operation)**

Use `remove()` to delete a key and its associated value.

```java
map.remove("Banana");  // Removes the key "Banana" and its value 5
```

**How it works:** `remove` finds the locker (key) and takes out whatever is inside (value), freeing up that slot.

---

### 5. **Updating a Value**

To update a value, simply use `put()` again with the same key.

```java
map.put("Apple", 10);  // Updates the value of "Apple" to 10
```

**Explanation:** If a key already exists, `put` replaces the old value with the new value.

---

### 6. **Getting the Size of the HashMap**

Use `size()` to know how many key-value pairs are in the `HashMap`.

```java
int size = map.size();
System.out.println("Size: " + size);  // Prints the number of entries
```

---

### 7. **Iterating through a HashMap**

You can use a loop to go through each entry in a `HashMap`.

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

**Explanation:** This loop goes through every locker and shows you the key (locker number) and value (item inside).

---

### 8. **Clearing the HashMap**

Use `clear()` to remove all entries from the map.

```java
map.clear();  // Removes all key-value pairs
System.out.println("Map is now empty: " + map.isEmpty());
```

---

## **Behind the Scenes: How HashMap Works Internally**

- **Hashing**: `HashMap` uses a **hash function** to convert each key to a unique number (hash code). This hash code determines where in memory the value is stored.
- **Collisions**: Sometimes, different keys generate the same hash code. When this happens, `HashMap` stores these entries in a linked list or a balanced tree at that slot.
- **Load Factor**: `HashMap` expands its size when it reaches a certain load factor (usually 75%). This keeps the operations fast by avoiding too many collisions.

---

## **Full Example**

Here’s a complete example that includes all operations:

```java
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
```

### Output:

```
Apples: 3
Has Apple? true
Has 10? false
Updated Apples: 10
Size of map: 1
Apple: 10
Is map empty? true
```

---

## **Summary**

- `HashMap` is like a locker system where keys are locker numbers and values are the items inside.
- Common operations include `put` (add), `get` (retrieve), `remove` (delete), and `containsKey`/`containsValue` (search).
- It’s efficient, with average `O(1)` time complexity for `put`, `get`, and `remove`.

In this code, `HashMap` is used in two main places:

### 1. **User Storage in `AuthService`**

```java
private final Map<String, User> users = new HashMap<>();
```

- **Purpose**: This `HashMap` stores registered users. The `String` key is the username, and the `User` object contains the user’s details.
- **Usage**:
  - **Registering a User**: When a user registers, their username is checked in the `users` map to ensure uniqueness. If it doesn’t exist, the user is added with an encrypted password.
  - **Authenticating a User**: When a user logs in, the `authenticate` method uses the username to retrieve the `User` object and verify the password.
- **Advantage**: `HashMap` allows fast `O(1)` time complexity for insertions and lookups, making registration and authentication efficient.

### 2. **Session Management in `SessionManager`**

```java
private final Map<String, String> sessions = new HashMap<>();
```

- **Purpose**: This `HashMap` manages active user sessions. Here, the `String` key is the username, and the `String` value is the associated JWT token.
- **Usage**:
  - **Creating a Session**: When a user logs in, `createSession` adds an entry to the `sessions` map with the username as the key and the JWT token as the value.
  - **Validating a Session**: When a user makes a request, `isSessionValid` checks if the provided token matches the stored token for the username, validating the session.
  - **Invalidating a Session**: When a user logs out, `invalidateSession` removes the entry for the user from the map, effectively logging them out.
- **Advantage**: The `HashMap` allows constant-time retrieval and update of sessions, making session management efficient in terms of checking, validating, and removing sessions.

In both cases, `HashMap` enables efficient handling of user data and session tokens, crucial for real-time authentication operations in web applications.
