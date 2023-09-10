class Stack{

    SinglyLLOperations sLL;

    public Stack(){
        sLL = new SinglyLLOperations();
    }
    // TC: O(1) // SC: O(1)

    public void push(int value){
       
        sLL.insertion(0, value);
        System.out.printf("Inserted new element '%d' in stack.\n", value);
    } // TC: O(1) // SC: O(1)

    public boolean isEmpty(){
        
        if(sLL.head == null){
            return true;
        }
        else{
            return false;
        }
    }
    // TC: O(1) // SC: O(1)

    public void pop(){

        if(isEmpty()){

            System.out.println("The stack is empty.");
        }
        else{

            System.out.println(sLL.head.value);
            sLL.deletion(0);
        }
    }// TC: O(1) // SC: O(1)

    public void peek(){

        if(isEmpty()){

            System.out.println("The stack is empty.");
        }
        else{

            System.out.println(sLL.head.value);
        }
    }
    // TC: O(1) // SC: O(1)

    public void delete(){

        sLL.head = null;
        System.out.println("The stack has been deleted.");
    }
    // TC: O(1) // SC: O(1)
}


public class StackLL_12 {
    
    public static void main(String[] args){

        Stack newStack = new Stack();

        System.out.println(newStack.isEmpty());

        newStack.push(11);
        newStack.push(22);
        newStack.push(33);

        System.out.println(newStack.isEmpty());
        
        newStack.peek();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        System.out.println(newStack.isEmpty());
        newStack.pop();
        newStack.pop();
        newStack.pop();

        newStack.delete();
        
        
    }
}
