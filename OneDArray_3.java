import java.util.Arrays;

class Operation{
    
    int[] arr1 = null;

    public Operation(int sizeOfArray){

        arr1 = new int[sizeOfArray];
        for(int i=0; i<sizeOfArray; i++){

            arr1[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int input){

        try{
            if(arr1[location] != Integer.MIN_VALUE){ // O(1)
                System.out.println("This cell is occupied. Try another cell..."); // O(1)
            }
            else{
                arr1[location] = input; // O(1)
                System.out.println("Element successfully added."); // O(1)
            }
        }
        catch(ArrayIndexOutOfBoundsException e){

            System.out.println("This index does not exist."); // O(1)
        }
    }
    // Therfore this insert method TC is: O(1)

    public void printArray(){

        for(int i=0; i<arr1.length; i++){ // traversing array to print values // TC: O(n)
            
            System.out.print(arr1[i] + " "); // TC: O(1)
        }

        System.out.println(); // TC: O(1)
        System.out.println(Arrays.toString(arr1)); // TC: O(1)
    } // Therefore for this traveral method TC: O(n)
      // SC: O(1), since no extra memory is required to perform operation

    public void linearSearch(int input){

        for(int i=0; i<arr1.length; i++){ // TC: O(n)
            if(arr1[i] == input){ // TC: O(1)
                System.out.println("'"+ input +"'" + " element is found at index " + i + " of array."); // TC: O(1)
                return; // TC: O(1)
            }
        }
        System.out.println("Element not found :("); // // TC: O(1)
    }
    // Therefore for this method TC: O(n)
    // SC: O(1), since no extra memory is required to perform operation

    // public void deleteElement(int input){

    //     for(int i=0; i<arr1.length; i++){
    //         if(arr1[i] == input){
    //             arr1[i] = Integer.MIN_VALUE;
    //             System.out.println("Element successfully deleted!");
    //             return;
    //         }
    //     }
    //     System.out.println("Element not found :(");
    // }

    public void deleteElement(int indexOfElement){

    }
}





public class OneDArray_3 {
    public static void main(String[] args){

        Operation obj1 = new Operation(5);
        
        obj1.insert(0,9);
        obj1.insert(1,8);
        obj1.insert(2,7);
        obj1.insert(2,6);
        obj1.insert(7,5);

        System.out.println();
        obj1.printArray();
        System.out.println();

        obj1.linearSearch(8);
        System.out.println();

        obj1.deleteElement(8);
        System.out.println();
        obj1.printArray();
        System.out.println();



    }
}