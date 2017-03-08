package ListAndQueue;

public class DoubleListIntoTree {
	Node start;
	int size;
	TNode root;
	public void createLinkedList(int[] a){
		this.size = a.length;
		Node previous = new Node(a[0]);
		for(int i =0;i< a.length;i++){
			//System.out.println(" i = "+i);
			
			if(i==0){
				start = new Node(a[i]);
				previous = start;
				
			}
			else if(i == a.length-1){
				Node curr = new Node(a[i]);
				curr.previous = previous;
				previous.next = curr;
				curr.next = null;
				previous = curr;
			}
			else{
				Node curr = new Node(a[i]);
				curr.previous = previous;
				previous.next = curr;
				previous = curr;
			}
		}
		Node curr = start;
		while(curr.next!=null){
			curr = curr.next;
			//System.out.println("Next ="+curr.next.val);
		}
		while(curr!=null){
			System.out.println(curr.val+" ->");
			curr =curr.previous;
		}
	}
	
	public TNode createBinaryTree(Node start){
		int mid = size/2;
		Node curr = start;
		for(int i =0;i<mid;i++){
			curr = curr.next;
		}
		TNode root = new TNode((int)curr.val);
		 root.left = this.BuildNode(curr,true);
		 root.right = this.BuildNode(curr,false);
		 

		 		this.root = root;
				return root;
	}
	
	public TNode BuildNode(Node n,boolean side){
		TNode retVal = new TNode((int)n.val);
		Node listCurr = n;
		if(side == true){
			
			//retVal.left = new TNode((int)n.previous.val);			
			TNode treeCurr = retVal;

			while(listCurr!= null){
				treeCurr.left = new TNode((int)n.previous.val);
				System.out.println("added "+ n.previous.val+" into tree -->" +treeCurr.left.data);
				listCurr = listCurr.previous;
				treeCurr = treeCurr.left;
				System.out.println("current List -->" +listCurr.val);
			}
		}
			else{
				//retVal.right = new TNode((int)n.next.val);
				
				TNode treeCurr = retVal;
				while(listCurr!= null){
					treeCurr.right = new TNode((int)n.next.val);
					System.out.println("added "+ n.previous.val+" into tree -->" +treeCurr.left.data);
					listCurr = listCurr.next;
					treeCurr = treeCurr.right;
					System.out.println("current List -->" +listCurr.val);
				
			}
		}
		return retVal;
	}
	
	public void Inorder(TNode n){
		if(n == null){
			return;
		}
		else{
			Inorder(n.left);
			System.out.print(n.data+" --> ");
			Inorder(n.right);			
		}
		
	}
	
public static void main(String[] args){
	DoubleListIntoTree a= new DoubleListIntoTree();
	int[] arr ={6,12,1,3,4,2,5};
	a.createLinkedList(arr);
	a.createBinaryTree(a.start);
	a.Inorder(a.root);
	
}
}
