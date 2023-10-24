import java.util.*;

class WeightedNode implements Comparable<WeightedNode> {
  public String name;
  public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
  public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
  public boolean isVisited = false;
  public WeightedNode parent;
  public int distance;
  public int index;

  public WeightedNode(String name, int index) {
    this.name = name;
    distance = Integer.MAX_VALUE;
    this.index = index;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int compareTo(WeightedNode o) {
    return this.distance - o.distance;
  }


}

class WeightedGraph {
  ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

  public WeightedGraph(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
  }

  public static void pathPrint(WeightedNode node) {
   if (node.parent  != null) {
     pathPrint(node.parent);
   }
   System.out.print(node.name + " ");
 }

  // Bellman Ford Algorithm
   void bellmanFord(WeightedNode sourceNode) {
     sourceNode.distance = 0;
     for (int i=0; i<nodeList.size(); i++) {
       for (WeightedNode currentNode : nodeList) {
         for (WeightedNode neighbor : currentNode.neighbors) {
           if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
             neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
             neighbor.parent = currentNode;
           }
         }
       }
     }
     System.out.println("Checking for Negative Cycle..");
     for (WeightedNode currentNode : nodeList) {
       for (WeightedNode neighbor : currentNode.neighbors ) {
         if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
             System.out.println("Negative cycle found: \n");
             System.out.println("Vertex name: " + neighbor.name);
             System.out.println("Old cost: " + neighbor.distance);
             int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
             System.out.println("new cost: " + newDistance);
             return;
           }
       }
     }
     System.out.println("Negative Cycle not found");

     for (WeightedNode nodeToCheck : nodeList) {
      System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
      pathPrint(nodeToCheck);
      System.out.println();
    }


   }

}





// public class BellmannFordAlgo_39 {
    
// }
