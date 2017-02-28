import java.util.List;
import java.util.Map;

public class  SeparateStringsCharactersNumber {
	Map<String,List<String>> bank;
	public String[] Separate(String s){
		String[] retVal;
		if(s==null){
			throw new NullPointerException();
		}
		else{
//			for(int i = 0;i< s.length();i++){
//				System.out.println("Current = "+s.charAt(i)+" has Value = "+(int)s.charAt(i));
//			}
			retVal= s.split("[\\s]",-1);// only alphabets
			//retVal= s.split("[^\\W]&&[\\s]");// only numbers
			for(int i=0;i< retVal.length;i++){
				
			}
			

		}
		return retVal;
	}
	public  static void main(String [] args){
		String[] retVal =new SeparateStringsCharactersNumber().Separate("This is a Bloomberg's Java8 question score345 &with \t $100 worth.\n");
		for(int i=0;i<retVal.length;i++){
			System.out.println(retVal[i]+ "  ");
		}
		
	}

}
