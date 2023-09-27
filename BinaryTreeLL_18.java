import java.util.LinkedList;
import java.util.Queue;

class BinaryNode{

    public String value;
    public BinaryNode left;
    public BinaryNode right;
    public int height; // useful to implement other methods
}

class BinaryTreeLLOperations{
    BinaryNode root; // declaring the root node

    public BinaryTreeLLOperations(){

        root = null; // initializing it to null 
    }
    // TC: O(1) // SC: O(1 )

    public void preOrderTraversal(BinaryNode node){

        if(node == null){ // base case for recursion; stop after reaching deepest node
            return;
        } // TC: O(1)
        System.out.print(node.value + "  "); // TC: O(1)
        // using recursion to visit all nodes in the LST and RST in preOrder
        preOrderTraversal(node.left); // TC: O(n/2)
        preOrderTraversal(node.right); // TC: O(n/2)
        
    }
    // TC: O(n) // SC: O(n) (stack memory is used with each recursive call)

    public void inOrderTraversal(BinaryNode node){

        if(node == null){ // base case for recursion; stop after reaching deepest node
            return;
        } // TC: O(1)

        inOrderTraversal(node.left); // TC: O(n/2)
        System.out.print(node.value + "  "); // TC: O(1)
        inOrderTraversal(node.right); // TC: O(n/2)
    }
    // TC: O(n) // SC: O(n) (stack memory is used with each recursive call)

    public void postOrderTraversal(BinaryNode node){

        if(node == null){ // base case for recursion; stop after reaching deepest node
            return;
        } // TC: O(1)

        postOrderTraversal(node.left); // TC: O(n/2)
        postOrderTraversal(node.right); // TC: O(n/2)
        System.out.print(node.value + "  "); // TC: O(1)
    }
    // TC: O(n) // SC: O(n) (stack memory is used with each recursive call)

    public void levelOrderTraversal(){

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        // ^creating queue using LL

        queue.add(root);
        // ^inserting root node as first node

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove(); // creating a node (presentNode) to save the first value of the queue
            System.out.print(presentNode.value + "  ");
            // in level oreder traversal we visit nodes of each level from left to right
            if(presentNode.left != null){ // if presentNode has a left child

                queue.add(presentNode.left); // adding left child to queue
            }
            if(presentNode.right != null){ // if presentNode has a left child

                queue.add(presentNode.right); // adding left child to queue
            } 

        }
    }
    // TC: O(n) // SC: O(n)

    public void binaryTreeSearch(String valueToFind){

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        // ^creating queue using LL

        queue.add(root);
        // ^inserting root node as first node

        while(!queue.isEmpty()){

            BinaryNode presentNode = queue.remove(); // creating a node (presentNode) to save the first value of the queue
            if(presentNode.value == valueToFind){
                System.out.print(presentNode.value + " node found in BT");
                return;
            }
            
            // in level oreder traversal we visit nodes of each level from left to right
            if(presentNode.left != null){ // if presentNode has a left child

                queue.add(presentNode.left); // adding left child to queue
            }
            if(presentNode.right != null){ // if presentNode has a left child

                queue.add(presentNode.right); // adding left child to queue
            }
        }

        System.out.print(valueToFind + " node NOT found in BT\n");
    }
    // TC: O(n) // SC: O(n)

    public void insertBinaryNode(String valueToInsert){

        BinaryNode newNode = new BinaryNode();
        newNode.value = valueToInsert;

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        // ^creating queue using LL

        if(root == null){
            root = newNode;
            System.out.println(valueToInsert+ " successfully inserted.\n");
            return;
        }
        else{
            queue.add(root);
        // ^inserting root node as first node

            while(!queue.isEmpty()){
                BinaryNode presentNode = queue.remove(); // creating a node (presentNode) to save the first value of the queue

                // in level oreder traversal we visit nodes of each level from left to right
                if(presentNode.left == null){ // if presentNode has a left child

                    presentNode.left = newNode;
                    System.out.println(valueToInsert+ " successfully inserted.\n");
                    return;
                }
                if(presentNode.right == null){ // if presentNode has a left child

                    presentNode.right = newNode;
                    System.out.println(valueToInsert+ " successfully inserted.\n");
                    return;
                } 

            }
        }
    }
        
}

public class BinaryTreeLL_18 {
     
    public static void main(String[] args){
        
        BinaryTreeLLOperations binaryTree = new BinaryTreeLLOperations();
        // ^ just doing this successfully creates a binary tree without any nodes in it

        BinaryNode n1 = new BinaryNode();
        n1.value = "N1";
        BinaryNode n2 = new BinaryNode();
        n2.value = "N2";
        BinaryNode n3 = new BinaryNode();
        n3.value = "N3";
        BinaryNode n4 = new BinaryNode();
        n4.value = "N4";
        BinaryNode n5 = new BinaryNode();
        n5.value = "N5";
        BinaryNode n6 = new BinaryNode();
        n6.value = "N6";
        BinaryNode n7 = new BinaryNode();
        n7.value = "N7";
        BinaryNode n8 = new BinaryNode();
        n8.value = "N8";
        BinaryNode n9 = new BinaryNode();
        n9.value = "N9";

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        binaryTree.root = n1;

        System.out.print("Pre Order Traversal: ");
        binaryTree.preOrderTraversal(binaryTree.root);
        System.out.println("\n");

        System.out.print("In Order Traversal: ");
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println("\n");

        System.out.print("Post Order Traversal: ");
        binaryTree.postOrderTraversal(binaryTree.root);
        System.out.println("\n");

        System.out.print("Level Order Traversal: ");
        binaryTree.levelOrderTraversal();
        System.out.println("\n");

        binaryTree.binaryTreeSearch("N10");

        binaryTree.insertBinaryNode("N10");

        System.out.print("Level Order Traversal: ");
        binaryTree.levelOrderTraversal();
        System.out.println("\n");

        binaryTree.binaryTreeSearch("N10");
    }
}
