package collection_compare;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapCompare {
    public static void main(String[] args){
        Map<Integer, String> hashMap = new HashMap();
        Map<Integer, String> treeMap = new TreeMap();

        for (int i = 0; i < 9999; i++){
            hashMap.put(i, "a" + i);
            treeMap.put(i, "a" + i);
        }

        long start = System.nanoTime();
        hashMap.put(10000,"b");
        long  elapsedTime = System.nanoTime() - start;
        System.out.println("HashMap: Operation time to add element:" + elapsedTime);

        start = System.nanoTime();
        treeMap.put(10000, "b");
        elapsedTime = System.nanoTime() - start;
        System.out.println("TreeMap: Operation time to add element:" + elapsedTime);

        start = System.nanoTime();
        hashMap.get(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("HashMap: Operation time to find element:" + elapsedTime);

        start = System.nanoTime();
        treeMap.get(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("TreeMap: Operation time to find element:" + elapsedTime);

        start = System.nanoTime();
        hashMap.remove(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("HashMap: Operation time to remove element:" + elapsedTime);

        start = System.nanoTime();
        treeMap.remove(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("TreeMap: Operation time to remove element:" + elapsedTime);


    }
}
