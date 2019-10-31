package Del_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void put_AllowsDuplicates() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("hei".hashCode(), "hei");
        myHashMap.put("hei".hashCode(), "bei");
        myHashMap.put("hei".hashCode(), "hei");

        System.out.printf("%s \n", myHashMap.getAll("hei".hashCode()));
        System.out.printf("size: %s", myHashMap.size());
    }

}