import java.util.ArrayList;
import java.util.Scanner;

public class HashFunction<K, V> {
    public static void main(String args[]) throws Exception {
        new TestHarness(new HashFunction<String, String>()).run();
    }

    ArrayList<ArrayList<HashEntry<K, V>>> hashMap;
    int size;

    class HashEntry<K, V> {
        K key;
        V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }

    public HashFunction() {
        this(37);
    }

    public HashFunction(int size) {
        this.size = size;
        hashMap = new ArrayList<>(size);
        for(int i=0; i<size; i++)
            hashMap.add(i, new ArrayList<HashEntry<K, V>>());
    }
    public int getHashIndex(K key) {
        return key.hashCode() % size;
    }
    public V get(K key) {
        int idx = getHashIndex(key);
        System.out.println("GET "+ idx);
        ArrayList<HashEntry<K, V>> entryList = hashMap.get(idx);
        System.out.println("GOT List: " + entryList);
        for(HashEntry<K, V> entry : entryList) {
            if(entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int idx = getHashIndex(key);
        System.out.println("PUT "+ idx);
        ArrayList<HashEntry<K, V>> entryList = hashMap.get(idx);
        HashEntry<K, V> newEntry = new HashEntry<K, V>(key, value);
        boolean isFound = false;
        for(HashEntry<K, V> entry : entryList) {
            if(entry.key.equals(newEntry.key)) {
                isFound = true;
                entry.value = newEntry.value;
            }
        }
        if(!isFound) {
            entryList.add(newEntry);
        }
        System.out.println(hashMap);
    }


    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from
     * STDIN.
     */
    public static class TestHarness implements Runnable {
        final HashFunction<String, String> hashtable;

        public TestHarness(HashFunction<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}