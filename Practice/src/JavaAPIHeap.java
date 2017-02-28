import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public  class JavaAPIHeap {
	private final int a;
	static JavaAPIHeap obj =null;
	List<String> y = new LinkedList<String>();
	Map<String,List<String>>x = new HashMap<String,List<String>>();


	
	private JavaAPIHeap(int a){
		this.a = a;
		
		
	}

	public static JavaAPIHeap returnInstance(){
		if (obj==null){
			obj = new JavaAPIHeap(1);
			 System.out.println(Name.Abhishek.returnFullName().toString());
			for(Name s: Name.values()){}
		}
		return obj;
	}
	public void getValue(String s){
	//y.re
		System.out.println("Hello");
	}
	public void getValue(int a) throws Exception{
		//if(this.x.con)

		throw new Exception("Element not found");
	}
		public static void main(String [] args){
		System.out.println("abhishek das           ".hashCode()); 
			if("aaaaa" instanceof String){
				System.out.println("yes");
				List<String> s = new ArrayList<String>();
				s.add("Abc");
				JavaAPIHeap o = new JavaAPIHeap(2);
				o.testWildCardBounded(s);
				o.returnInstance();
			}
		}
		
		
		public <E>List<E> testWildCardBounded(List<E> a ){
			
			return null;
		}
	}
	