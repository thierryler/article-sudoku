package com.ice.sudoku;

public interface SudokuSolver {

  char[] POSSIBLE_CHARACTERS = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

  /**
   * Calcule une solution pour le tableau indique.
   * 
   * Note : Il est possible qu'il y ait plusieurs solutions. Cette méthode se
   * contente d'en renvoyer une.
   * 
   * @param board
   * @return
   * @throws NotResolvableException si le tableau n'a pas de solution.
   */
  char[][] solve(final char[][] board) throws NotResolvableException;

  /**
   * Affiche le tableau dans la console.
   * 
   * @param board
   */
  default void printBoard(final char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (i % 3 == 0) {
        System.out.println("-------------");
      }
      for (int j = 0; j < 9; j++) {
        if (j % 3 == 0) {
          System.out.print('|');
        }
        System.out.print(board[i][j]);
      }
      System.out.println("|");
    }
    System.out.println("-------------");
  }

  /**
   * Indique si la valeur est deja dans la ligne.
   * 
   * @param value
   * @param board
   * @param rowIndex
   * @return
   */
  default boolean isValueInRow(final char value, final int rowIndex, final char[][] board) {
    for (int j = 0; j < 9; j++) {
      if (board[rowIndex][j] == value) {
        return true;
      }
    }
    return false;
  }

  /**
   * Indique si la valeur est deja dans la colonne.
   * 
   * @param value
   * @param board
   * @param columnIndex
   * @return
   */
  default boolean isValueInColumn(final char value, final int columnIndex, final char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (board[i][columnIndex] == value) {
        return true;
      }
    }
    return false;
  }

  /**
   * Indique si la valeur est deja dans le bloc.
   * 
   * @param value
   * @param board
   * @param rowIndex
   * @param columnIndex
   * @return
   */
  default boolean isValueInBlock(final char value, final int rowIndex, final int columnIndex, final char[][] board) {
    final int blockTopRowIndex = rowIndex - rowIndex % 3;
    final int blockLeftColumnIndex = columnIndex - columnIndex % 3;

    for (int i = blockTopRowIndex; i < blockTopRowIndex + 3; i++) {
      for (int j = blockLeftColumnIndex; j < blockLeftColumnIndex + 3; j++) {
        if (board[i][j] == value) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Indique si une valeur peut etre utilisee dans le tableau a la position
   * indiquee
   * 
   * @param value
   * @param rowIndex
   * @param columnIndex
   * @param board
   * @return
   */
  default boolean isCorrectAt(final char value, final int rowIndex, final int columnIndex, final char[][] board) {
    return !isValueInRow(value, rowIndex, board) // Pas sur la ligne
        && !isValueInColumn(value, columnIndex, board) // Pas sur la colonne
        && !isValueInBlock(value, rowIndex, columnIndex, board); // Pas sur le bloc
  }

  /**
   * Fait une copie du tableau.
   * 
   * @param board
   * @return
   */
  default char[][] copyOfBoard(final char[][] board) {
    final char[][] copy = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        copy[i][j] = board[i][j];
      }
    }
    return copy;
  }

}
