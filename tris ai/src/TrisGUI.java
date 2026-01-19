import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrisGUI extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[3][3];
    private char[][] board = new char[3][3];

    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';
    private static final char EMPTY = ' ';

    private int mode = 1; // 0 = AI vs AI, 1 = Player vs AI, 2 = Player vs Player
    private boolean player1Turn = true;

    private Thread aiThread; // unica thread AI

    public TrisGUI() {
        askPlayers();

        setTitle("Tris con AI");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c] = new JButton("");
                buttons[r][c].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[r][c].addActionListener(this);
                add(buttons[r][c]);
                board[r][c] = EMPTY;
            }
        }

        setVisible(true);

        if (mode == 0) startAiVsAi();
    }

    private void askPlayers() {
        String[] options = {"0 (AI vs AI)", "1 (Tu vs AI)", "2 (Giocatore vs Giocatore)"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Quanti giocatori?",
                "Seleziona modalità",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );

        mode = choice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (mode == 0) return; // AI vs AI → nessun click

        JButton btn = (JButton) e.getSource();

        int r = -1, c = -1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (buttons[i][j] == btn) { r = i; c = j; }

        if (board[r][c] != EMPTY) return;

        if (mode == 2) {
            board[r][c] = player1Turn ? PLAYER1 : PLAYER2;
            buttons[r][c].setText(String.valueOf(board[r][c]));
            if (checkEnd(false)) return;
            player1Turn = !player1Turn;
        } else {
            board[r][c] = PLAYER1;
            buttons[r][c].setText("X");
            if (checkEnd(false)) return;

            int[] move = bestMove(PLAYER2, PLAYER1);
            board[move[0]][move[1]] = PLAYER2;
            buttons[move[0]][move[1]].setText("O");
            checkEnd(false);
        }
    }

    private boolean checkEnd(boolean aiMode) {
        if (checkWinner(PLAYER1)) {
            if (!aiMode) JOptionPane.showMessageDialog(this, "Giocatore X ha vinto!");
            reset();
            return true;
        }
        if (checkWinner(PLAYER2)) {
            if (!aiMode) JOptionPane.showMessageDialog(this, "Giocatore O ha vinto!");
            reset();
            return true;
        }
        if (isFull()) {
            if (!aiMode) JOptionPane.showMessageDialog(this, "Pareggio!");
            reset();
            return true;
        }
        return false;
    }

    private void reset() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++) {
                board[r][c] = EMPTY;
                buttons[r][c].setText("");
            }

        player1Turn = true;
    }

    private void startAiVsAi() {
        aiThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(300); // delay fisso

                    int[] move = bestMove(player1Turn ? PLAYER1 : PLAYER2,
                            player1Turn ? PLAYER2 : PLAYER1);

                    board[move[0]][move[1]] = player1Turn ? PLAYER1 : PLAYER2;
                    buttons[move[0]][move[1]].setText(String.valueOf(board[move[0]][move[1]]));

                    if (checkWinner(PLAYER1) || checkWinner(PLAYER2)) {
                        // NON dovrebbe mai succedere con Minimax perfetto
                        JOptionPane.showMessageDialog(this, "BUG: un'AI ha vinto!");
                        reset();
                    }

                    if (isFull()) {
                        reset(); // pareggio → reset silenzioso
                    }

                    player1Turn = !player1Turn;
                }
            } catch (Exception ignored) {}
        });

        aiThread.start();
    }

    private boolean isFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == EMPTY) return false;
        return true;
    }

    private boolean checkWinner(char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;
        return false;
    }

    private int[] bestMove(char ai, char opponent) {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == EMPTY) {
                    board[r][c] = ai;
                    int score = minimax(false, ai, opponent);
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

    private int minimax(boolean isMax, char ai, char opponent) {
        if (checkWinner(ai)) return 1;
        if (checkWinner(opponent)) return -1;
        if (isFull()) return 0;

        if (isMax) {
            int best = Integer.MIN_VALUE;
            for (int r = 0; r < 3; r++)
                for (int c = 0; c < 3; c++)
                    if (board[r][c] == EMPTY) {
                        board[r][c] = ai;
                        best = Math.max(best, minimax(false, ai, opponent));
                        board[r][c] = EMPTY;
                    }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int r = 0; r < 3; r++)
                for (int c = 0; c < 3; c++)
                    if (board[r][c] == EMPTY) {
                        board[r][c] = opponent;
                        best = Math.min(best, minimax(true, ai, opponent));
                        board[r][c] = EMPTY;
                    }
            return best;
        }
    }

    public static void main(String[] args) {
        new TrisGUI();
    }
}
