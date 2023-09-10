class Node{

    public int value;
    public Node next;
    public Node prev;
}

class DoublyLLOperations{

    public Node head;// = new Node();
    public Node tail;// = new Node();
    int size;

    public Node creation(int nodeValue){

        Node node = new Node(); 
        node.value = nodeValue;
        node.next = null;
        node.prev = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    // TC: O(1) // SC: O(1)

    public void insertion(int location, int nodeValue){

        Node node = new Node();
        node.value = nodeValue;

        if(head == null){
            creation(nodeValue);
            return;
        }
        else if(location == 0){
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
        else if(location >= size){
            node.next = null;
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        else{

            Node tempNode;// = new Node();
            tempNode = head;

            for(int i=0; i<location-1; i++){
                tempNode = tempNode.next;
            }
            node.prev = tempNode;
            node.next = tempNode.next;
            tempNode.next = node;
            node.next.prev = node;
        }
        size++;
    }
    // TC: O(n) // SC: O(1)

    public void traversal(){

        if(head == null){
            System.out.println("DLL does not exist.");
        }// TC: O(1)
        else{
            Node tempNode;// = new Node();
            tempNode = head; // TC: O(1)
            for(int i=0; i<size; i++){ // TC: O(n)
                System.out.print(tempNode.value);
            if(i != size-1){ // TC: O(1)
                System.out.print(" --> ");
            }
            tempNode = tempNode.next; // TC: O(1)
            }
        }
        System.out.println();
    }
    // TC: O(n) // SC: O(1)

    public void reverseTraversal(){

        if(head == null){
            System.out.println("DLL does not exist.");
        }// TC: O(1)
        else{
            Node tempNode;// = new Node();
            tempNode = tail; // TC: O(1)
            for(int i=0; i<size; i++){ // TC: O(n)
                System.out.print(tempNode.value);
            if(i != size-1){ // TC: O(1)
                System.out.print(" <-- ");
            }
            tempNode = tempNode.prev; // TC: O(1)
            }
        }
        System.out.println();
    }
    // TC: O(n) // SC: O(1)

    public boolean search(int nodeValue){
        if(head != null){ // TC: O(1)

            Node tempNode = head; // TC: O(1)
            for(int i=0; i<size; i++){ // TC: O(n)
                if(tempNode.value == nodeValue){ // TC: O(1)
                    System.out.printf("Element found at location %d\n",i);
                    return true;
                }
                tempNode = tempNode.next; // TC: O(1)
            }
        }
        System.out.println("Element not found.");
        return false;
    }
    // TC: O(n) // TC: O(1)

   public void deletion(int location){
        if(head == null){
            System.out.println("This DLL does not exist.\n");
            return;
        } // TC: O(1)
        else if(location == 0){
            
            head = head.next;
            head.prev = null;
            size--;
            if(size == 1){
                tail = null;
                size--;
            }
        } // TC: O(1)
        else if(location >= size){
            Node tempNode = tail.prev;
            if(tempNode == head){ // if tempNode == head, it would mean head is the second to last therefore LL has only 1 element
                tail = head = null; 
                size--;
                return;
            }
            else{
                tempNode.next = null;
                tail = tempNode;
                size--;
            }
        } // TC: O(n)
        else{
            Node tempNode = head;
            for(int i=0; i<location-1;i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        } // TC: O(n)
        
    }
    // TC: O(n) // SC: O(1)

    public void deleteDLL(){
        
        Node tempNode;// = new Node();
        tempNode = head;
        for(int i=0; i<size; i++){
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("LinkedList deleted.");
    }
    // TC: O(n) // SC: O(1)

}

public class DoublyLL_9 {
    
    public static void main(String[] args){

        DoublyLLOperations dLL = new DoublyLLOperations();

        dLL.creation(4);
        System.out.println(dLL.head.value);

        dLL.insertion(0, 44);
        dLL.insertion(1, 55);
        dLL.insertion(2, 66);
        dLL.insertion(3, 77);

        System.out.println(dLL.head.value);

        dLL.traversal();
        
        dLL.reverseTraversal();

        dLL.search(66);

        dLL.deletion(1);

        dLL.traversal();

        dLL. deleteDLL();

        dLL.traversal();
        
    }
}
