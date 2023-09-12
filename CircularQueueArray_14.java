class CircularQueueOperations{

    int[] arr;
    int beginning;
    int top;
    int size;
    
    public CircularQueueOperations(int size){

        arr = new int[size];
        this.size = size;
        beginning = -1;
        top = -1;
        System.out.println("The circular queue is successfully created with size of: "+size);
    }
    // TC: O(1) // SC: O(n)

    public boolean isEmpty(){

        if(top == -1){
            return true;
        }
        else{
            return false;
        }
    }
    // TC: O(1) // SC: O(1)

    public boolean isFull(){

        if(beginning == 0 & top+1 == size){// top == arr.length-1){
            return true;
        }
        else if(top+1 == beginning){
            return true;
        }
        else{
            return false;
        }
    }
    // TC: O(1) // SC: O(1)

    public void enQueue(int value){

        if(isFull()){
            System.out.println("CQ is full.");
            return;
        }
        else if(isEmpty()){

            beginning = 0;
            top = 0;
            arr[top] = value;
            System.out.printf("Successfully inserted %d in the CQ.\n", value);
        }
        else{
            if(top+1 == size){
                top=0;
            }
            else{
                top++;
            }
            arr[top] = value;
            System.out.printf("Successfully inserted %d in the CQ.\n", value);
        }
        // TC: O(1) // SC: O(1)
    }

    public void deQueue(){

        if(isEmpty()){
            System.out.println("CQ is empty.");
            return;
        }
        else{

            int result = arr[beginning];
            arr[beginning] = Integer.MIN_VALUE;

            if(beginning == top){ // only one element

                beginning = top = -1;
            }
            else if(beginning+1 == size){ // beginning points to last cell of the array

                beginning = 0;
            }
            else{
                beginning++;
            }
            System.out.println(result);
        }
    }
    // TC: O(1) // SC: O(1)

    public void peek(){

        if(isEmpty()){
            System.out.println("CQ is empty.");
            return;
        }
        else{
            System.out.println(arr[beginning]);
        }
    }
    // TC: O(1) // SC: O(1)

    public void deleteQueue(){
        arr = null;
        System.out.println("Circular Queue has been successfully deleted.");
    }
    // TC: O(1) // SC: O(1)
    
}


public class CircularQueueArray_14 {

    public static void main(String[] args){

        CircularQueueOperations newCQ = new CircularQueueOperations(3);

        System.out.println(newCQ.isEmpty());

        System.out.println(newCQ.isFull());

        newCQ.enQueue(11);
        newCQ.enQueue(22);
        newCQ.enQueue(33);
        newCQ.enQueue(44);

        //newCQ.deQueue();
        newCQ.peek();

        newCQ.deleteQueue();

    }
}
