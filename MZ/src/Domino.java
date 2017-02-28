import java.util.Arrays;

public class Domino {

	// Assumption, the size of the domino cant be < 0
	/*
	 * Using dynamic programing to actually Solve this. - Basic logic - create a
	 * n X m array where - - n = max (input_array+position of the max_element+1,
	 * lastElement+1) - m = number of inputs - for each input assume to be
	 * starting at domino effct at that location and assume that thats the only
	 * element available. - put a "1" in the slots where the current elemnt
	 * would cover incase it was toppled and the rest of the row elemnts are 0 -
	 * At the end, start from the end of the array in the given ex ( 10,10) if
	 * 10 ,10 =1, means that the element was toppled - traverse horizontally
	 * till the point till you see 1, then traverse vertically 1 down, and then
	 * horzontal traversal till you find 1, repeat this thill the end of the
	 * rows or the element below the last 1 is 0
	 */
	
	int[][] data;
	int[] input;
	public int[][] createArray(int[] input) throws Exception {
		// finding the max and creating the array of mXn
		int max = 0;
		int location = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] < 0) {
				throw new Exception("Invalid input. Values of the domino need to be positive or 0");
			}
			if (input[i] > max) {
				max = input[i];
				location = i;
			}
		}
		// here check if the largest domino will cross the max size of the array
		// or the last element will cross it
//		System.out.println("Length of row = " + input.length + " Length of the col = "
//				+ (Math.max(max + location + 1, input.length - 1 + input[input.length - 1]) + 1));
		int [][]retVal = new int[input.length][Math.max(max + location + 1, input.length - 1 + input[input.length - 1])
				+ 1];
		for (int i = 0; i < retVal.length; i++) {
			Arrays.fill(retVal[i], 0);
		}
		// System.out.println("Retval");
		// for(int i = 0;i< retVal.length;i++){
		// for(int j = 0;j<retVal[i].length;j++){
		// System.out.print(retVal[i][j]+" ");
		// }
		// System.out.println();
		//
		// }
		return retVal;
	}

	public int[] solution1(int[] input) throws Exception {
		this. data = this.createArray(input);
		this.input = input;
		try {
			// Data set creation
			// get the current index of the element, start from that point and
			// fill "1"
			// Till the point the current Domino falls, the previous row values
			// are copied.
			for (int i = 0; i < input.length; i++) {
				// curr row in data = element position in input
				int currFall = input[i];
				if (currFall > 0) {
					int start = i;
					int end = start + currFall;
					for (int j = start; j <= end; j++) {
//						System.out.println("i = " + i + " j = " + j);
						data[i][j] = 1;
					}
				}
				// System.out.println("i = " + i + " Curr = " + currFall);

			}
//			System.out.println("In here");
//			for (int i = 0; i < data.length; i++) {
//				for (int j = 0; j < data[i].length; j++) {
//					System.out.print(data[i][j] + "\t");
//				}
//				System.out.println();
//
//			}

		} catch (Exception e) {
			// System.out.println(e.getMessage());
			// System.exit(1);
		}
		// for(int i = 0;i< data.length;i++){
		// for(int j = 0;j<data[i].length;j++){
		// System.out.print(data[i][j]+" ");
		// }
		// System.out.println();
		//
		// }
		return this.bottomUpSolve(data);
	}

	public int[] bottomUpSolve(int[][] input) {
		int[] retVal = new int[input.length];
		int max = input[0].length;
		for (int i = 0; i < input.length; i++) {
			int row = i;
			int col = i;
			int condition = -1;
			while (row < input.length && col < input[row].length) {
				if (input[row][col] == 0 && row != input.length - 1) {
					if (input[row + 1][col] == 0) {
						condition =1;
						break;
					} else {
						row++;
					}
				} else if (input[row][col] == 1) {
					condition = 0;
					col++;
				}
			}
			if(condition == 1){
				retVal[i] = col;
			}
			else{
				retVal[i] = col-1;
			}


		}
		
		return retVal;
	}
	
	public int[] Add(int sizeOfDomino) throws Exception{
		int[] newInput = new int[this.input.length+1];
		for(int i =0;i< this.input.length;i++){
			newInput[i] = this.input[i];
		}
		newInput[this.input.length] = sizeOfDomino;
		return this.solution1(newInput);
	}

	// Assuming adding the end.
	public boolean Add(int size,int[][]data){
	try{
		

	}catch(Exception e){}
		return true;
	}

	public static void main(String[] args) throws Exception {
		Domino obj = new Domino();
		int [] a = { 0, 0, 4, 3, 0, 2, 2 };
		int[] retval = obj.solution1(a);
		for (int i = 0; i < retval.length; i++) {
			System.out.print(retval[i] + " ");
		}
		retval = obj.Add(5);
		for (int i = 0; i < retval.length; i++) {
			System.out.print(retval[i] + " ");
		}
	}
}
