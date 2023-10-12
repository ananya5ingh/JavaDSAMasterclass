import java.util.HashMap;
import java.util.Map;

class TrieNode{

    Map<Character, TrieNode> children;
    boolean endOfString;

    public TrieNode(){
        children = new HashMap<>();
        endOfString = false;
    }
    // TC: O(1) // SC: O(10)
}

class Trie{

    private TrieNode root;

    public Trie(){

        root = new TrieNode();
        System.out.println("The Trie has been created.");
    }

    public void insert(String word){

        TrieNode current = root;
        for(int i=0; i<word.length(); i++){

            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node; 
        }
        current.endOfString = true;
        System.out.println("Successfully inserted " + word+ " in Trie.");
    }
    // TC: O(M) // SC: O(M)

    public boolean search(String word){

        TrieNode currentNode = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if(node == null){
                System.out.println("Word: "+word+ " does not exist in Trie.");
                return false;
            }
            currentNode = node;
        }
        if(currentNode.endOfString == true){
            System.out.println("Word: "+word+ " exists in Trie.");
            return true;
        }
        else{
            System.out.println("Word: "+word+ " does not exist in Trie. But is a prefix of another string.");
        }
        return currentNode.endOfString;
    }
    // TC: O(M) // SC: O(1)

    private boolean delete(TrieNode parentNode, String word, int index){

        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;

        if(currentNode.children.size() > 1){
            delete(currentNode, word, index+1);
            return false;
        }
        if(index == word.length() -1){
            if(currentNode.children.size() >- 1){
                currentNode.endOfString = false;
                return false;
            }
            else{
                parentNode.children.remove(ch);
                return true;
            }
        }
        if(currentNode.endOfString == true){
            delete(currentNode, word, index+1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if(canThisNodeBeDeleted == true){
            parentNode.children.remove(ch);
            return true;
        }
        else{
            return false;
        }
    }

    public void delete(String word){
        if(search(word) == true){
            delete(root, word, 0);
        }
    }
}



public class Trie_23 {
    
    public static void main(String[] args){
         
        Trie newTrie = new Trie();

        newTrie.insert("API");
        newTrie.insert("APIS");
        // newTrie.search("APIS");
        // newTrie.search("API");
        // newTrie.search("AP");

        newTrie.search("APIS");
        newTrie.delete("APIS");
        newTrie.search("APIS"); // wrong output! review code!
        
    }
}
