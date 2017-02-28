import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> removePunct(String wordOrPhrase){
		List<String> retVal = new ArrayList<String>();
		String [] notClean = wordOrPhrase.replaceAll("[^a-zA-Z\\s]","").replaceAll("\\s+", "").toLowerCase().split("");
		for(int i = 0;i< notClean.length;i++){
			if(notClean[i]!=null || notClean[i]!=""){
				retVal.add(notClean[i]);
			}
		}
	    // replacing all the punctuations with "" and converting everything to lowercase.
	    return retVal;
	}
	public boolean isPalindrome(String wordOrPhrase){
		ArrayList<String> s = (ArrayList<String>) this.removePunct(wordOrPhrase);
		//System.out.println(s);
		int l = s.size();
		for(int i = 0;i< l/2;i++){
			if(s.get(i).compareToIgnoreCase(s.get(l-i-1))!=0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Solution s= new Solution();
        System.out.println(s.isPalindrome("Are we not pure? “No sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man; a prisoner up to new era."));
	}
	
}
