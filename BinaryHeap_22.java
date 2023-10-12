class BinaryHeap{

    int[] arr;
    int sizeOfTree;

    public BinaryHeap(int size){
        
        arr = new int[size+1];
        sizeOfTree = 0;
        System.out.println("Binary Heap has been created. ");
    }
    // TC: O(1) // SC: O(n)

    public boolean isEmpty(){

        if(sizeOfTree == 0){
            return true;
        }
        else{
            return false;
        }
    }// TC: O(1) // SC: O(1)

    public int peek(){

        if(isEmpty()){
            System.out.println("Binary Heap is Empty.");
            return 0;
        }
        return arr[1];
    } // TC: O(1) // SC: O(1)

    public int sizeOfBP(){
        return sizeOfTree;
    } // TC: O(1) // SC: O(1)

    public void preOrder(int index){
        
        if(index>sizeOfTree){
            return;
        }
        System.out.print(arr[index]+ "  ");
        preOrder(index*2); // TC: O(n/2) // recursion
        preOrder((index*2)+1); // TC: O(n/2) // recursion
        
    } // TC: O(n) // SC: O(n) (stack space)

    public void inOrder(int index){
        
        if(index>sizeOfTree){
            return;
        }
        inOrder(index*2); // TC: O(n/2) // recursion
        System.out.print(arr[index]+ "  ");
        inOrder((index*2)+1); // TC: O(n/2) // recursion
        
    } // TC: O(n) // SC: O(n)

    public void postOrder(int index){
        
        if(index>sizeOfTree){
            return;
        }
        postOrder(index*2); // TC: O(n/2) // recursion
        postOrder((index*2)+1); // TC: O(n/2) // recursion
        System.out.print(arr[index]+ "  ");
    } // TC: O(n) // SC: O(n)

    public void levelOrder(){

        for(int i=1; i<= sizeOfTree; i++){
            System.out.print(arr[i]+ "  ");
        }
        System.out.println();
    } // TC: O(n) // SC: O(1)

    // heapify method for insertion - calling heapify for bottom to top
    // i.e, checking from bottom to top to see if property is maintained

    public void heapifyBottomToTop(int index, String heapType){

        int parent = index/2;
        if(index <= 1){
            return;
        }
        if(heapType == "Min"){

            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        else if(heapType == "Max"){

            if(arr[index] > arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBottomToTop(parent, heapType);
        // calling heapify recursively to check condition for all nodes
    }
    // TC: O(log n) // SC: O(log n)

    public void insert(int value, String heapType){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println("Inserted "+value+" successfully in heap.");
    }
    // TC: O(log n) // SC: O(log n)

    // heapify - top to bottom - useful for implementing extraction
    public void heapifyTopToBottom(int index, String heapType){

        int left = index*2;
        int right = index*2 + 1;
        int swapChild = 0;

        if(sizeOfTree<left){ // no child
            return;
        }
        if(heapType == "Max"){

            if(sizeOfTree == left){

                if(arr[index] < arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            else{
            if(arr[left] > arr[right]){
                swapChild = left;
            }
            else{
                swapChild = right;
            }
            if(arr[index] < arr[swapChild]){
                
                int temp = arr[index];
                arr[index] = arr[swapChild];
                arr[swapChild] = temp;
            }
        }
        }
        else if(heapType == "Min"){
            if(sizeOfTree == left){

                if(arr[index] > arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            else{
            if(arr[left] < arr[right]){
                swapChild = left;
            }
            else{
                swapChild = right;
            }
            if(arr[index] > arr[swapChild]){
                
                int temp = arr[index];
                arr[index] = arr[swapChild];
                arr[swapChild] = temp;
            }
        }
        }
        heapifyTopToBottom(swapChild, heapType);
    }
    // TC: O(log n) // SC: O(log n)

    public int extractHeadOfBH(String heapType){
        if(isEmpty()){
            return -1;
        }
        else{
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }
    // TC: O(log n) // SC: O(log n)

    public void deleteBH(){
        arr = null;
        System.out.println("Binary Heap has been successfully deleted.");
    }
    // TC: O(1) // SC: O(1)


}

public class BinaryHeap_22 {

    public static void main(String[] args){

        BinaryHeap newBH = new BinaryHeap(5);

        // newBH.peek();
        // newBH.insert(10, "Min");
        // newBH.insert(5, "Min");
        // newBH.insert(15, "Min");
        // newBH.insert(1, "Min");
        // newBH.levelOrder();

        newBH.insert(10, "Max");
        newBH.insert(5, "Max");
        newBH.insert(15, "Max");
        newBH.insert(1, "Max");
        newBH.levelOrder();

        newBH.extractHeadOfBH("Max");
        newBH.levelOrder();

        newBH.deleteBH();
    }
}
