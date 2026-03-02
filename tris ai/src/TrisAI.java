import java.util.*;

public class TrisAI {

    static final char PLAYER = 'X';
    static final char AI = 'O';
    static final char EMPTY = ' ';

    public static void main(String[] args) {
        char[][] board = {
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };

        Scanner scanner = new Scanner(System.in);
        boolean playerTurn = true;

        while (true) {
            printBoard(board);

            if (playerTurn) {
                System.out.println("Tocca a te! Inserisci riga e colonna (0-2):");
                int r = scanner.nextInt();
                int c = scanner.nextInt();

                if (r < 0 || r > 2 || c < 0 || c > 2 || board[r][c] != EMPTY) {
                    System.out.println("Mossa non valida, riprova.");
                    continue;
                }

                board[r][c] = PLAYER;
            } else {
                System.out.println("L'AI sta pensando...");
                int[] move = bestMove(board);
                board[move[0]][move[1]] = AI;
            }

            if (checkWinner(board, PLAYER)) {
                printBoard(board);
                System.out.println("Hai vinto!");
                break;
            }

            if (checkWinner(board, AI)) {
                printBoard(board);
                System.out.println("Hai perso! L'AI ha vinto.");
                break;
            }

            if (isFull(board)) {
                printBoard(board);
                System.out.println("Pareggio!");
                break;
            }

            playerTurn = !playerTurn;
        }

        scanner.close();
    }

    // Stampa la griglia
    static void printBoard(char[][] board) {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
        System.out.println();
    }

    // Controlla se la griglia è piena
    static boolean isFull(char[][] board) {
        for (char[] row : board)
            for (char cell : row)
                if (cell == EMPTY) return false;
        return true;
    }

    // Controlla se un giocatore ha vinto
    static boolean checkWinner(char[][] board, char player) {
        // righe e colonne
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        // diagonali
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    // Trova la mossa migliore usando Minimax
    static int[] bestMove(char[][] board) {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == EMPTY) {
                    board[r][c] = AI;
                    int score = minimax(board, false);
                    board[r][c] = EMPTY;

                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = r;
                        move[1] = c;
                    }
                }
            }
        }
        return move;
    }

    // Algoritmo Minimax
    static int minimax(char[][] board, boolean isMaximizing) {
        if (checkWinner(board, AI)) return 1;
        if (checkWinner(board, PLAYER)) return -1;
        if (isFull(board)) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (board[r][c] == EMPTY) {
                        board[r][c] = AI;
                        int score = minimax(board, false);
                        board[r][c] = EMPTY;
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (board[r][c] == EMPTY) {
                        board[r][c] = PLAYER;
                        int score = minimax(board, true);
                        board[r][c] = EMPTY;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}
