/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class BinarySearchTree<T> {
    
    Node<T> root;
    
    public BinarySearchTree(){
        root = null;
    }

    public Node<T> getRaiz() {
        return root;
    }

    public void setRaiz(Node<T> raiz) {
        this.root = raiz;
    }
    
    public int buscar( Node<T> root, T value, int f ){
        return f;
    }
    
    public void inserir( T value, Node<T> root, int f ){
        // Insert a new node.
    }
    
    public void remove( T value, Node<T> root ){
        // Remove a node.
    }
    
    public T enesimoElemento( int n ){
        return null;
    }
    
    public int posicao( T x ){
        return 0;
    }
    
    public T mediana(){
        return null;
    }
    
    public boolean ehCheia(){
        return false;
    }
    
    public boolean ehCompleta(){
        return false;
    }
    
    public String toString(){
        return null;
    }

    
}
