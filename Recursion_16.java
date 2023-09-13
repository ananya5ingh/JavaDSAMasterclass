class RecursionExamples{

    public void openRussianDoll(int doll){

        if(doll == 1)/*base case*/{
            System.out.println("All dolls are opened.");
        }
        else{
            System.out.println("Doll "+ doll+" opened.");
            openRussianDoll(doll-1);
        }
    }

    public void recursiveMethod(int n){

        if(n<1){
            System.out.println("n is less than one.");
        }
        else{
            recursiveMethod(n-1);
            System.out.println(n);
        }
    }

    public int factorial(int n){

        if(n<1){
            return -1;
        }
        if(n==0 | n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public int fibonacci(int n){

        if(n<0){
            return -1;
        }
        if(n == 0 | n == 1){
            return n; // fibonacci of 0 is 0 and fibonacci of 1 is 1
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}


public class Recursion_16 {

    public static void main(String[] args){

        RecursionExamples obj1 = new RecursionExamples();

        obj1.openRussianDoll(4);
        System.out.println();

        obj1.recursiveMethod(4);
        System.out.println();

        int result = obj1.factorial(-5);
        System.out.println(result);
        System.out.println();


        

    }
}
