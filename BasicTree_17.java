import java.nio.channels.AsynchronousChannel;
import java.util.ArrayList;

class TreeNode{

    // each node has a data and a reference to the nodes children
    String data;
    ArrayList<TreeNode> children; // reference to it's children // children will also be of TreeNode type

    public TreeNode(String data){

        this.data = data;
        children = new ArrayList<>(); // instantiating array list
    }

    public void addChild(TreeNode node){
        
        children.add(node);
    }

    public String print(int level){

        String returnString;
        returnString = "   ".repeat(level)+data+"\n";

        for(TreeNode node: children){

            returnString += node.print(level+1);
        }
        return returnString;
    }
}

public class BasicTree_17 {
    
    public static void main(String[] args){

        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");

        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");

        TreeNode milkshake = new TreeNode("Milkshake");
        TreeNode coke = new TreeNode("Coke");
        

        drinks.addChild(hot);
        drinks.addChild(cold);

        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(milkshake);
        cold.addChild(coke);

        System.out.println(drinks.print(1));
    }
}
