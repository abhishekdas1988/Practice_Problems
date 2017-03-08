import java.util.*;

// Tom starts at 0,0 in the maze, has to go to a location (x,y) to meet jery, valid 
// moves are -> , <-,^ or v on block at a time, he can move through 0, 1 means block
// 2 means cheese.
// Min path required for tom to meet Jery with max cheese.
public class TomAndJeryMinPath {
	static Map<String, Map<Moves, Integer>> pos_moves = new HashMap<String, Map<Moves, Integer>>();
	static int[][] arr;
	static int[][] cheese = new int[4][4];
	
public TomAndJeryMinPath(int[][] arr){
	this.arr = arr;
	for(int i =0;i<cheese.length;i++){
		Arrays.fill(cheese[i], 0);
	}
}
	public void calculatePath(int[][] arr, int row, int col) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				String key = Integer.toString(i).concat(Integer.toString(j));
				Map<Moves, Integer> val = this.getMoves(i, j, arr.length-1, arr[i].length-1);
				pos_moves.put(key, val);
				
			}
		}
		this.OptimumMoves();
		for(int i = 0;i< cheese.length;i++){
			for(int j = 0;j< cheese[i].length;j++){
				System.out.print(cheese[i][j]+"\t");
			}
			System.out.println();
		}

	}

	public int OptimumMoves() {
		// fill cheese

		for (int i = 0; i < cheese.length; i++) {
			for(int j = 0;j< cheese[i].length;j++){
				if(i==0 || j == 0){
					cheese[i][j] = 0;
				}
				else{
					if(arr[i-1][j-1]== 1){
						cheese[i][j]=-1;
					}
					else if (arr[i-1][j-1]==2){
						cheese[i][j] = Math.max(cheese[i][j-1], cheese[i-1][j])+1;
					}
					else{
						cheese[i][j] = Math.max(cheese[i][j-1], cheese[i-1][j]);
					}
				}
			}
			

		}
		int curr_x =1;
		int curr_y = 1;
		int tar_x = 3;
		int tar_y= 3;
		while(curr_x!= tar_x && curr_y!= tar_y){
			//pos_moves
		}
		


		//
		return 0;
	}
	public int returnBestMove(String s,int cheese){
		Map<Moves,Integer> move = pos_moves.get(s);
		for(Moves m: move.keySet()){
			
				
		}
		}
		return 0;
	}

	public Map<Moves, Integer> getMoves(int x, int y, int max_x, int max_y) {
		//System.out.println("x = "+x+" y = "+y+" Max_x = "+max_x+" Max_y = "+max_y);
		Map<Moves, Integer> poss_moves = new HashMap<Moves, Integer>();

		if (x + 1 <= max_x && arr[x + 1][y] != 1) {
			poss_moves.put(Moves.R, 1);
		}
		if (x - 1 >= 0 && arr[x - 1][y] != 1) {
			poss_moves.put(Moves.L, 1);
		}
		if (y - 1 >= 0 && arr[x][y - 1] != 1) {
			poss_moves.put(Moves.U, 1);
		}
		if (y + 1 <= max_y && arr[x][y + 1] != 1) {
			poss_moves.put(Moves.D, 1);
		}
		return poss_moves;
	}
	public static void main(String[] args){
		int[][] a = {{0,2,0},{0,0,1},{1,0,0}};
		TomAndJeryMinPath o = new TomAndJeryMinPath(a);
		o.calculatePath(a, 3, 3);
		
	}

}
