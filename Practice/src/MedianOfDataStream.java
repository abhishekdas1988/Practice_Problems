import java.util.Random;
import java.util.Vector;

public class MedianOfDataStream {
	Node root = null;
	int size = 0;
	int median_loc = 0;
	int median;
	static int count=0;
	Vector<Integer> curr_arr = new Vector<Integer>();

	public void RandomGenerator() {
		Random r = new Random(31);
		for (int i = 0; i < 10; i++) {
			int curr = r.nextInt(29);
			System.out.println("------------------"+curr+"------------------");
			this.putValue(curr);
			curr_arr = new Vector<Integer>();
			this.printTree(root);
			//System.out.println("------------------");
			this.MedianCalculator(curr);
			//System.out.println("");
		}
	}

	public void MedianCalculator(int a) {
		if (size == 1) {
			median_loc = 0;
			median = a;
		}
		if (size % 2 == 0) {
			if (a <= median) {
				median_loc = median_loc - 1;
				median = this.getMedian(root, median_loc);
			} else {
				median = this.getMedian(root, median_loc);
			}

		} else {
			if (a <= median) {
				// median_loc = median-1;
				median = this.getMedian(root, median_loc);
			} else {
				median_loc = median_loc + 1;
				median = this.getMedian(root, median_loc);
			}

		}
		//System.out.print("[ ");
		//this.printTree(root);
		System.out.println("median is "+median);

	}

	public Integer getMedian(Node root, int loc) {
		count = loc;
		System.out.println("Location of median ="+loc);
		if(count == 0){
			return median;
		}
			if (root == null) {
				return null;
			} else {
				this.printTree(root.left);
				median = root.data;
				this.printTree(root.right);
				count--;
			}

		return median;
	}

	public void putValue(int c) {
		size++;
		if (root == null) {
			root = new Node(c);
		} else {
			Node curr = root;
			Node parent = root;
			//boolean left = true;
			while (curr != null) {
				if (c <= parent.data) {
					parent = curr;
					curr = curr.left;
					//left = true;
				} else {
					parent = curr;
					curr = curr.right;
					//left = false;
				}
			}
			curr = new Node(c);
			if(c<= parent.data){
				parent.left = curr;
				//System.out.println("added "+curr.data+" to the parent"+parent.data+" - >left");
			}
			else{
				parent.right = curr;
				//System.out.println("added "+curr.data+" to the parent"+parent.data+" - >right");
			}
		}
	}
	
	
	
	public void printTree(Node root){
		if(root == null){
			return;
		}
		else{
			printTree(root.left);
			curr_arr.add(root.data);
			printTree(root.right);
		}
		//System.out.print("]");
		//System.out.println();
	}
	public static void main(String[] args){
		MedianOfDataStream o = new MedianOfDataStream();
		o.RandomGenerator();
		
	}

}
