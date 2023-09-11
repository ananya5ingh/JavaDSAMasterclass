class Queue{

    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public Queue(int size){

        arr = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;
        System.out.println("Queue created with size of: "+size);
    }
    // TC: O(1) // SC: O(n)

    public boolean isFull(){

        if(topOfQueue == arr.length-1){
            return true;
        }
        else{
            return false;
        }
    }
    // TC: O(1) // SC: O(1)

    public boolean isEmpty(){

        if(beginningOfQueue == -1 | beginningOfQueue == arr.length){
            return true;
        }
        else{
            return false;
        }
    }
    // TC: O(1) // SC: O(1)

    public void enQueue(int value){

        if(isFull()){
            System.out.println("The queue is full.");
        }
        else if(isEmpty()){
            beginningOfQueue=0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted "+value+ " in queue.");
        }
        else{
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted "+value+ " in queue.");
        }
    }
    // TC: O(1) // SC: O(1)

    public void deQueue(){

        if(isEmpty()){
            System.out.println("The queue is empty.");
        }
        else{
            System.out.println(arr[beginningOfQueue]);
            beginningOfQueue++;
            if(beginningOfQueue>topOfQueue){
                beginningOfQueue=-1;
                topOfQueue=-1;
            }
        }
    }
    // TC: O(1) // SC: O(1)

     public void peek(){

        if(isEmpty()){
            System.out.println("The queue is empty.");
        }
        else{
            System.out.println(arr[beginningOfQueue]);
        }
    }
    // TC: O(1) // SC: O(1)

    public void delete(){
        arr = null;
        System.out.println("Queue successfully deleted.");
    }
    // TC: O(1) // SC: O(1)

}





public class QueueArray_13 {
    
    public static void main(String[] args){

        Queue newQueue = new Queue(4);

        System.out.println(newQueue.isFull());
        System.out.println(newQueue.isEmpty());

        newQueue.enQueue(11);
        newQueue.enQueue(22);
        newQueue.enQueue(33);
        newQueue.enQueue(44);
        newQueue.enQueue(55);

        newQueue.deQueue();
        newQueue.deQueue();
        newQueue.deQueue();
        newQueue.deQueue();
        newQueue.deQueue();
        System.out.println(newQueue.isEmpty()); 

        newQueue.delete();

    }
}
