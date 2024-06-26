import java.util.Arrays;

public class Arrays_2 {
    
    public static void main(String[] args){

        System.out.println("One Dimensional Array: ");

        int[] arr1; // declaration - arr1 is the name of reference variable || TC: O(1)
        arr1 = new int[3]; // instantiation || TC: O(1)

        //System.out.println(Arrays.toString(arr1));
        // by default values initialized to 0

        arr1[0] = 11; // TC: O(1)
        arr1[1] = 22; // TC: O(1)
        arr1[2] = 33; // TC: O(1)
        //              together TC: O(n)

         // cannot just directly print out an array

        //  System.out.println(arr1);
        /*  ^this does not work, output: [I@76ed5528 
        This output is not the actual content of the array, 
        but it's a reference to the array object in memory. 
        It's not very helpful if you want to see the numbers inside the array.
        */

        // we need .toString() method from Arrays library

        System.out.println(Arrays.toString(arr1)); // O(1)

        // Shortcut: All steps together - declaration, instantiation, initialization

        String arr2[] = {"a","b","c"}; // TC: O(1)
        System.out.println(Arrays.toString(arr2)); // TC: O(1)

        System.out.println();
        System.out.println("Two Dimensional Array: ");

        int[][] arr3 = new int[3][3]; // TC: O(1)
        arr3[0][0] = 1; // TC: O(1)
        arr3[0][1] = 2; // TC: O(1)
        arr3[0][2] = 3; // TC: O(1)
        arr3[1][0] = 4; // TC: O(1)
        arr3[1][1] = 5; // TC: O(1)
        arr3[1][2] = 6; // TC: O(1)
        arr3[2][0] = 7; // TC: O(1)
        arr3[2][1] = 8; // TC: O(1)
        arr3[2][2] = 9; // TC: O(1)
        // but all together, on combining, // TC: O(mn) - m--> rows, n-->columns
        // SC: O(mn)

        System.out.println(Arrays.deepToString(arr3));

        String[][] arr4 = {{"a","b","c"},{"d","e","f"},{"g","h","i"}}; // however, this method // TC: O(1) // SC: O(mn)

        System.out.println();
        System.out.println(Arrays.deepToString(arr4));



    }
}
