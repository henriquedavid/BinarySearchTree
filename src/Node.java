/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class Node<T> {
    // Left node of the node.
    Node<T> left;
    // Value of the node.
    T value;
    // Right node of the node.
    Node<T> right;
    // Number of nodes on the left;
    int numbLeft;
    // Number of nodes on the right;
    int numbRight;
    
    /**
     * Construct to make a null node.
     */
    public Node(){
        left = null;
        value = null;
        right = null;
        numbLeft = 0;
        numbRight = 0;
    }
    
    /**
     * Construct to make the node with infomations.
     * 
     * @param l Left node of the node.
     * @param v Value of the node.
     * @param r Right node of the node.
     */
    public Node( Node<T> l, T v , Node<T> r ){
        left = l;
        value = v;
        right = r;
        numbLeft = 0;
        numbRight = 0;
    }
    
    /**
     * Get the node of the left of it.
     * 
     * @return left node of the node.
     */
    public Node<T> getLeft(){
        return left;
    }
    
    /**
     * Set the left node of the node.
     * 
     * @param node Left node of the node.
     */
    public void setLeft( Node<T> node ){
        left = node;
    }
    
    /**
     * Get the value of the node.
     * 
     * @return value in that node.
     */
    public T getValue(){
        return value;
    }
    
    /**
     * Set the value on the node.
     * 
     * @param value new value to the node.
     */
    public void setValue( T value ){
        this.value = value;
    }
    
    /**
     * Get the node of the right of it.
     * 
     * @return right node of the node.
     */
    public Node<T> getRight(){
        return right;
    }
    
    /**
     * Set the right node of the node.
     * 
     * @param node right node of the node.
     */
    public void setRight( Node<T> node ){
        right = node;
    }

    /**
     * Return the number of nodes on the left.
     * 
     * @return number of nodes on the left.
     */
    public int getNumbLeft() {
        return numbLeft;
    }

    /**
     * Change the number of the nodes on the left.
     * 
     * @param numbLeft new number of nodes on the left.
     */
    public void setNumbLeft(int numbLeft) {
        this.numbLeft = numbLeft;
    }

    /**
     * Return the number of nodes on the right.
     * 
     * @return number of nodes on the right.
     */
    public int getNumbRight() {
        return numbRight;
    }

    /**
     * Change the number of the nodes on the right.
     * 
     * @param numbRight new number of nodes on the right.
     */
    public void setNumbRight(int numbRight) {
        this.numbRight = numbRight;
    }
    
    
}
