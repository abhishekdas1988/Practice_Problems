import java.util.Arrays;

public class PrisonEscape {
	static long prison(int n, int m, int[] h, int[] v) {
		int[][] data = new int[n + 1][m + 1];
		int max_area = 1;
		// int max_col = 1;
		for (int i = 0; i < data.length; i++) {
			Arrays.fill(data[i], 0);
		}
		// removing the horizontal bars
		for (int i = 0; i < h.length; i++) {
			int curr = h[i];
			for (int j = 0; j < data[curr].length; j++) {
				if (curr - 1 != 0) {
					data[curr - 1][j] =data[curr - 2][j] * 2 ;
					data[curr][j] = data[curr - 1][j] * 2;
				} else {

					data[curr - 1][j] = j + 1;
					data[curr][j] = data[curr - 1][j] * 2;

				}
				if (max_area < Math.max(data[curr - 1][j], data[curr - 1][j] )) {
					max_area = Math.max(data[curr - 1][j], data[curr - 1][j] );

				}

			}
		}
		// removing horizontal bars
		for (int i = 0; i < v.length; i++) {
			int curr = v[i];
			for (int j = 0; j < data[curr].length; j++) {
				if (curr - 1 != 0) {
					data[j][curr - 1] = data[j][curr - 2] * 2;
					data[j][curr] = data[j - 1][curr] * 2;
				} else {
					data[j][curr - 1] = j + 1;
					data[j][curr] = data[j - 1][curr] * 2;

				}
				if (max_area < Math.max(data[j][curr-1], data[j][curr] )) {
					max_area = Math.max(data[curr - 1][j], data[curr - 1][j] );

				}

				
			}

		}

		// this.area();

		return (max_area);
	}



}
