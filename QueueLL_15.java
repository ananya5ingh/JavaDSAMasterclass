class Queue{

    SinglyLLOperations sLL;

    public Queue(){

        sLL = new SinglyLLOperations();
        System.out.println("Queue has been successfully created.");
    }
    // TC: O(1) // SC: O(1)

    public boolean isEmpty(){
        if(sLL.head == null){
            return true;
        }
        else{
            return false;
        }
    }
    // TC: O(1) // SC: O(1)

    public void enQueue(int value){

        sLL.insertion(sLL.size,value);
        System.out.println("Successfully inserted "+value+ " in the queue.");
    }
    // TC: O(1) // SC: O(1)

    public void deQueue(){

        if(isEmpty()){
            System.out.println("Queue is empty.");
        }
        else{

            System.out.println(sLL.head.value);
            sLL.deletion(0);
        }
    }
    // TC: O(1) // SC: O(1)

    public void peek(){

        if(isEmpty()){
            System.out.println("Queue is empty.");
        }
        else{

            System.out.println(sLL.head.value);
        }
    }
    // TC: O(1) // SC: O(1)

    public void deletion(){
        sLL.head = sLL.tail = null;
        System.out.println("Queue has been deleted successfully.");
    }
    // TC: O(1) // SC: O(1)
}



public class QueueLL_15 {
    
    public static void main(String[] args){

        Queue newQueue = new Queue();

        System.out.println(newQueue.isEmpty());

        newQueue.enQueue(11);
        newQueue.enQueue(22);
        newQueue.enQueue(33);

        System.out.println(newQueue.isEmpty());

        newQueue.deQueue();
        newQueue.deQueue();

        newQueue.peek();

        newQueue.deQueue();
        newQueue.deQueue();

        newQueue.deletion();


    }
}
