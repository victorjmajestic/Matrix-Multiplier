// Multiplies any two compatible matrices.

public class MatrixMultiplier {

	public static int getRows(int[][] A) {
		// Retrieves the number of rows in a matrix.
		int rows = 0;
		for (int i = 0; i < A.length; i++)
			rows++;
		return rows;
	}
	
	public static int getColumns(int[][] A) {
		// Retrieves the number of columns in a matrix.
		int columns = 0;
		for (int i = 0; i < A[0].length; i++) {
			columns++;
		}
		return columns;
	}
	
	public static int[] getRowValues(int[][] A, int row) {
		// Retrieves all values in a specific row.
		int[] rowValues = new int[A[row].length];
		for (int i = 0; i < rowValues.length; i++) {
			rowValues[i] = A[row][i];
		}
		return rowValues;
	}
	
	public static int[] getColumnValues(int[][] B, int col) {
		// Retrieves all values in a specific column.
		int[] colValues = new int[B.length];
		for (int i = 0; i < colValues.length; i++) {
			colValues[i] = B[i][col];
		}
		return colValues;
	}
	
	public static int findSum(int[][] A, int[][] B, int row, int col) {
		// Calculates the sum of the row in Matrix A and the column in Matrix B.
		int sum = 0;
		int[] rowValues = getRowValues(A, row);
		int[] colValues = getColumnValues(B, col);
		for (int i = 0; i < B.length; i++) {
			sum += (rowValues[i] * colValues[i]);
		}
		return sum;
	}
	
	public static boolean checkValidity(int[][] A, int[][] B) {
		/*
		 * Determines if two matrices can be multiplied.
		 * First, it makes sure the dimensions of each array are respected.
		 * Then, it makes sure the number of columns in A equal the number of rows in B.
		 */
		int aColumns = getColumns(A);
		for (int i = 0; i < A.length; i++) {
			int j = 0;
			while (j < A[i].length) {
				j++;
			}
			if (j != aColumns)
				return false;
		}
		int bColumns = getColumns(B);
		for (int i = 0; i < B.length; i++) {
			int j = 0;
			while (j < B[i].length) {
				j++;
			}
			if (j != bColumns)
				return false;
		}
		if (getColumns(A) != getRows(B))
			return false;
		return true;
	}
	
	
	public static int[][] multiplyMatrix(int[][] A, int[][] B) {
		/* 
		 * Multiplies two matrices (dim mxn and axb) together.
		 * First, we check the validity.
		 */
		if (!checkValidity(A,B)) {
			return null;
		}
		// Creates a new matrix and place each row and column sum in the matrix.
		int[][] sol = new int[getRows(A)][getColumns(B)];
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[i].length; j++) {
				sol[i][j] = findSum(A, B, i, j);
			}
		}
		return sol;
	}
	
	public static void print (int[][] grid) {
		// Prints the matrix nicely.
		for (int i = 0; i < grid.length; i++) {
	        for (int j = 0; j < grid[i].length; j++) {
	            System.out.print(grid[i][j]+ " ");
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
		int[][] array2 = {{-1, 5, -2}, {2, -3, 2}, {4, 0, 1}};
		System.out.println("The first matrix is:");
		print(array);
		System.out.println("Dimensions: " + getRows(array) + "x" + getColumns(array));
		System.out.println("");
		System.out.println("The second matrix is: ");
		print(array2);
		System.out.println("Dimensions: " + getRows(array2) + "x" + getColumns(array2));
		System.out.println("");
		int[][] multipliedMatrix = multiplyMatrix(array, array2);
		if (multipliedMatrix != null) {
			System.out.println("The multiplied matrix is: ");
			print(multipliedMatrix);
			System.out.println("Dimensions: " + getRows(multipliedMatrix) + "x" + getColumns(multipliedMatrix));
		}
		else {
			System.out.println("The matrices cannot be multiplied.");
			System.out.println("Check the dimensions and try again.");
		}
	}

}
