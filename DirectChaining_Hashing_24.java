import java.util.ArrayList;
import java.util.LinkedList;


class DirectChaining{
    
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    DirectChaining(int size){

        hashTable = new LinkedList[size];
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

    public void insertHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if(hashTable[newIndex] == null){
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        }
        else{
            hashTable[newIndex].add(word);
        }
    }

    public void displayHashTable(){
        if(hashTable == null){
            System.out.println("\nHashTable does not exist.");
            return;
        }
        else{
            System.out.println("\n----------HashTable----------");
            for(int i=0; i<hashTable.length; i++){
                System.out.println("Index "+i+" key: "+ hashTable[i]);
            }
        }
    }

    public boolean searchHashTable(String word){

        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)
        ){

            System.out.println("\n"+"\"" + word + "\"" + " found in HashTable at location: "+newIndex);
            return true;
        }
        else{
            System.out.println("\n"+"\"" + word + "\"" + " not found in HashTable at location: "+newIndex);
            return false;
        }
    }
}

public class DirectChaining_Hashing_24{

    public static void main(String[] args){

        DirectChaining directChaining = new DirectChaining(13);

        directChaining.insertHashTable("The");
        directChaining.insertHashTable("quick");
        directChaining.insertHashTable("brown");
        directChaining.insertHashTable("fox");
        directChaining.insertHashTable("over");
        // directChaining.displayHashTable();
        directChaining.searchHashTable("fox");
    }
}
