import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}



class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int MOD = 1000000007;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }


}

class FancyVisitor extends TreeVis {
    private int evenDepthSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {
  
    public static Tree solve() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] values = new int[n];
    for (int i = 0; i < n; i++) values[i] = sc.nextInt();

    Color[] colors = new Color[n];
    for (int i = 0; i < n; i++)
        colors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) 
   adj.add(new ArrayList<Integer>());
    for (int i = 0; i < n - 1; i++) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    return buildTree(0, -1, 0, values, colors, adj);
}
private static Tree buildTree(int node, int parent, int depth,
                              int[] values, Color[] colors,
                              ArrayList<ArrayList<Integer>> adj) {

    boolean isLeaf = true;
    TreeNode treeNode = new TreeNode(values[node], colors[node], depth);

    for (int child : adj.get(node)) {
        if (child != parent) {
            isLeaf = false;
            treeNode.addChild(buildTree(child, node, depth + 1, values, colors, adj));
        }
    }

    if (isLeaf) {
        return new TreeLeaf(values[node], colors[node], depth);
    }

    return treeNode;
}


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}