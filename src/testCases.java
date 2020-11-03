import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class testCases {

    @Test
    public void test_addOne() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Test","Size should be 1");
        System.out.println("Test: addOne. ");
        testMap.printTable();
        System.out.println("Expected output: 1, Got: " + testMap.size());
        assertEquals(1, testMap.size());
    }

    @Test
    public void test_removeOne() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Test","Size should be 1");
        testMap.put("Test2","Size should be 2");
        testMap.put("Test3","Size should be 3");
        testMap.remove("Test2");
        System.out.println("Test: removeOne. ");
        testMap.printTable();
        System.out.println("Expected output: 2, Got: " + testMap.size());
        assertEquals(2, testMap.size());
    }

    @Test
    public void test_clear() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Test","Size should be 1");
        testMap.put("Test2","Size should be 2");
        testMap.put("Test3","Size should be 3");
        testMap.clear();
        System.out.println("Test: removeOne. ");
        testMap.printTable();
        System.out.println("Expected output: 2, Got: " + testMap.size());
        assertEquals(0, testMap.size());

    }
    
    @Test
    public void test_get1() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Test", "Get this key");
        assertEquals(testMap.get("Test"), "Get this key");
    }

    @Test
    public void test_get2() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Test", "Get this key");
        testMap.put("Test", "Nah JK this the key");
        assertEquals(testMap.get("Test"), "Nah JK this the key");
    }

    @Test
    public void test_containsVal1() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Shit", "cum");
        testMap.put("Fart", "not cum");
        testMap.put("Cum", "not cum");
        testMap.put("Piss", "cum");
        testMap.put("Tits", "not cum");
        testMap.put("Ass", "not cum");
        assertEquals(testMap.containsValue("cum"), true);
    }

    @Test
    public void test_containsVal2() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Shit", "cum");
        testMap.put("Fart", "not cum");
        testMap.put("Cum", "not cum");
        testMap.put("Piss", "cum");
        testMap.put("Tits", "not cum");
        testMap.put("Ass", "not cum");
        assertEquals(testMap.containsValue("penis"), false);
    }

    @Test
    public void test_isEmpty1() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        assertEquals(testMap.isEmpty(), true);
    }

    @Test
    public void test_isEmpty2() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Shit", "cum");
        testMap.put("Fart", "not cum");
        testMap.put("Cum", "not cum");
        testMap.put("Piss", "cum");
        testMap.put("Tits", "not cum");
        testMap.put("Ass", "not cum");
        assertEquals(testMap.isEmpty(), false);
    }

    @Test
    public void test_isEmpty3() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Shit", "cum");
        testMap.put("Fart", "not cum");
        testMap.put("Cum", "not cum");
        testMap.put("Piss", "cum");
        testMap.put("Tits", "not cum");
        testMap.put("Ass", "not cum");
        testMap.clear();
        assertEquals(testMap.isEmpty(), true);
    }

    @Test
    public void test_isEmpty4() {
        MyHashMap<String, String> testMap = new MyHashMap<>();
        testMap.put("Shit", "cum");
        testMap.put("Fart", "not cum");
        testMap.put("Cum", "not cum");
        testMap.put("Piss", "cum");
        testMap.put("Tits", "not cum");
        testMap.put("Ass", "not cum");
        
        testMap.remove("Shit");
        testMap.remove("Fart");
        testMap.remove("Cum");
        testMap.remove("Piss");
        testMap.remove("Tits");
        testMap.remove("Ass");

        assertEquals(testMap.isEmpty(), true);
    }

}
