package Del_02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {

    @Test
    void put_AllowsDuplicates() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("foo", "AAA");
        myHashMap.put("foo", "BBB");
        myHashMap.put("foo", "CCC");

        HashSet<String> hashSet = new HashSet<>(Arrays.asList("AAA", "BBB", "CCC"));
        assertEquals(myHashMap.getAll("foo"), hashSet);
    }

    @Test
    void remove_RemovesAllDuplicates() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("foo", "AAAA");
        myHashMap.put("foo", "BBBB");
        myHashMap.put("foo", "CCCC");
        myHashMap.remove("foo");

        HashSet<String> hashSet = new HashSet<>();
        // assertThat(myHashMap.size(), equalTo(0));
        // assertEquals(myHashMap.size(), 0);
        assertEquals(myHashMap.getAll("foo"), hashSet);
    }

}