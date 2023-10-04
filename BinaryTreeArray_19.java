class BinaryTree{

    String[] arr;
    int lastUsedIndex; // needed to track which cell was last used,
                    // makes life easier when inserting a new node
    
    public BinaryTree(int size){
        arr = new String[size+1]; // since not using 1st cell
        lastUsedIndex = 0;
        System.out.println("Blank tree of size " +size+ " has been created.");
    }
    // TC: O(1) SC: O(n)

    // isFull method
    boolean isFull(){
        if(arr.length-1 == lastUsedIndex){
            return true;
        }
        else{
            return false;
        }
    } // TC: O(1) // SC: O(1)

    void insert(String value){
        if(!isFull()){
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println("The value of " +value+ " has been inserted.");
        }
        else{
            System.out.println("The BT is full.");
        }
    } // TC: O(1) // SC: O(1)

    public void preOrder(int index){
        
        if(index>lastUsedIndex){
            return;
        }
        System.out.print(arr[index]+ "  ");
        preOrder(index*2); // TC: O(n/2) // recursion
        preOrder((index*2)+1); // TC: O(n/2) // recursion
        
    } // TC: O(n) // SC: O(n) (stack space)

    public void inOrder(int index){
        
        if(index>lastUsedIndex){
            return;
        }
        inOrder(index*2); // TC: O(n/2) // recursion
        System.out.print(arr[index]+ "  ");
        inOrder((index*2)+1); // TC: O(n/2) // recursion
        
    } // TC: O(n) // SC: O(n)

    public void postOrder(int index){
        
        if(index>lastUsedIndex){
            return;
        }
        postOrder(index*2); // TC: O(n/2) // recursion
        postOrder((index*2)+1); // TC: O(n/2) // recursion
        System.out.print(arr[index]+ "  ");
    } // TC: O(n) // SC: O(n)

    public void levelOrder(){

        for(int i=1; i<= lastUsedIndex; i++){
            System.out.print(arr[i]+ "  ");
        }
    } // TC: O(n) // SC: O(1)

    public int search(String value){

        for(int i=1; i<= lastUsedIndex; i++){
            if(arr[i] == value){
                System.out.print("Value " +arr[i]+ " found at index "+ i+ "\n");
                return i;
            }            
        }
        System.out.println("Element not found.");
        return -1;
    } // TC: O(n) // SC: O(1)

    public void delete(String value){

        int location = search(value);
        if(location == -1){
            return;
        }
        else{
            arr[location] = arr[lastUsedIndex]; // arr[location] is the node we want to delete
            lastUsedIndex--;
            System.out.printf("Node %s successfully deleted.\n", value);
        }
        
    } // TC: O(n) // SC: O(1)

    public void deleteBT(){
        try{
            arr = null;
            System.out.println("Binary Tree has been successfully deleted.");
        }
        catch(Exception e){
            System.out.println("There was an error deleting the tree.");
        }
    } // TC: O(1) // SC: O(1)

}


public class BinaryTreeArray_19 {
    public static void main(String[] args){

        BinaryTree newBinaryTree = new BinaryTree(9);

        newBinaryTree.insert("N1");
        newBinaryTree.insert("N2");
        newBinaryTree.insert("N3");
        newBinaryTree.insert("N4");
        newBinaryTree.insert("N5");
        newBinaryTree.insert("N6");
        newBinaryTree.insert("N7");
        newBinaryTree.insert("N8");
        newBinaryTree.insert("N9");

        newBinaryTree.preOrder(1);
        System.out.println();

        newBinaryTree.inOrder(1);
        System.out.println();

        newBinaryTree.postOrder(1);
        System.out.println();

        newBinaryTree.levelOrder();
        System.out.println();

        newBinaryTree.search("N5");
        newBinaryTree.search("N55");

        newBinaryTree.delete("N4");

        newBinaryTree.levelOrder();
        System.out.println();

        newBinaryTree.deleteBT();

        
    }
}
