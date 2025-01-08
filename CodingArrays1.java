import java.util.*;

public class CodingArrays1 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,9,-1,1,2,0};
        int[] array2 = {1,8,5,3,0,6};
        int[] array3 = {1,0,2,1,4,6};
        int[] array4 = {2,1,2,0,1,0};
        int[] array5 = {-2,1,-9,0,7,-5,1};
        sum(array1);
        productExceptCurrent(array1);
        maxValue(array1);
        minValue(array1);
        secondMax(array1);
        removeDuplicate(array1);
        reverseArray(array2);
        rotateLeft(array1,3);
        rotateRight(array3, 2);
        Arrays.sort(array1);
        binarySearch(array1,2);
        sort012(array4);
        alternatePosNeg(array5);
    }

    public static void alternatePosNeg(int[] array5) {
        int size = array5.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int j : array5) {
            if (j >= 0)
                pos.add(j);
            else
                neg.add(j);
        }
        int p=0;
        int q=0;
        for(int i=0; i<size; i++)
        {
            if(i % 2 == 0) {
                array5[i] = pos.get(p++);
            }
            else
                array5[i] = neg.get(q++);
        }
        System.out.println(Arrays.toString(array5));

    }

    public static void sort012(int[] array1) {
        int size = array1.length;
        int count0=0;
        int count1=0;
        int count2=0;

        for(int i=0; i<size; i++)
        {
            if(array1[i]==0)
                count0++;
            else if (array1[i]==1) {
                count1++;
            }
            else
                count2++;
        }

        for(int p=0; p<count0; p++)
        {
            array1[p]=0;
        }
        for(int q=count0; q<count0+count1; q++)
        {
            array1[q]=1;
        }
        for (int r=count0+count1; r<size; r++)
        {
            array1[r]=2;
        }
        System.out.println(Arrays.toString(array1));

    }

    public static void sum(int[] array1) {
        int sum = 0;
        int size = array1.length;
        for(int i = 0; i < size; i++) {
            sum+=array1[i];
        }
        System.out.println("Sum :"+sum);
    }

    public static void productExceptCurrent(int[] array1)
    {
        int size = array1.length;
        int result[] = new int[size];

        for(int i=0; i<size; i++)
        {
            result[i]=1;
        }
        int left =1;
        for(int i=0; i<size; i++)
        {
            result[i]=left;
            left=left*array1[i];
        }
        int right=1;
        for(int i=size-1; i>=0; i--)
        {
            result[i]=result[i]*right;
            right=right*array1[i];
        }

        System.out.println(Arrays.toString(result));

    }

    public static void reverseArray(int[] array)
    {
        int temp;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void maxValue(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max)
                max = array[i];
        }
        System.out.println("Max : "+max);
    }

    public static void minValue(int array[]) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min)
                min = array[i];
        }
        System.out.println("Max : "+min);
    }

    public static void secondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                secondMax = max;
                max = array[i];
            }
            if(array[i] < max && array[i] > secondMax)
                secondMax = array[i];
        }
        System.out.println("Second Max :"+secondMax);
    }

    public static void removeDuplicate(int[] array) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int x:array) {
            if (map.containsKey(x))
                map.put(x, map.get(x)+1);
            else
                map.put(x,1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if(m.getValue() == 1)
                System.out.println(m.getKey());
        }
    }

    public static void rotateLeft(int[] array, int rotateBy) {
        int size = array.length -1;
        reverse(array, 0, rotateBy -1);
        reverse(array, rotateBy, size);
        reverse(array, 0, size);
        System.out.println(Arrays.toString(array));
    }

    public static void rotateRight(int[] array3, int rotateBy) {
        int size = array3.length - 1;
        reverse(array3, 0, size-rotateBy);
        reverse(array3, size-rotateBy + 1, size);
        reverse(array3, 0 , size);
        System.out.println(Arrays.toString(array3));
    }

    public static void reverse(int array[], int start, int end) {
        int temp;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void binarySearch(int[] array, int k) {
        int min = 0;
        int max = array.length - 1;
        int mid = (min+max) / 2;
        while (array[mid] != k) {
            if ( array[mid] > k )
                max--;
            if( array[mid] < k )
                min++;
            mid = (min+max) / 2;
        }
        if(array[mid] == k)
            System.out.println("Key found");
    }
}
