import java.util.*;

public class FirstOccuranceCharNonRepetative {
	private Map<Character,Integer> bank;
	private String s;
	
public FirstOccuranceCharNonRepetative(String s){
	this.s = s;
	bank = new LinkedHashMap<Character,Integer>();
}
public Character Solution(){
	Character retVal= null;
	for(int i=0;i< this.s.length();i++){
		if(this.bank.containsKey(this.s.charAt(i))){
			this.bank.put(this.s.charAt(i),this.bank.get(this.s.charAt(i))+1 );
		}
		else{
			this.bank.put(this.s.charAt(i),1 );
		}
	}
	this.print();
	for(Iterator<Character> i=bank.keySet().iterator();i.hasNext();){
		Character curr = i.next();
		if(bank.get(curr)==1){
			retVal = curr;		
			}
	}
	return retVal;


}
public void print(){
	for(Character s: this.bank.keySet()){
		System.out.println("Key = "+s+" Value = "+this.bank.get(s));
	}
}

public static void main(String[] args){
	FirstOccuranceCharNonRepetative obj = new FirstOccuranceCharNonRepetative("abcasbbcsd");
	System.out.println(obj.Solution());
}
}
