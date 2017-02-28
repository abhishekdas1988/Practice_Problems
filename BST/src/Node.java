public class Node{
static int value;
Node left;
Node right;
public Node(int val) {
	  this.value = val;
	  this.left = null;
	  this.right = null;
	  return;
}



public int getValue(){
  return this.value;
}
public void setLeft(int val){
  Node n = new Node(val);
  this.left = n;
}
public void setRight(int val){
  Node n = new Node(val);
  this.right = n;
}
public Node getLeft(){
  if(this.left!= null){
    return this.left;
  }
  else{
    return null;
  }
}
public Node getRight(){
  if(this.right!= null){
    return this.right;
  }
  else{
    return null;
  }
}

}
