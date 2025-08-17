import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Adding elements
        list.add(0);
        list.add(1);
        System.out.println("After adding elements: " + list);

        // Getting the element
        int element = list.get(0);
        System.out.println("Element at index 0: " + element);

        // Add an element in between
        list.add(1, 1);
        System.out.println("After inserting 1 at index 1: " + list);

        Collections.sort(list);
        System.out.println("After sorting: " + list);
    }
}
