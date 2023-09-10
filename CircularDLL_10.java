class Node{

    public int value;
    public Node next;
    public Node prev;
}

class CircularDLLOperations{

    public Node head;// = new Node();
    public Node tail;// = new Node();
    public int size;

    public Node creation(int nodeValue){

        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        node.prev = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    } // TC: O(1) // SC: O(1)

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
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
        }// TC: O(1)
        else if(location >= size){

            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            tail = node;
        }// TC: O(1)
        else{
            Node tempNode;// = new Node(); // TC: O(1)
            tempNode = head;
            int index = 0; // TC: O(1)
            while(index<location-1){ 
                tempNode = tempNode.next;
                index++;
            }// TC: O(n)

            node.prev = tempNode;
            node.next = tempNode.next;
            tempNode.next = node;
            node.next.prev = node;
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

    public void reverseTraversal(){

        if(head == null){
            System.out.println("cdLL does not exist.");
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

    public void deleteNode(int location) {
    if (head == null) {
      System.out.println("The CDLL does not exist!");
      return;
    } else if (location == 0) {
      if (size == 1) {
        head.prev = null;
        head.next = null;
        head = tail = null;
        size--;
        return;
      } else {
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
      }
    } else if (location >= size) {
      if (size == 1) {
        head.prev = null;
        head.next = null;
        head = tail = null;
        size--;
        return;
      } else {
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
      }
    } else {
      Node tempNode = head;
      for (int i = 0; i < location -1; i++){
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      tempNode.next.prev = tempNode;
      size--;
    }
  } // TC: O(n) // SC: O(1)

  public void deleteCDLL() {
    Node tempNode = head;
    for (int i=0; i<size; i++) {
      tempNode.prev = null;
      tempNode = tempNode.next;
    }
    head = null;
    tail = null;
    System.out.println("The CDLL has been deleted!");
  } // TC: O(n) // SC: O(1)

}

public class CircularDLL_10 {
    public static void main(String[] args){

        CircularDLLOperations cdLL = new CircularDLLOperations();

        cdLL.creation(11);
        System.out.println(cdLL.head.value);

        cdLL.insertion(1, 22);
        cdLL.insertion(2, 33);
        cdLL.insertion(3, 44);
        cdLL.insertion(4, 55);
        System.out.println(cdLL.head.value);

        cdLL.traversal();

        cdLL.reverseTraversal();

        cdLL.search(22);

        cdLL.deleteNode(2);
        cdLL.traversal();

        cdLL.deleteCDLL();
        cdLL.traversal(); 

    }
}
