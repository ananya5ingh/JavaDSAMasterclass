public class BigO_1{

    // Time Complexities

    // O(1)
    /* 
    public static int squareOfNumbers(int n){

         return n*n;
    }
    // this method has only one operation, and no matter how big the input is, it will perform only 1 operation
    // therefore, time complexity of this method --> O(1)
    public static void main(String[] args){
        
        // System.out.println(squareOfNumbers(1));
        // System.out.println(squareOfNumbers(11));
        System.out.println(squareOfNumbers(1111));
    }
    */

    // O(n)
    /*
    public static void displayNumbers(int n){

        for(int i=1; i<=n; i++){
            
            System.out.println(i);
        }
    }
    // in this method, as elements increase, no. of operations increase
    // therefore, time complexity --> O(n)
    public static void main(String[] args){

        // displayNumbers(1); // performs 1 operation
        // displayNumbers(5); // perform 5 operations
        displayNumbers(10); // performs 10 operations
    }
    */

    // O(2n) = O(n) (Drop COnstants)
    /* 
    public static void displayNumbers(int n){

        for(int i=1; i<=n; i++){
            
            System.out.println(i);
        }// O(n)

        for(int j=1; j<=n; j++){
            System.out.println(j);
        }// O(n)
    }

    // n + n = 2n (add them up)
    // therefore, O(2n)
    // Drop COnstants, therfore simplified to O(n)
    // therfore, time complexity --> O(n)
    public static void main(String[] args){

        displayNumbers(7); 
    }
}
*/

    // O(n^2)

    public static void displayNumbers(int n){

        for(int i=1; i<=n; i++){

            for(int j=1; j<=n; j++){
                
                System.out.println(j);
            }
        }
    } //O(n*n) //nested - 3 nested for loops would mean O(n^3)

    public static void main(String[] args){

        displayNumbers(7); 
    }
}

