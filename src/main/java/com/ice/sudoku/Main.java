package com.ice.sudoku;

public class Main {

  public static void main(String[] args) {
    System.out.println("SUDOKU SOLVER");

    final char[][] board = { //
        { '5', '3', ' ', ' ', '7', ' ', ' ', ' ', ' ' }, //
        { '6', ' ', ' ', '1', '9', '5', ' ', ' ', ' ' }, //
        { ' ', '9', '8', ' ', ' ', ' ', ' ', '6', ' ' }, //
        { '8', ' ', ' ', ' ', '6', ' ', ' ', ' ', '3' }, //
        { '4', ' ', ' ', '8', ' ', '3', ' ', ' ', '1' }, //
        { '7', ' ', ' ', ' ', '2', ' ', ' ', ' ', '6' }, //
        { ' ', '6', ' ', ' ', ' ', ' ', '2', '8', ' ' }, //
        { ' ', ' ', ' ', '4', '1', '9', ' ', ' ', '5' }, //
        { ' ', ' ', ' ', ' ', '8', ' ', ' ', '7', '9' }, //
    };

    final SudokuSolver solver = new RecursiveSudokuSolver();

    System.out.println("Tableau de depart :");
    solver.printBoard(board);

    try {
      final char[][] solvedBoard = solver.solve(board);
      System.out.println();
      System.out.println("Tableau de solution :");
      solver.printBoard(solvedBoard);
    } catch (NotResolvableException e) {
      System.out.println("This board can not be solved!");
    }

  }
}
