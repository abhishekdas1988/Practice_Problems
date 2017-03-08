package ListAndQueue;

public class Node<T> {
	public T val;
	Node <T> next;
	Node<T> previous;
	
	public Node(T val, Node prev,Node next){
		this.val = val;
		this.previous = prev;
		this.next = next;
	}
	public Node(T val){
		this.val = val;
		this.previous =null;
		this.next = null;
	}
	

}
