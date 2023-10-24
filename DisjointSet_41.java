import java.util.*;

class WeightedNode implements Comparable<WeightedNode> {
  public String name;
  public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
  public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
  public boolean isVisited = false;
  public WeightedNode parent;
  public int distance;
  public int index;
  public DisjointSet set;


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

class DisjointSet {

	private ArrayList<WeightedNode> nodeList = new ArrayList<>();

  public static void makeSet(ArrayList<WeightedNode> nodeList) {
    for (WeightedNode node : nodeList) {
      DisjointSet set = new DisjointSet();
      set.nodeList.add(node);
      node.set = set;
    }
  }

  public static DisjointSet findSet(WeightedNode node) {
    return node.set;
  }

  public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
    if (node1.set.equals(node2.set)) {
      return null;
    } else {
      DisjointSet set1 = node1.set;
      DisjointSet set2 = node2.set;

      if (set1.nodeList.size()>set2.nodeList.size()) {
        ArrayList<WeightedNode> nodeSet2 = set2.nodeList;
        for (WeightedNode node: nodeSet2) {
          node.set = set1;
          set1.nodeList.add(node);
        }
        return set1;
      } else {
        ArrayList<WeightedNode> nodeSet1 = set1.nodeList;
        for (WeightedNode node : nodeSet1) {
          node.set = set2;
          set2.nodeList.add(node);
        }
        return set2;
      }
    }
  }

  public void printAllNodesofThisSet() {
    System.out.println("Printing all nodes of the set: ");
    for (WeightedNode node : nodeList ) {
      System.out.print(node + " ");
    }
    System.out.println();
  }



}


public class DisjointSet_41 {
    
}
