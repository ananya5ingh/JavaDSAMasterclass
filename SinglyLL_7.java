class Node{

    public int value;
    public Node next;
}

class SinglyLLOperations{

    public Node head; //= new Node();
    public Node tail; // = new Node();
    public int size;

    public Node creation(int nodeValue){

        Node node = new Node(); // TC: O(1)
        node.value = nodeValue; // TC: O(1)
        node.next = null; // TC: O(1)
        head = node; // TC: O(1)
        tail = node; // TC: O(s1)
        size = 1;
        return head; // TC: O(1)
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
        }// TC: O(1)
        else if(location >= size){

            node.next = null;
            tail.next = node;
            tail = node;
        }// TC: O(1)
        else{
            Node tempNode; //= new Node(); // TC: O(1)
            tempNode = head;
            int index = 0; // TC: O(1)
            while(index<location-1){ 
                tempNode = tempNode.next;
                index++;
            }// TC: O(n)

            // Node nextNode = tempNode.next; // TC: O(1)
            // tempNode.next = node; // TC: O(1)
            // node.next = nextNode; // TC: O(1)
            node.next = tempNode.next;
            tempNode.next = node;

        }
        size++; // TC: O(1)
    }
    // TC: O(n) // SC: O(1)

    public void traversal(){

        if(head == null){

            System.out.println("Single LL does not exist.");
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
            System.out.println("This SLL does not exist.\n");
            return;
        } // TC: O(1)
        else if(location == 0){
            
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
        } // TC: O(1)
        else if(location >= size){
            Node tempNode = head;
            for(int i=0; i<size-1; i++){ // loop until the node rigth before the last node
                tempNode = tempNode.next;
            }
            if(tempNode == head){ // if tempNode == head, it would mean head is the second to last therefore LL has only 1 element
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

    public void deleteSLL(){
        head = null;
        tail = null;
        System.out.println("LinkedList deleted.");
    }

}


public class SinglyLL_7{

    public static void main(String[] args){

        SinglyLLOperations sLL = new SinglyLLOperations();
        // System.out.println(sLL.creation(7));
        // ^ shows reference
        sLL.creation(7);
        System.out.println(sLL.head.value);

        sLL.insertion(0, 11);
        sLL.insertion(1, 22);
        sLL.insertion(2, 33);
        sLL.insertion(3, 44);

        sLL.traversal();

        // sLL.search(88);

        sLL.deletion(7);
        sLL.traversal();

        // sLL.deleteSLL();
        // sLL.traversal();

    }

}