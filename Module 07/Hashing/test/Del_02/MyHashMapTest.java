package Del_02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {
    @Test
    void put_AllowsDuplicatesWithSameHashCode() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("Foo", "AAAA");
        myHashMap.put("Foo", "BBBB");
        myHashMap.put("Foo", "CCCC");

        assertEquals(new HashSet<>(Arrays.asList("AAAA", "BBBB", "CCCC")), myHashMap.getAll("Foo"));
    }

    @Test
    void remove_RemovesAllDuplicatesWithSameHashcode() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("Foo", "AAAA");
        myHashMap.put("Foo", "BBBB");
        myHashMap.put("Foo", "CCCC");

        myHashMap.remove("Foo");
        assertEquals(0, myHashMap.size());
    }

    @Test
    void put_HandlesHashCollisionsForDifferentStrings() {
        // The Strings "Siblings" and "Teheran" has the same hashCode values
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("Siblings", "Oh no, a collision occurred! :-(");
        myHashMap.put("Teheran", "Oh no, a collision occurred! :-(");

        assertEquals(myHashMap.get("Siblings"), myHashMap.get("Teheran"));
    }
}