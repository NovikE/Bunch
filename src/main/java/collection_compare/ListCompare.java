package collection_compare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListCompare {
    public static void main(String[] args) {

    List<Integer> arrList = new ArrayList();
    List<Integer> linList = new LinkedList<>();


    for(int i = 0; i <  9999; i++)
        {
            arrList.add(i);
            linList.add(i);
        }

    long start = System.nanoTime();
    arrList.add(10000);
    long  elapsedTime = System.nanoTime() - start;
    System.out.println("ArrayList: Operation time to add element:" + elapsedTime);

    start = System.nanoTime();
    linList.add(10000);
    elapsedTime = System.nanoTime() - start;
    System.out.println("LinkedList: Operation time to add element:" + elapsedTime);

    start = System.nanoTime();
    arrList.get(50);
    elapsedTime = System.nanoTime() - start;
    System.out.println("ArrayList: Operation time to get element:" + elapsedTime);

    start = System.nanoTime();
    linList.get(50);
    elapsedTime = System.nanoTime() - start;
    System.out.println("LinkedList: Operation time to get element:" + elapsedTime);

    start = System.nanoTime();
    arrList.remove(50);
    elapsedTime = System.nanoTime() - start;
    System.out.println("ArrayList: Operation time to remove element:" + elapsedTime);

    start = System.nanoTime();
    linList.remove(50);
    elapsedTime = System.nanoTime() - start;
    System.out.println("LinkedList: Operation time to remove element:" + elapsedTime);

    }

}
