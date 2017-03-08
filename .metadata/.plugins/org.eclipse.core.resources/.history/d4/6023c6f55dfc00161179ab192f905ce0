import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 //Hello My name is Abhishek Das, but you can call me Das
// I think i confused the 1:00Pm PST with 1:00pm EST. 
    1
   / \
  2   3
  /\   \
  6 8   9
paths:      1->2, 2->1, 2->1->3, 3->1 ... etc
path sums:    3,    3,     6,     4   ... etc
max path sum: 6

// find all the nodes of the tree

14 bytes - 
public int FindMax(Node root){
    int max = 0; x 
    int max_curr = 0; y
    //! Leaf node
    if(root.getleft()== null && root.getright==null){
        return root.value();
    }
    else if(root.right== null){
        Node curr = root; z
        Node curr_left = curr.getleft(); 
        //Node curr_right = curr.getright();
        if(max == 0){
            max = curr.getLeft()+curr;
        }
        if(curr.getleft>max){
            max +=curr.getleft+curr;
        }
        else{
                 max +=(curr.getLeft()+curr);
        }
        else{
             max += Math.max(curr.getLeft()+curr,curr.getRight()+curr);
        }
                FindMax(curr.left);
    }
        else if(root.left== null){
        Node curr = root;
        Node curr_right = curr.getright();
        //Node curr_right = curr.getright();
        if(max == 0){
            max = curr.getRight()+curr;
        }
        if(curr.getRight>max){
            max +=curr.getright+curr;
        }
        else{
                 max +=(curr.getright()+curr);
        }
        else{
             max += (curr.getright()+curr);
        }
        
        FindMax(curr.right);
    }
    else(root.left()!= null && root.right!= null){
    
        Node curr = root;
        Node curr_left = curr.getleft();
        Node curr_right = curr.getright();
        if(max == 0){
            max = curr.getLeft()+curr+curr.getRight();
        }
        if(curr.getleft+curr.getright>max){
            max +=curr.getleft+curr.getright+curr;
        }
        else{
             max += Math.max(curr.getLeft()+curr,curr.getRight()+curr);
        }
        
       FindMax(curr.left);
       FindMax(curr.right); 
    }

}

//









 * */

public class LogicalPath {
	public void run(){
		
		System.out.println("I am thread ");
	}
	public static void lol() throws Exception{
		try{
			throw new Exception("Lol -First one");
		}catch(Exception e){
			Constructor<?> []m = Exception.class.getConstructors();
			for(Constructor<?> s:m){
				System.out.println(m);
			}
		}
		ExecutorService s = Executors.newFixedThreadPool(2);
		//s.execute(new Thread(this,"1").run());
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		 
	}
	public static void charArrString(char[] a){
		String s = Arrays.toString(a);
		System.out.println(s);
	}


	public static void main(String[] args) throws Exception{
		LogicalPath.lol();
		char[] a ={'a','b','c','d'};
		LogicalPath.charArrString(a);
	}

}
