import java.util.LinkedList;
import java.util.Queue;

class BinaryNode{

    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;

    BinaryNode(){
        this.height = 0;
    }
    
}

class AVL{
    BinaryNode root;

    AVL(){
        root =  null;
    }

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

        if(root == null){
            System.out.println("This BT does not exist.");
            return;
        }

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

    BinaryNode search(BinaryNode node, int value){
        if(node == null){
            System.out.println("Value "+value+" not found in BST.");
            return null;
        }
        else if(node.value == value){
            System.out.println("Value "+value+" found in BST.");
            return node;
        }
        else if(value < node.value){
            return search(node.left, value); // TC: O(n/2) (recursion)
        }
        else{
            return search(node.right, value); // TC: O(n/2) (recursion)
        }
    } // TC: O(log n) // SC: O(log n)

    // getHeight - helper method
    public int getHeight(BinaryNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    // rotateRight

    private BinaryNode rotateRight(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        // adding 1 to count itself as well
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    } 
    // TC: O(1) // SC: O(1)

    // rotateLeft

    private BinaryNode rotateLeft(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        // adding 1 to count itself as well
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }
    // TC: O(1) // SC: O(1)

    // getBalance - to see whether node is balanced or not

    public int getBalance(BinaryNode node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    // TC: O(1) // SC: O(1)

    // insertNode 

    private BinaryNode insertNode(BinaryNode node, int nodeValue){

        if(node == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } // TC: O(1)
        else if(nodeValue < node.value){
            node.left = insertNode(node.left, nodeValue); // TC: O(log n)
        }
        else{
            node.right = insertNode(node.right, nodeValue); // TC: O(log n)
        }
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right)); // TC: O(1)
        int balance = getBalance(node); // TC: O(1)

        if(balance > 1 && nodeValue < node.left.value){ // LL condition
            return rotateRight(node);
        } // TC: O(1)

        if(balance > 1 && nodeValue > node.left.value){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } // TC: O(1)

        if(balance < -1 && nodeValue > node.right.value){
            return rotateLeft(node);
        } // TC: O(1)

        if(balance < -1 && nodeValue < node.right.value){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        } // TC: O(1)
        
        return node;
    } 
    // TC: O(log n) // SC: O(log n)
     

    public void insert(int value){
        root = insertNode(root, value);
    }

    // finding successor - helper method
  public static BinaryNode minimumNode(BinaryNode root) {
    if (root.left == null) {
      return root;
    } else {
      return minimumNode(root.left);
    }
  } // TC: O(log n) // SC: O(log n)

  // Delete node
 public BinaryNode deleteNode(BinaryNode node, int value) {
   if (node == null) {
     System.out.println("Value not found in AVL");
     return node;
   }
   if (value < node.value) {
     node.left = deleteNode(node.left, value);
   } else if (value > node.value) {
     node.right = deleteNode(node.right, value);
   } else {
     if (node.left != null && node.right != null) {
       BinaryNode temp = node;
       BinaryNode minNodeForRight = minimumNode(temp.right);
       node.value = minNodeForRight.value;
       node.right = deleteNode(node.right, minNodeForRight.value);
     } else if (node.left != null) {
       node = node.left;
     } else if (node.right != null) {
       node = node.right;
     } else {
       node = null;
     }
   }
   // Case 2 - rotation required

   // System.out.println("1");
   // System.out.println(previous.value);

   // node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
   int balance = getBalance(node);

   if (balance > 1 && getBalance(node.left) >= 0) {
     return rotateRight(node);
   }
   if (balance > 1 && getBalance(node.left) < 0) {
     node.left = rotateLeft(node.left);
     return rotateRight(node);
   }
   if (balance < -1 && getBalance(node.right) <= 0) {
     return rotateLeft(node);
   }

   if (balance < -1 && getBalance(node.right) > 0) {
     node.right = rotateRight(node.right);
     return rotateLeft(node);
   }

   return node;

 } // TC: O(log n) // SC: O(log n)

 public void delete(int value) {
   root = deleteNode(root, value);
 }

 public void deleteAVLTree(){
    root = null;
    System.out.println("\nAVL has been successfully deleted.");
 } 
//  TC: O(1) // SC: O(1)
}

public class AVLTree_21 {
    
    public static void main(String[] args){

        AVL newAVL = new AVL();
        newAVL.insert(5);
        newAVL.insert(10);
        newAVL.insert(15);
        newAVL.insert(20);
        newAVL.levelOrderTraversal();

        // o/p for:
        // normal BST: 5 10 15 20
        // AVL Tree: 10 5 15 20

        newAVL.delete(5);
        System.out.println();
        newAVL.levelOrderTraversal();

        newAVL.deleteAVLTree();
        



    }
}
