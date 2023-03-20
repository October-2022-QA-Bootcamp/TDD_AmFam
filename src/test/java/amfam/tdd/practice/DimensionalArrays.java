package amfam.tdd.practice;

import org.testng.annotations.Test;

public class DimensionalArrays {

	@Test
	public void test2DArray() {
		int [] a = {1, 2, 3, 10};
		int [] b = {4, 5, 6, 11};
		int [] c = {7, 8, 9, 12};
		
		int [][] array = new int [3][4];
		array[0] = a;
		array[1] = b;
		array[2] = c;
		
		int [] a2 = {21, 22, 23, 10};
		int [] b2 = {24, 25, 26, 11};
		int [] c2 = {27, 28, 29, 12};
		
		int [][] array2D2 = new int [3][4];
		array2D2[0] = a2;
		array2D2[1] = b2;
		array2D2[2] = c2;
		
		System.out.println(array[0][2]);
		
		int [][][] array3D = new int [2][3][4];
		array3D[0] = array;
		array3D[1] = array2D2;
		
		System.out.println(array3D[1][2][3]);
	}
}
