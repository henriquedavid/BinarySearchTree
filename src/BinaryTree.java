
public class BinaryTree<T> {
	
	public class Node{
		T data;
		Node esq;
		Node dir;
		
		public Node(T data, Node esq, Node dir) {
			this.data = data;
			this.esq = esq;
			this.dir = dir;
		}
	}
	
	Node root;
	
	public BinaryTree(){
		root = null;
	}
	
	public Node search(Node ptr, T data) {
		if(ptr != null) {
			if(ptr.data == data) {
				System.out.println("Achou "+ data);
				return ptr;
			}else {
				if((int) data < (int) ptr.data) {
					search(ptr.esq, data);
				}else {
					search(ptr.dir, data);
				}
			}
		}
		return null;
	}
	
	public void insert(T data) {
		insert(root, data);
	}
	
	public void insert(Node ptr, T data) {
		if(root == null) {
			root = new Node(data, null, null);
		}else {
			if((int) data < (int) ptr.data) {
				if(ptr.esq == null) {
					Node aux = new Node(data, null, null);
					ptr.esq = aux;
				}else {
					insert(ptr.esq, data);
				}
			}else if((int) data > (int) ptr.data){
				if(ptr.dir == null) {
					Node aux = new Node(data, null, null);
					ptr.dir = aux;
				}else {
					insert(ptr.dir, data);
				}
			}
		}
	}
	
	public void remove(T data) {
		
	}
}
