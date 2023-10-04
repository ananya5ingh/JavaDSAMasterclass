import java.util.LinkedList;
import java.util.Queue;

class BinaryNode{

    public int value;
    public int height; // height of the node
    public BinaryNode left;
    public BinaryNode right;
}

class BinarySearchTree{

    BinaryNode root;
    
    // creating a BST
    BinarySearchTree(){
        root = null;
    } // TC: O(1) // SC: O(1)

    // Insert method

    private BinaryNode insert(BinaryNode currentNode, int value){           // making method private since we're only going to call this method inside this class

        if(currentNode == null){ // base condition for our recursive call
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            //System.out.println("The value has been successfully inserted.");
            return newNode;
        }
        else if(value <= currentNode.value){
            currentNode.left = insert(currentNode.left, value); // TC: O(n/2) (only half the tree)
            return currentNode;
        }
        else{
            currentNode.right = insert(currentNode.right, value); // TC: O(n/2)
            return currentNode;
        }
    } // TC: O(log n) // SC: O(log n) (stack memeory - recursion)
    void insert(int value){
        root = insert(root, value);
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

    // Find successor | minimum of node
    public static BinaryNode successorOfNode(BinaryNode root){
        if(root.left == null){
            return root;
        } 
        else{
            return successorOfNode(root.left);
        }
    }

    // Delete node
    public BinaryNode deleteNode(BinaryNode root, int value){

        if(root == null){
            System.out.println("Value not found in BST.");
            return null;
        }
        if(value < root.value){
            root.left = deleteNode(root.left, value); // TC: O(N/2)
        }
        else if(value > root.value){
            root.right = deleteNode(root.right, value); // TC: O(N/2)
        }
        else{
            if(root.left != null & root.right != null){ // case 3: 2 children

                BinaryNode temp = root;
                BinaryNode successor = successorOfNode(temp.right); // TC: O(log n)
                root.value = successor.value;
                root.right = deleteNode(root.right, successor.value); // TC: O(N/2)
            }

            // case 2: one child
            else if(root.left != null){
                root = root.left;
            }
            else if(root.right != null){
                root = root.right;
            }
            else{ // case 1: leaf node
                root = null;
            }
        }
        return root;
    } // TC: O(log n) // SC: O(log n )

    // Delete BST
    public void deleteBST(){
        root = null;
        System.out.println("The BST has been successfully deleted.");
    } // TC: O(1) // SC: O(1)
}



public class BinarySearchTree_20 {
    
    public static void main(String[] args){

        BinarySearchTree newBST = new BinarySearchTree();
        
        newBST.insert(70);
        newBST.insert(50);
        newBST.insert(90);
        newBST.insert(30);
        newBST.insert(60);
        newBST.insert(80);
        newBST.insert(100);
        newBST.insert(20);
        newBST.insert(40);

       // newBST.root  = 70;
        newBST.preOrderTraversal(newBST.root);
        System.out.println();

        newBST.inOrderTraversal(newBST.root);
        System.out.println();

        newBST.postOrderTraversal(newBST.root);
        System.out.println();

        newBST.levelOrderTraversal();
        System.out.println();

        newBST.search(newBST.root, 40);
        newBST.search(newBST.root, 45);

        // newBST.deleteNode(newBST.root, 40);
        // newBST.levelOrderTraversal();
        // System.out.println();

        newBST.deleteNode(newBST.root, 90);
        newBST.levelOrderTraversal();
        System.out.println();

        newBST.deleteBST();
        newBST.levelOrderTraversal();
        System.out.println();
    }

    
}
