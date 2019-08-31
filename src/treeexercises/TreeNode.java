package treeexercises;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmoor
 */
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author csu
 * @param <T>
 */
public class TreeNode<T extends Comparable>{
    private T contents;
    private TreeNode<T> parent;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private int level;
    
    public TreeNode()
    {
    
    }
    
    
    public TreeNode(T data, TreeNode parent)
    {
        contents = data;
        this.parent = parent;
    }        
    
    public void setLeftChild(TreeNode node)
    {
        this.leftChild = node;
    }        
    
    public void setRightChild(TreeNode node)
    {
        this.rightChild = node;
    }        
    
    public boolean isContentEquals(T data)
    {
        return 0 == getContents().compareTo(data);
    }

    /**
     * @return the contents
     */
    public T getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(T contents) {
        this.contents = contents;
    }

    /**
     * @return the parent
     */
    public TreeNode getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * @return the leftChild
     */
    public TreeNode getLeftChild() {
        return leftChild;
    }

    /**
     * @return the rightChild
     */
    public TreeNode getRightChild() {
        return rightChild;
    }
     /**
     * Given an object T contentToSearch, this method returns
     * the node that stores the contentToShare or null if not found on the current tree
     * @return the node
     */
    public TreeNode findNodeOnTree(T contentToSearch)
    {
        List<TreeNode> nodes = new LinkedList();
        nodes.clear();
        nodes.add(this);
        
        while(!nodes.isEmpty())
        {
            TreeNode current = nodes.remove(0);
            if(current.isContentEquals(contentToSearch))
            {
                return current;
            }
            
            if(current.leftChild != null)
            {
                nodes.add(current.leftChild);
            }   
            
            if(current.rightChild != null)
            {
                nodes.add(current.rightChild);
            }    
        }
        
        return null;
    }        

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
