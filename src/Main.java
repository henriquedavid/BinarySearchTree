
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree abb = new BinaryTree();
		abb.search(abb.root, 10);
		abb.insert(10);
		abb.insert(15);
		abb.insert(20);
                System.out.println("Percurso em nível: " + abb.toString());
		abb.search(abb.root, 20);
                abb.remove(20);
                System.out.println("Percurso em nível: " + abb.toString());
                abb.search(abb.root, 10);
	}

}
