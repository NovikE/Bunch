package collection_compare;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCompare {
    public static void main(String[] args){
        Set<Integer> hashSet = new HashSet();
        Set<Integer> treeSet = new TreeSet();

        for(int i = 0; i <  9999; i++)
        {
            hashSet.add(i);
            treeSet.add(i);
        }
        long start = System.nanoTime();
        hashSet.add(10000);
        long  elapsedTime = System.nanoTime() - start;
        System.out.println("HashSet: Operation time to add element:" + elapsedTime);

        start = System.nanoTime();
        treeSet.add(10000);
        elapsedTime = System.nanoTime() - start;
        System.out.println("TreeSet: Operation time to add element:" + elapsedTime);

        start = System.nanoTime();
        hashSet.contains(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("HashSet: Operation time to find element:" + elapsedTime);

        start = System.nanoTime();
        treeSet.contains(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("TreeSet: Operation time to find element:" + elapsedTime);

        start = System.nanoTime();
        hashSet.remove(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("HashSet: Operation time to remove element:" + elapsedTime);

        start = System.nanoTime();
        treeSet.remove(50);
        elapsedTime = System.nanoTime() - start;
        System.out.println("TreeSet: Operation time to remove element:" + elapsedTime);
    }
}
