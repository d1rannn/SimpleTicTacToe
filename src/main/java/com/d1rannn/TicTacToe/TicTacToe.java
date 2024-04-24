package com.d1rannn.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public final String[][] board;
    private int count;

    public TicTacToe() {
        board = new String[3][3];
        initBoard();
        count = 0;
    }

    private void initBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "-";
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(int x, int y) {
        if (x < 1 || x > 3 || y < 1 || y > 3 || !board[x - 1][y - 1].equals("-")) {
            System.out.println("Invalid move. Try again.");
            return;
        }

        board[x - 1][y - 1] = checkWhoMove() ? "X" : "O";
        count++;
    }

    public boolean checkWhoMove() {
        return count % 2 == 0;
    }

    public boolean isWon() {
        return          // проверка X по вертикали
                        ((board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) ||
                        (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) ||
                        (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) ||
                        // проверка Х по горизонтали
                        (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) ||
                        (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) ||
                        (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) ||
                        // проверка Х по диагонали
                        (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) ||
                        (board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X")) ||
                        // проверка О по вертикали
                        (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) ||
                        (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) ||
                        (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) ||
                        // проверка О по горизонтали
                        (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) ||
                        (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) ||
                        (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) ||
                        // проверка О по диагонали
                        (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) ||
                        (board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals("O")));
    }

    public void gameloop(Scanner scanner) {
        System.out.println("Welcome to TicTaoToe mini game!\n");
        System.out.println("""
                Coordinates are
                  1 2 3 
                1 - - -
                2 - - - 
                3 - - -
                
                For example: 1 1
                  1 2 3 
                1 X - -
                2 - - - 
                3 - - -
                """);

        while (!isWon()) {
            System.out.printf("Please enter move Player %d%n", checkWhoMove() ? 1 : 2);
            makeMove(scanner.nextInt(), scanner.nextInt());

            printBoard();

            if (isWon()) {
                System.out.printf("Congratulations, Player %d!!!%n", !checkWhoMove() ? 1 : 2);
                break;
            } else if (count == 9) {
                System.out.println("It's a draw!");
                break;
            }
        }
    }
}
