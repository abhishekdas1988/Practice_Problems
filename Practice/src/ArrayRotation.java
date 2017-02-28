import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayRotation {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		int[] retVal = new int[n];
		if (k == 0) {
			return a;
		} else if (k >= 1) {
			for (int i = 0; i < n; i++) {
				int curr = a[i];
				if (i - k >= 0) {
					retVal[i - k] = curr;
				} else {
					retVal[n - Math.abs(i - k)] = curr;
				}
			}
		}
		return retVal;
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		int[] output = new int[n];
		output = arrayLeftRotation(a, n, k);
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

		System.out.println();

	}
}
