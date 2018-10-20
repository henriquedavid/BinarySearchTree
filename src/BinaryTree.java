
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BinaryTree {

    Node root;
    int altura = 0;

    public BinaryTree() {
        root = null;
    }

    public Node search(Node ptr, int data) {
        if (ptr != null) {
            if (ptr.data == data) {
                System.out.println("Achou " + data);
                return ptr;
            } else {
                if (data < ptr.data) {
                    search(ptr.esq, data);
                } else {
                    search(ptr.dir, data);
                }

            }
        }
        return null;
    }

    public void insert(int data) {
        insert(root, data);
    }

    public void insert(Node ptr, int data) {
        
        if (root == null) {
            root = new Node(data, null, null, 0);
        } else {
            if ((int) data < (int) ptr.data) {
                if (ptr.esq == null) {
                    altura += 1;
                    Node aux = new Node(data, null, null, altura);
                    ptr.esq = aux;
                    altura = 0;
                } else {
                    insert(ptr.esq, data);
                }
            } else if (data > ptr.data) {
                if (ptr.dir == null) {
                    altura += 1;
                    Node aux = new Node(data, null, null, altura);
                    ptr.dir = aux;
                    altura = 0;
                } else {
                    insert(ptr.dir, data);
                }
            }
        }
    }

    public void remove(int data) {
        Node aux = root;
        Node node = aux;

        while (node != null && data != node.data) {

            if (node.data > data) {
                node = node.esq;
            } else {
                node = node.dir;
            }

        }

        // 0st case: The node isn't in the tree.
        if (node == null) {
            // Do nothing.
            System.out.println("O valor não existe.");
        } // The case that we have to remove the root.
        else if (node == root) {
            Node aux2 = null;
            if (node.esq != null) {
                aux2 = node.esq;

                while (aux2.dir != null) {
                    aux2 = aux2.dir;
                }

                Node fath = findFather(aux2);
                if (fath.esq == aux2) {
                    fath.esq = null;
                } else {
                    fath.dir = null;
                }

                if (aux2.esq == root.esq) {
                    // Do nothing.
                } else {
                    aux2.esq = root.esq;
                    aux2.dir = root.dir;
                }
                root.esq = null;
                root.dir = null;
                root = aux2;

            } else if (node.dir != null) {
                aux2 = node.dir;

                while (aux2.esq != null) {
                    aux2 = aux2.esq;
                }

                Node fath = findFather(aux2);
                if (fath.esq == aux2) {
                    fath.esq = null;
                } else {
                    fath.dir = null;
                }

                if (aux2.esq == root.esq) {
                    // Do nothing.
                } else {
                    aux2.esq = root.esq;
                    aux2.dir = root.dir;
                }
                root.esq = null;
                root.dir = null;

                root = aux2;
            } else {
                root = null;
            }

        } else {

            // Find father.
            Node father = findFather(node);

            // 1st case:  This means that the node is a leaf. 
            if (node.esq == null && node.dir == null) {
                if (father.esq == node) {
                    father.esq = null;
                } else {
                    father.dir = null;
                }
            } // 2nd case: The node has one son.
            else if ((node.esq != null && node.dir == null)
                    || (node.esq == null && node.dir != null)) {

                // Son of the node.
                Node son = null;
                if (node.esq != null) {
                    son = node.esq;
                    node.esq = null;
                } else {
                    son = node.dir;
                    node.dir = null;
                }

                if (father.esq == node) {
                    father.esq = son;
                } else {
                    father.dir = son;
                }

            } // 3rd case: The node has two sons.
            else {

                // We're going to work with the rightmost node on the left
                Node chosen = node.esq;

                while (chosen.dir != null) {
                    chosen = chosen.dir;
                }

                // We have to find the father of the chosen.
                Node father_leaf = findFather(chosen);

                if (father_leaf.esq == chosen) {
                    father_leaf.esq = null;
                } else {
                    father_leaf.dir = null;
                }

                if (father.esq == node) {
                    father.esq = chosen;
                } else {
                    father.dir = chosen;
                }

                chosen.dir = node.dir;
                chosen.esq = node.esq;

                node.dir = null;
                node.esq = null;

            }
        }
    }

    // Method to find the father of a node.
    public Node findFather(Node node) {
        Node aux = root;
        Node father = aux;

        while (aux != node) {

            father = aux;
            if (aux.data > node.data) {
                aux = aux.esq;
            } else {
                aux = aux.dir;
            }

        }
        return father;
    }

    public String toString() {
        String valor = "";

        if (root == null) {
            return "A árvore é vazia!";
        } else {

            Deque<Node> deque = new ArrayDeque<>();
            deque.addLast(root);

            while (!deque.isEmpty()) {
                Node aux = deque.removeFirst();
                valor += aux.data + " ";
                if (aux.esq != null) {
                    deque.add(aux.esq);
                } else if (aux.dir != null) {
                    deque.add(aux.dir);
                }
            }

        }

        return valor;
    }

    public int enesimoElemento(int x){
        x-=1;
        ArrayList<Integer> lista = new ArrayList<>();
        Node aux = root;
        
        if(root != null){
            
            char[] valores = ordem(aux).toCharArray();
            String valor = "";
            for(int i = 0; i < valores.length; i++){
                if( valores[i] == ' ' ){
                    lista.add(Integer.parseInt(valor));
                    valor = "";
                } else{
                    valor += valores[i];
                }
                
            }
            if(lista.size() > x)
                return lista.get(x);
            
        }
        
        return 0;
    }
    
    public int posicao( int x ){
        ArrayList<Integer> lista = new ArrayList<>();
        Node aux = root;
        
        if(root != null){
            
            char[] valores = ordem(aux).toCharArray();
            String valor = "";
            for(int i = 0; i < valores.length; i++){
                if( valores[i] == ' ' ){
                    lista.add(Integer.parseInt(valor));
                    valor = "";
                } else{
                    valor += valores[i];
                }
                
            }
            
            
            
            int posicao = 0;
            
            for(int a = 0; a < lista.size() ; a++){
                if(lista.get(a) == x){
                    posicao = a;
                }
            }
            
            posicao += 1;
            
            return posicao;
            
        }
        
        return 0;
    }
    
    // Percurso em ordem
    public String ordem(Node ptr){
        String percorrimento = "";
        
        if(ptr == null)
            return "";
        
        percorrimento += ordem(ptr.esq);
        percorrimento += ptr.data + " ";
        percorrimento += ordem(ptr.dir);
        
        return percorrimento;
        
    }
    
    
    
}
