import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class PrintMatrixSpiralTest {

  @Test
  public void test() {
    int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    assertEquals("1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10", print(a));
    int b[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}};
    assertEquals("1 2 3 4 8 7 6 5", print(b));
    int c[][] = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
    assertEquals("1 2 3 4 5 5 4 3 2 1", print(c));
  }

  /*
  Spiral problem
  Given a matrix, traverse through it in a Spiral fashion.
  Ex: 1   2   3   4 
      5   6   7   8
      9   10  11  12
      13  14  15  16
  
  Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
   */
  private static String print(int[][] a) {
    // Get the number of rows and columns that we have. 
    StringBuilder builder = new StringBuilder();
    int numberOfRowsLeft = a.length;
    int numberOfColumnsLeft = a[0].length;
    int rowIndex = 0, columnIndex = 0;

    // While we still have rows and columns left to process
    while (rowIndex < numberOfRowsLeft && columnIndex < numberOfColumnsLeft) {

      // Process the top row of the rows left to process
      for (int i = columnIndex; i < numberOfColumnsLeft; i++) {
        builder.append(a[rowIndex][i] + " ");
      }
      rowIndex++; // Row processed, move to the next row

      // Process the right most column of the columns left to process 
      for (int i = rowIndex; i < numberOfRowsLeft; i++) {
        builder.append(a[i][numberOfColumnsLeft - 1] + " ");
      }
      numberOfColumnsLeft--; // One column is processed. Decrease the number of columns to process

      if (rowIndex < numberOfRowsLeft) { // Check if there is more rows
        // Process the bottom row of the rows left to process
        for (int i = numberOfColumnsLeft - 1; i >= columnIndex; i--) {
          builder.append(a[numberOfRowsLeft - 1][i] + " ");
        }
        numberOfRowsLeft--; // One row is processed. Decrease the number of rows to process
      }

      if (columnIndex < numberOfColumnsLeft) { // Check if there is more columns
        // Process the left most column of the columns left to process 
        for (int i = numberOfRowsLeft - 1; i >= rowIndex; i--) {
          builder.append(a[i][columnIndex] + " ");
        }
        columnIndex++;
      }
    }
    return builder.toString().trim();
  }

}
