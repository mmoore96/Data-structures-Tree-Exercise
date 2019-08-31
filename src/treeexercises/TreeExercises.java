/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeexercises;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author mmoor
 */
public class TreeExercises{

    /**
     * @param args the command line arguments
     */
   public static void main(String args[])
    {
         String[] myStringsChars = new String[26];
        
        for(int i = 0; i < 26; i++)
        {
            myStringsChars[i] = new String(Character.toChars(i+65));
            //BTreePrinter.printNode(test1());
            System.out.println(myStringsChars[i]);
        }
 
        // create the Tree as a linked structure from the array myStringChars
        // the Strings are stored using the representation for trees as arrays in the book
        // (e.g. for an element i, the left child is stored in position 2*i + 1, right child is
        // on position 2*(i + 1). Also specify the level of a TreeNode
        ArrayList<TreeNode<String>> TreeArray = growTree(myStringsChars);
        TreeNode<String> root = TreeArray.get(0);
 
        // create a traversal by levels and print as you traverse to check that the creation of the tree has happened correctly
        
 
        // create the code that asks the user for two letters in uppercase and searches for the nodes in the tree that contain
        // such letters
        System.out.println("\nPlease enter the first letter in uppercase:");
        Scanner myScan1 = new Scanner(System.in);
        String letter1 = myScan1.nextLine();
        System.out.println("\nPlease enter the second letter in uppercase:");
        Scanner myScan2 = new Scanner(System.in);
        String letter2 = myScan2.nextLine();
 
        TreeNode<String> firstNode = root.findNodeOnTree(letter1);
        TreeNode<String> secondNode = root.findNodeOnTree(letter2);
 
        // create the code that calls the static method below and finds the lowest common ancestor of two TreeNodes
        TreeNode commonAncestor = findLowestCommonAncestor(firstNode, secondNode);
        if(commonAncestor != null)
        {System.out.println("Common Ancestor: " + commonAncestor.getContents());}
        
        
    }  
 
    public static ArrayList<TreeNode<String>> growTree(String[] seed)
    {
        ArrayList<TreeNode<String>> TreeArray = new ArrayList<>();
        for(String input: seed)
        {TreeArray.add(new TreeNode(input, null));}
 
        for(int i = 0; i <= TreeArray.size()-1; i++)
        {
            
            if(2*i+1<=TreeArray.size()-1 && TreeArray.get(2*i + 1) != null)
            {
                TreeArray.get(i).setLeftChild(TreeArray.get(2*i + 1));
                TreeArray.get(i).getLeftChild().setParent(TreeArray.get(i));
            }
            if(2*(i+1)<=TreeArray.size()-1 && TreeArray.get(2*(i+1)) != null)
            {
                TreeArray.get(i).setRightChild(TreeArray.get(2*(i+1)));
                TreeArray.get(i).getRightChild().setParent(TreeArray.get(i));
            }
 
            
            if(i==0)
            {TreeArray.get(i).setLevel(0);}
            if(i>=1 && i<=2)
            {TreeArray.get(i).setLevel(1);}
            if(i>=3 && i<=6)
            {TreeArray.get(i).setLevel(2);}
            if(i>=7 && i<=14)
            {TreeArray.get(i).setLevel(3);}
            if(i>=15 && i<=25)
            {TreeArray.get(i).setLevel(4);}
        }
        return TreeArray;
    }
 
    public static void display(ArrayList<TreeNode<String>> TreeArray)
    {
        for(TreeNode node: TreeArray)
        {System.out.print(node.getContents()+" ");}
    }
 
    public static int height(TreeNode root)
    {
        if (root == null)
            {return -1;}
        {return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));}        
    }
 
    
    public static TreeNode findLowestCommonAncestor(TreeNode node1, TreeNode node2)
    {
        // Given two nodes on the same tree, this method should return the lowest common ancestor.
        // if no common ancestor is found, this method returns null .
        int levelDif = node1.getLevel() - node2.getLevel();
        if(levelDif == 0)
        {
            if(node1.getParent() == node2.getParent() && node1 != node2)
            {return node1.getParent();}
            else if(node1 == node2)
            {return node1;}
            else
            {
                node1 = node1.getParent();
                node2 = node2.getParent();
                return findLowestCommonAncestor(node1, node2);
            }
        }
        if(levelDif > 0)
        {node1 = node1.getParent(); return findLowestCommonAncestor(node1, node2);}
        if(levelDif < 0)
        {node2 = node2.getParent(); return findLowestCommonAncestor(node1, node2);}
        return null;
    }
 
}
   