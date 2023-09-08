class Node{

    public int value;
    public Node next;
}

class CircularSingleLLOperations{
     
    public Node head = new Node();
    public Node tail = new Node();
    public int size;

    public Node creation(int nodeValue){

        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    // TC: O(1) // SC: O(1)

    public void insertion(int location, int nodeValue){

        Node node = new Node(); 
        node.value = nodeValue;
        // TC: O(1)

        if(head == null){
            creation(nodeValue);
            return;
        }// TC: O(1)
        else if(location == 0){

            node.next = head;
            head = node;
            tail.next = head;
        }// TC: O(1)
        else if(location >= size){

            tail.next = node;
            tail = node;
            node.next = head;
        }// TC: O(1)
        else{
            Node tempNode = new Node(); // TC: O(1)
            tempNode = head;
            int index = 0; // TC: O(1)
            while(index<location-1){ 
                tempNode = tempNode.next;
                index++;
            }// TC: O(n)

            Node nextNode = tempNode.next; // TC: O(1)
            tempNode.next = node; // TC: O(1)
            node.next = nextNode; // TC: O(1)

        }
        size++; // TC: O(1)
    }
    // TC: O(n) // SC: O(1)

    public void traversal(){

        if(head == null){

            System.out.println("CLL does not exist.");
        }// TC: O(1)
        else{
            Node tempNode = head; // TC: O(1)
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
            System.out.println("This CLL does not exist.\n");
            return;
        } // TC: O(1)
        else if(location == 0){
            
            head = head.next;
            tail.next = head;
            size--;
            if(size == 0){
                tail = null;
                head = null;

            }
        } // TC: O(1)
        else if(location >= size){
            Node tempNode = head;
            for(int i=0; i<size-1; i++){ // loop until the node right before the last node
                tempNode = tempNode.next;
            }
            if(tempNode == head){ // if tempNode == head, it would mean head is the second to last therefore LL has only 1 element

                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } // TC: O(n)
        else{
            Node tempNode = head;
            for(int i=0; i<location-1;i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        } // TC: O(n) 
    }
    // TC: O(n) // SC: O(1)

    public void deleteCLL(){
        if(head == null){
            System.out.println("CLL does not exist.");
        }
        else{
            tail.next = null;
            head = null;
            tail = null;
            System.out.println("LinkedList deleted.");
        }
    }
    // TC: O(1) // SC: O(1)

} 


public class CircularSingleLL_8 {
    
    public static void main(String[] args){

        CircularSingleLLOperations cLL = new CircularSingleLLOperations();

        cLL.creation(5);
        System.out.println(cLL.head.value);
        System.out.println(cLL.head.next.value);
        // ^ shows that it is a circular single LL 

        cLL.insertion(0, 11);
        cLL.insertion(1, 22);
        cLL.insertion(2, 33);
        cLL.insertion(3, 44);

        cLL.traversal();

        cLL.search(77);

        cLL.deletion(2);

        cLL.traversal();

        cLL.deleteCLL();

        cLL.traversal();
    }
    
}
