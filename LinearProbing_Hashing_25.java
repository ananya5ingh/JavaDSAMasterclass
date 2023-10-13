import java.util.ArrayList;

class LinearProbing{
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size){
        hashTable = new String(size);
        usedCellNumber = 0;
    }

    public int modASCIIHashFunction(String word, int M){

        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for(sum=0, i=0; i<word.length(); i++){
            sum = sum + ch[i];
        }
        return sum%M;
    }

    public double getLoadFactor(){
        double loadFactor = usedCellNumber * 1.0/hashTable.length; // as per documentation
        return loadFactor;
    }

    public void rehashKeys(String word){

        ArrayList<String> data = new ArrayList<String>();
        for(String s: hashTable){
            if(s != null){
                data.add(s);
            }
            data.add(word);
            hashTable = new String[hashTable.length*2];
            for(String s: data){
                insertInHashTable(s);
            }
        }
    } 

    public void insertInHashTable(String word){

        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashKeys(word);
        }
        else{
            int index = modASCIIHashFunction(word, hashTable.length);
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = i%index+hashTable.length;
            }
        }
    }


}



public class LinearProbing_Hashing_25 {
    
}
