
public class HeapSort_34 {

  int[] arr = null;

  public HeapSort_34(int[] arr) {
    this.arr = arr;
  }

  public void sort() {
    BinaryHeap_35 bh = new BinaryHeap_35(arr.length);
    for (int i = 0 ; i < arr.length; i++) {
      bh.insertInHeap(arr[i]);
    }

    for(int i=0; i<arr.length; i++) {
      arr[i] = bh.extractHeadOfHeap();
    }


  }



	public void printArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
	}

}
