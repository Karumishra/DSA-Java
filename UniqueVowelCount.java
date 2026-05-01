import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


// Write Code to print no of unique vowels in array of string
public class UniqueVowelCount {
    public static void main(String[] args) {
        System.out.println("Enter size of array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter string elements:");
        String []array = new String[n];
        for(int i=0; i<n; i++) {
            array[i] = sc.next();
        }
        for(String i :array) {
            int res = countVowels(i);
            System.out.println(" Unique Vowels in " + i + " are " + res);
        }

    }

    public static int countVowels(String word) {
        //most efficient
        Set<Character> vowelsFound = new HashSet<>();
        String vowels = "aeiou";

        for (char c : word.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelsFound.add(c);
            }
        }
        return vowelsFound.size();
    }

//    public static int countVowels(String word) {
//        return (int) word.toLowerCase()
//                .chars()
//                .filter(c -> "aeiou".indexOf(c) != -1)
//                .distinct()
//                .count();
//    }

//    public static int countVowels(String str) {
//        HashSet<Character> set = new HashSet<>();
//        if (str.contains("a"))
//            set.add('a');
//        if (str.contains("e"))
//            set.add('e');
//        if (str.contains("i"))
//            set.add('i');
//        if (str.contains("o"))
//            set.add('o');
//        if (str.contains("u"))
//            set.add('u');
//        return set.size();
//    }

//    public static int UniqueVowels(String str) {
//        int count = 0;
//        if(str.contains("a")) {
//            count++;
//        }
//        if(str.contains("e")) {
//            count++;
//        }
//        if(str.contains("i")) {
//            count++;
//        }
//        if(str.contains("o")) {
//            count++;
//        }
//        if(str.contains("u")) {
//            count++;
//        }
//        return count;
//    }

}
