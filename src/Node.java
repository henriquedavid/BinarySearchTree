/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class Node {

    int data;
    Node esq;
    Node dir;

    public Node(int data, Node esq, Node dir) {
        this.data = data;
        this.esq = esq;
        this.dir = dir;
    }

}