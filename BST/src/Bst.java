// Given a sorted integer array, create a BST
// Ex. [0, 2, 5, 8, 10]
//   5
// /  \
// 0   8
// \    \
//  2    10
public class Bst extends Node{
Node root;
public Bst(){
  super(value);
  this.root = null;
}

public void addNode(int val){
      // If the root is null, create a root first.
    Node n = new Node(val);
    if(this.root== null){
        this.root = n;
    }
    else{
        Node curr = this.root;
        boolean right = false;
        while(true){
            if(val > curr.getValue()){
                curr = curr.getRight();
                right = true;
            }
            else{
                curr = curr.getLeft();
                right = false;
            }
            if(curr == null){
                break;
            }
        }
        if(right == true){
            curr.right = new Node(val);
        }
        else{
            curr.left = new Node(val);
        }
     
    }
}

public static void main(String [] args){
    int[] input = {0, 2, 5,8, 10};
    int length = input.length;
    Bst obj = new Bst();
    obj.addNode(input[length/2]);
    for(int i = length/2+1;i<= length;i++){
        obj.addNode(input[i]);
    }
    for(int i = 0;i<length/2;i++){
        obj.addNode(input[i]);
    }
    
}


}
