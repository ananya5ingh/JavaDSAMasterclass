class Node{

    public int value;
    public Node next;
}

class SinglyLLOperations{

    public Node head;
    public Node tail;
    public int size;

    public Node creation(int nodeValue){

        head = new Node(); // TC: O(1)
        Node node = new Node(); // TC: O(1)
        node.value = nodeValue; // TC: O(1)
        node.next = null; // TC: O(1)
        head = node; // TC: O(1)
        tail = node; // TC: O(1)
        return head; // TC: O(1)
    }
    // TC: O(1) // SC: O(1)

    public void insertion(int nodeValue, int location){

    }


    
}

public class SinglyLL_7{

    public static void main(String[] args){

        SinglyLLOperations sLL = new SinglyLLOperations();
        // System.out.println(sLL.creation(7));
        // ^ shows reference
        sLL.creation(7);
        System.out.println(sLL.head.value);


    }
}