class Stack{
    
    int[] arr;
    int topOfStack;

    public Stack(int size){
        
        arr = new int[size];
        topOfStack = -1; // since stack is empty
        System.out.printf("The stack is created with size of: %d \n", size);
    } // TC: O(1) // SC: O(n)

    public boolean isEmpty(){

        if(topOfStack == -1){
            return true;
        }
        else{
            return false;
        }
    } // TC: O(1) // SC: O(1)

    public boolean isFull(){

        if(topOfStack == arr.length-1){
            return true;
        }
        else{
            return false; 
        }
    } // TC: O(1) // SC: O(1) 

    public void push(int value){

        if(isFull()){
            System.out.println("Stack is full.");;
        }
        else{
            arr[topOfStack+1] = value;
            topOfStack++;
            System.out.printf("%d has been inserted successfully.\n", value);
        }
        // TC: O(1) // SC: O(1)
    }

    public void pop(){

        if(isEmpty()){
            System.out.println("Stack is empty.\n");
        }
        else{
            int topStack = arr[topOfStack];
            topOfStack--;
            System.out.println(topStack);
        }
    }
    // TC: O(1) // SC: O(1)

    public void peek(){

        if(isEmpty()){
            System.out.println("Stack is empty.\n");
        }
        else{
            System.out.println(arr[topOfStack]);
        }
    }
    // TC: O(1) // SC: O(1)

    public void delete(){
        arr = null;
        System.out.println("Stack has been successfully deleted.");
    }
    // TC: O(1) // SC: O(1)
}

public class StackArray_11 {
    
    public static void main(String[] args){

        Stack stk1 = new Stack(4);
        
        System.out.println(stk1.isEmpty());

        System.out.println(stk1.isFull());

        stk1.push(11);
        stk1.push(22);
        stk1.push(33);
        stk1.push(44);
        stk1.push(55);

        stk1.pop();
        stk1.pop();
        // stk1.pop();
        // stk1.pop();
        // stk1.pop();
 
        stk1.peek();

        stk1.delete();
    }
}
