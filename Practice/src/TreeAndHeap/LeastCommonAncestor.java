package TreeAndHeap;
import java.util.*;
public class LeastCommonAncestor {
	boolean a_found = false;
	boolean b_found = false;
	Set<Node> common = new HashSet<Node>();
	Node lcanode;
	Node root;
	public Node lca(Node a, Node b){
		this.findNode(root,a);
		this.findNode(root,b);
		return this.lcanode;
	}
	
	public void findNode(Node root,Node a){
		Node curr = root;
		if( a == null || curr == a){
			return;
		}
		else if(a.data<=root.data){
			if(common.add(curr)){
				curr = curr.left;
				findNode(curr,a);
			}
			else{
				lcanode = curr;
				curr = curr.left;
				findNode(curr,a);
			}
		}
			else{
				if(common.add(curr)){
					curr = curr.right;
					findNode(curr,a);
				}
				else{
					lcanode = curr;
					curr = curr.right;
					findNode(curr,a);
				}
			}
		}
	}


