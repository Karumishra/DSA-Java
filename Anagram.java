import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "SJU LOP";
        String s2 = "pol ujs";

        String str1 = s1.replaceAll("^[a-z][A-Z]", "").toLowerCase();
        String str2 = s2.replaceAll("^[a-z][A-Z]", "").toLowerCase();

        if (str1.length() != str2.length()) {
            System.out.println("Anagram : false");
        }

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        System.out.println("Anagram : " + Arrays.equals(array1, array2));
    }
}
