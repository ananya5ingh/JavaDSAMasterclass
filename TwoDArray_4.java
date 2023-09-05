import java.util.Arrays;

class Operations{

    int[][] arr1;
    public Operations(int rowSize, int colSize){

        arr1 = new int[2][2];
        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){

                arr1[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void insertElement(int rowLoc, int colLoc, int value){

        try{
            if(arr1[rowLoc][colLoc] == Integer.MIN_VALUE){ // TC: O(1)
                arr1[rowLoc][colLoc] = value; // TC: O(1)
                System.out.println("Element successfully inserted."); // TC: O(1)
            }
            else{
                System.out.println("This cell is occupied."); // TC: O(1)
            }
        }
        catch(ArrayIndexOutOfBoundsException e){

            System.out.println("This index is out of bounds."); // TC: O(1)
        }
    }
    // TC: O(1)
    // SC: O(1)

    public void accessElement(int row, int col){
        try{
            System.out.printf("Element in row %d and col %d is %d", row, col, arr1[row][col]); // TC: O(1)
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("This index is out of bounds."); // TC: O(1)
        }
    }
    // TC: O(1)
    // SC: O(1)  

    public void traverseArray(){
        System.out.println("Traversing array:"); // TC: O(1)

        for(int row=0; row<arr1.length; row++){ // TC: O(m)
            for(int col=0; col<arr1[0].length; col++){ // TC: O(n)

                System.out.print(arr1[row][col] + " "); // TC: O(1)
            }
            System.out.println(); // TC: O(1)
            // leave a line after each row iteration
        }
        // nested loop // TC: O(mn)
    }
    // TC: O(mn)
    // SC: O(1)

    
    public void linearSearch(int value){

        for(int row=0; row<arr1.length; row++){ // TC: O(m)
            for(int col=0; col<arr1[0].length; col++){ // TC: O(n)

                if(arr1[row][col] == value){ // TC: O(1)
                    System.out.printf("Element %d found at index [%d][%d]", value, row, col); // TC: O(1)
                    return; // TC: O(1)
                }
            }
        }
        System.out.println("Element not found."); // TC: O(1)
        // nested loop // TC: O(mn)
    }
    // TC: O(mn)
    // SC: O(1)

    public void deleteElement(int rowIndex, int colIndex){
        
        try{
            System.out.printf("Successfully deleted %d\n", arr1[rowIndex][colIndex]); // TC: O(1)
            arr1[rowIndex][colIndex] = Integer.MIN_VALUE; // TC: O(1)
        }
        catch(ArrayIndexOutOfBoundsException e){

            System.out.println("This index is out of bounds."); // TC: O(1)
        }
    }
    // TC: O(1)
    // SC: O(1)
}



public class TwoDArray_4 {
    
    public static void main(String[] args){

        Operations obj1 = new Operations(2,2);

        obj1.insertElement(0, 0, 11);
        obj1.insertElement(0, 1, 22);
        System.out.println(Arrays.deepToString(obj1.arr1));

        System.out.println();
        obj1.accessElement(0, 1);

        System.out.println(); // idk why it's not reading a single empth System.out.println :(
        System.out.println();
        obj1.traverseArray();

        System.out.println();
        obj1.linearSearch(44);

        System.out.println();
        obj1.deleteElement(0,0);
        System.out.println(Arrays.deepToString(obj1.arr1));

    }
}
