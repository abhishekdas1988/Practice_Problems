package TreeAndHeap;
public class Node {
	int data;
	Node left;
	Node right;
	public Node(int n){
		this.data = n;
		this.left = null;
		this.right = null;
	}
	// reflection
	public void doSome(){
		System.out.println("Hi");
	}
}