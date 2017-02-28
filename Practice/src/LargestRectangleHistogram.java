public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length+1;
        int [][]bank = new int[size][size];
        // initializing the bank with 0;
        for(int i = 1;i< size;i++){
            bank[0][i]= heights[i-1];
            bank[i][0]=i;
            bank[1][i] = heights[i-1];
        }
        for(int i=2;i<size;i++){
            
            for(int j = i;j< bank[i].length;j++){
            	bank[i][j] = this.isLeast(j-(i-1)-1,j-1,heights)*i;
            }
        }
        //this.Print(bank);
        // Find the biggest number in the array and return it
        return this.Largest(bank);
        
    }
    
    public int isLeast(int start, int end, int[] a){
        int least = Integer.MAX_VALUE;
        for(int i = start; i<= end;i++){
            if (a[i]<= least){
                least = a[i];
            }
        }
        //System.out.println("Least in "+start +" End "+(end-1)+" is "+least);
        return least;
    }
    public int Largest(int[][] a){
        int max = Integer.MIN_VALUE;
        for(int i=1;i<a[1].length;i++){
            for(int j = 1;j< a[i].length;j++){
                if(a[i][j]>=max){
                    max = a[i][j];
                }
            }
        }
        return max;
    }
    public void Print(int[][]a ){
    	for(int i = 0;i<a[0].length;i++){
    		for(int j = 0;j< a[i].length;j++){
    			System.out.print(a[i][j]+"\t");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String [] args){
    	LargestRectangleHistogram a = new LargestRectangleHistogram();
    	int[] l = {2,1,5,6,2,3};
    	System.out.println(a.largestRectangleArea(l));
    }
}