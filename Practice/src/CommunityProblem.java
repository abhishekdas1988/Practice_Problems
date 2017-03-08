import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CommunityProblem {
  static Map<Integer,Set<Integer>> community;

  public void createCommunities(int size){
    community = new HashMap<Integer,Set<Integer>>();
    for(int i=1;i<= size;i++){
      Set<Integer> curr =new HashSet<Integer>();
      curr.add(i);
      community.put(i,curr);
    }
  }
  public void mergeCommunities(int a,int b){
    Set<Integer> _a = community.get(a);
    Set<Integer> _b = community.get(b);
    
    if(_a.size()>_b.size()){
      _a.addAll(_b);
       community.put(a,_a);
       community.put(b,_a);
    }
    else{
      _b.addAll(_a);
       community.put(a,_b);
       community.put(b,_b);      
    }
  }
  
  public int getCount(int a){
    return community.get(a).size();
  }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	CommunityProblem obj = new CommunityProblem();
      Scanner s = new Scanner(System.in);
      String size = s.nextLine();
      String[] _size = size.split("\\s+");
      obj.createCommunities(Integer.parseInt(_size[0]));
      for(int i =0;i< Integer.parseInt(_size[1]);i++){
        String query = s.nextLine();
        String[] _query = query.split("\\s+");
        if(_query[0].compareToIgnoreCase("Q")==0){
          System.out.println(obj.getCount(Integer.parseInt(_query[1])));
        }else{
          obj.mergeCommunities(Integer.parseInt(_query[1]),Integer.parseInt(_query[2]));
        }
      }
//      for(int i = 0;i< _size.length;i++){
//        System.out.println(_size[i]);
//      }
    }
}