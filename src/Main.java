
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> abb = new BinaryTree<>();
		abb.search(abb.root, 10);
		abb.insert(10);
		abb.insert(15);
		abb.insert(20);
		abb.search(abb.root, 20);
	}

}
