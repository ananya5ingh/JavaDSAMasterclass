import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList_6 {
    
    public static void main(String[] args){

        ArrayList<Integer> arrList1 = new ArrayList<>(Arrays.asList(1,2,3,55,66)); 
        // TC: O(1), SC: O(n)

        arrList1.add(11); // TC: Amortized O(1) // SC: Amortized O(1)
        arrList1.add(22);
        arrList1.add(33);

        System.out.println(arrList1);

        arrList1.add(1,44); // TC: O(n) (since all subsequesnt elements shift to right) // SC: Amortized O(1)
        System.out.println(arrList1);

        
        // arrList1.add(10,44);
        // ^error
        // System.out.println(arrList1);
        
        ArrayList<String> strList = new ArrayList<>();

        strList.add("Ananya");
        strList.add("Singh");

        System.out.println(strList);

        // Accessing Elements
        System.out.println(arrList1.get(1)); // TC: O(1) // SC: O(1)
        System.out.println(arrList1.get(2));
        System.out.println(arrList1.get(3));

        // Traversal

        // Approach 1:
        // for(int i=0; i<arrList1.size(); i++){

        //     int num = arrList1.get(i);
        //     System.out.println(num);
        // } // TC: O(N) // SC: O(1)

        // Approach 2:
        // for(int num: arrList1){
        //     System.out.println(num);
        // } // TC: O(N) // SC: O(1)

        // Approach 3: (Using Iterator interface)

        Iterator<Integer> iterator1 = arrList1.iterator(); 
        while(iterator1.hasNext()){ 

            int num = iterator1.next();
            System.out.println(num);
        } // TC: O(n) // SC: O(1)

        // Searching using indexOf()

        int index = arrList1.indexOf(66); // TC: O(n) // SC: O(1)
        System.out.println();
        System.out.println(index);

        // Deleting an Element
        System.out.println();
        arrList1.remove(0); // TC: O(n) // SC: O(1)
        System.out.println(arrList1);

        arrList1.remove(0);
        System.out.println(arrList1);

    }
}
