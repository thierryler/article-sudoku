package com.ice.sudoku;

public class RecursiveSudokuSolver implements SudokuSolver {

  @Override
  public char[][] solve(final char[][] board) throws NotResolvableException {

    final char[][] copy = copyOfBoard(board);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (copy[i][j] == ' ') {
          for (int idx = 0; idx < 9; idx++) {
            final char value = POSSIBLE_CHARACTERS[idx];
            if (isCorrectAt(value, i, j, copy)) {
              copy[i][j] = value;

              try {
                return solve(copy);
              } catch (final NotResolvableException e) {
                copy[i][j] = ' ';
              }
            }

          }
          throw new NotResolvableException("The for loop is over!");
        }
      }
    }

    return copy;
  }

}
