package com.d1rannn.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.gameloop(scanner);
    }
}
