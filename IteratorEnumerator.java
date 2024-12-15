import java.util.*;

public class IteratorEnumerator {

    public static void main(String[] args) {

        /* An Iterator is a versatile tool in Java that allows you to traverse through any type of collection,
        such as Set, List, Queue, Deque, and even classes implementing the Map interface.
        It provides methods to read and remove elements from a collection during iteration. */

        List<String> list = new ArrayList<>();
        list.add("Ram");
        list.add("Shyam");
        list.add("Jiva");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            System.out.println(temp);

            // Remove the element "Blue" if found
            if ("Jiva".equals(temp)) {
                it.remove();
            }
        }
        System.out.println("Modified List: "+list);


        /* Enumeration is an older interface used for traversing legacy collections such as
        Vector and Hashtable. It allows you to read elements from these collections but does
        not support modifications. */


        Vector<String> vector = new Vector<>();
        vector.add("UP");
        vector.add("MP");
        vector.add("HR");

        System.out.println("Enumeration Result: ");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
