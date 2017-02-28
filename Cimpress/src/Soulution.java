import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	HashMap<String, Integer> phoneLog;
	int total;
	String freeCall;

	public Solution() {
		this.phoneLog = new HashMap<String, Integer>();
		this.total = 0;
		this.freeCall = new String();
	}

	public int solution(String S) {
		// write your code in Java SE 8
		// Cost calculator
		this.logProcessor(S);
		ArrayList<String> tie = this.isTie(this.phoneLog);
		// Now we have the phonelog with numbers and times, tie list for phones
		// with max times..
		// If the Tie list is empty there is no numbers with max. So the entry
		// String is faulty
		if (tie.size() == 0) {
			return -1;
		}
		// Atleast there should be one element in the tie list even if the
		// string has 1 element.
		else {
			// There can be more than one number with max call duration.
			if (tie.size() > 1) {
				Integer minPhone = Integer.parseInt(tie.get(0).replaceAll("-", ""));
				for (int i = 1; i < tie.size(); i++) {
					if (Integer.parseInt(tie.get(i).replaceAll("-", "")) < minPhone) {
						minPhone = Integer.parseInt(tie.get(i).replaceAll("-", ""));
						this.freeCall = tie.get(i);
					}
				}

			} else {
				this.freeCall = tie.get(0);
			}
			// System.out.println("freeCall - "+freeCall);
			for (String key : this.phoneLog.keySet()) {
				int val = this.phoneLog.get(key);
				if (key.compareTo(freeCall) != 0) {
					// If the duration is less that 5 mins pay 3 cents for every
					// started sec
					if (val < 300) {
						total = total + val * 3;
					}
					// time is more or equal to 5 mins
					else {
						if (val % 60 != 0) {
							int total_mins = val / 60 + 1;
							total = total + total_mins * 150;
						} else {
							// talk time is anytime greater or equal to 5 mins
							// but without seconds
							total = total + (val / 60) * 150;

						}
					}

				}
			}
		}

		return total;
	}

	public void logProcessor(String S) {
		// Function takes the string and returns a key value pair
		// where key is the phone number and value is the time in sec
		// for the call duration

		// First split the given string as per the end of line character

		String[] entries = S.split("\\r?\\n");
		// for(String s:entries){
		// System.out.println(s);
		// }
		for (String s : entries) {
			String[] current = s.split(",");
			// We have the time in sec and the phone number now
			// We need to store this in a hash map so that duplicate phone
			// can be properly added to get total time
			if (this.phoneLog.containsKey(current[1])) {
				// System.out.println("current "+current[1]);
				// System.out.println("Has key "+
				// this.phoneLog.get(current[1]));
				this.phoneLog.put(current[1], (this.phoneLog.get(current[1]) + this.secConverter(current[0])));
			} else {
				this.phoneLog.put(current[1], this.secConverter(current[0]));
			}

		}
		// System.out.println("Size "+ this.phoneLog.size());
		// for(String key:this.phoneLog.keySet()){
		// System.out.println("Key - "+ key+" Value - "+this.phoneLog.get(key));
		//
		// }
	}

	public int secConverter(String S) {
		String[] time = S.split(":");
		return (3600 * Integer.parseInt(time[0]) + 60 * Integer.parseInt(time[1]) + Integer.parseInt(time[2]));

	}

	public ArrayList<String> isTie(HashMap<String, Integer> s) {
		// check if the there is a max and also if there is a tie between
		// numbers
		ArrayList<String> tie = new ArrayList<String>();
		Integer max = -1;
		for (String key : this.phoneLog.keySet()) {
			if (this.phoneLog.get(key) > max) {
				max = this.phoneLog.get(key);
			}
		}
		if (max != -1) {
			for (String key : this.phoneLog.keySet()) {
				if (this.phoneLog.get(key) == max) {
					tie.add(key);
				}
			}
		}
		return tie;
	}
	 public static void main(String[] args){
	 String S = "00:01:07,400-234-090\n"+
	 "00:05:01,701-080-080\n"+
	 "00:05:00,400-234-090\n"+
	 "12:01:59,400-234-091\n"+
	 "00:00:01,400-234-091";
	 Solution s = new Solution();
	 System.out.println(s.solution(S));
	
	 }
}