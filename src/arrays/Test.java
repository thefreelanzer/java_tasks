package arrays;

public class Test {
    public static void main(String[] arr) {
        /**
         * Single Dimensional array
         */
        int a[] = new int[5]; // create an array of integers

        //Creating and initialising an array
        int[] newArr = {100, 200, 300, 400, 500};

        //Add integer values to array
        a[0] = 1;
        a[1] = 11;
        a[2] = 111;
        a[3] = 1111;
        a[4] = 11111;

        for (int i = 0; i < 5; i++) {
            System.out.println("a[" + i + "] " + a[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("newArr[" + i + "] " + newArr[i]);
        }

        /**
         * Multidimensional array
         */
        int[][] mlArr = {
                {1, 2, 3},
                {4, 5, 6, 9},
                {7},
                {4, 5, 6, 9},
        };
        //Access individual element of array
        int val = mlArr[3][1];
        //print the element
        System.out.println("Accessed array value = " + val);
    }
}
