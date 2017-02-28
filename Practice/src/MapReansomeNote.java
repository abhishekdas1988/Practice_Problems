import java.util.*;

public class MapReansomeNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public MapReansomeNote(String magazine, String note) {
    	this.magazineMap =new HashMap<String, Integer>();
    	this.noteMap= new HashMap<String, Integer>();
        
        for(String s: magazine.split(" ")){
        	System.out.println("Magazine = "+s);
            if(!magazineMap.containsKey(s)){
                magazineMap.put(s,1);
            }
        }
                for(String s: note.split(" ")){
            if(!noteMap.containsKey(s)){
            	System.out.println("Note = "+s);
                noteMap.put(s,1);
            }
        }
    }
    
    public boolean solve() {
        boolean retVal = false;
            for(String s: noteMap.keySet()){
                if(this.magazineMap.containsKey(s)){
                    retVal = true;
                }else{
                    retVal = false;
                    break;
                }
            }

        return retVal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        MapReansomeNote s = new MapReansomeNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
