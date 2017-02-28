package TreeAndHeap;
import java.util.Collection.*;

public class Heap {
	private int MAX_SIZE;
	private HeapNode[] arr;
	private int curr_size;

	public Heap(int size) {
		this.MAX_SIZE = size;
		arr = new HeapNode[this.MAX_SIZE];
		this.curr_size = 0;
	}

	public boolean addNode(HeapNode n) {
		if (curr_size < MAX_SIZE-1) {
			arr[++curr_size] = n;
			this.trickleUp(curr_size);
			return true;
		}
		System.out.println("Heap MAX_SIZE reached- Cant add");
		return false;
	}

	public void trickleUp(int location) {
		int curr = location;
		System.out.println("Current "+curr);
		while (curr >1) {
			System.out.println("Current "+curr);
			HeapNode parent = arr[curr / 2];
			System.out.println("Parent ="+parent.getVal()+" at location "+(curr/2));
			if (parent.getVal() < arr[curr].getVal()) {
				HeapNode temp;
				temp = arr[curr / 2];
				arr[curr / 2] = arr[curr];
				arr[curr] = temp;
				curr = curr / 2;
			}
			else{
				break;
			}

		}
		System.out.println("Heap node is moved to position " + curr);
	}

	public boolean removeNode() {
		if (curr_size <1) {
			// No elements are present
			System.out.println("Cannot remove as the heap size is 0");
			return false;
		}
		else {
			//Only one or more nodes can be present
			System.out.println("Removed "+arr[1].getVal());
			this.arr[1] = this.arr[curr_size];
			this.arr[curr_size--] = null;
			System.out.println("------------After removal--------------------");
			this.print();
			System.out.println("--------------------------------");
			//curr_size--;
			this.trickleDown(1);
			return true;
		}
	}

	public void trickleDown(int location) {
		int curr = location;
		if(curr_size ==1){
			return;
		}

		while (curr < curr_size) {
			int left_index = 2 * curr;
			int right_index = 2 * curr + 1;
			this.print();
			System.out.println("Current="+curr+" Left="+left_index+" Right="+right_index);
			// Both left and right nodes are present
			if(left_index<= curr_size && right_index<= curr_size){
				if (arr[left_index].getVal() > arr[curr].getVal() || arr[right_index].getVal() > arr[curr].getVal()) {
				int swap = (arr[left_index].getVal()>arr[right_index].getVal()?2*curr:2*curr+1);
				HeapNode temp = arr[swap];
				arr[swap] = arr[curr];
				arr[curr] = temp;
				curr = swap;
			}
			}
			//Only left node present
			else if(left_index<= curr_size && right_index > curr_size){
				int swap = left_index;
				HeapNode temp = arr[swap];
				arr[swap] = arr[curr];
				arr[curr] = temp;
				curr = swap;
			}
			// If left node is absent there cannot exist a right node.
//			else if(right_index<= curr_size && left_index > curr_size){
//				int swap = right_index;
//				HeapNode temp = arr[swap];
//				arr[swap] = arr[curr];
//				arr[curr] = temp;
//				curr = swap;
//			}
			else{
				break;
			}

		}
		System.out.println("Heap node root " + (arr[1]==null ?"NULL":arr[1].getVal()));
	}
	public void print(){
		for(int i=1;i<= this.curr_size;i++){
			System.out.print(this.arr[i].getVal()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		Heap heap = new Heap(5);
		heap.addNode(new HeapNode(12));
		heap.addNode(new HeapNode(3));
		heap.addNode(new HeapNode(1));
		heap.addNode(new HeapNode(19));
		heap.addNode(new HeapNode(13));
		System.out.println("--------------------------------------------");
		heap.print();

		heap.removeNode();
		heap.removeNode();
		heap.removeNode();
		heap.removeNode();
		heap.removeNode();
		
	}

}
