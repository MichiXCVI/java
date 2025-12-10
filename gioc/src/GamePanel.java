import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Player player1;
    private Player player2;
    private PlatformerGame game;
    private ArrayList<Rectangle> platforms;
    private Rectangle centralPlatform;
    private boolean gameOver;
    private String winner;

    public GamePanel(PlatformerGame game) {
        this.game = game;
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        initGame();
        timer = new Timer(16, this); // ~60 FPS
        timer.start();
    }

    private void initGame() {
        // Reset dei player e piattaforme
        player1 = new Player(600, 100, Color.RED, true);
        player2 = new Player(700, 100, Color.YELLOW, false);

        platforms = new ArrayList<>();
        // piattaforma centrale ancora più grande
        centralPlatform = new Rectangle(250, 400, 800, 40);
        platforms.add(centralPlatform);

        gameOver = false;
        winner = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            player1.update(platforms);
            player2.update(platforms);

            // collisione tra i due player con spinta
            player1.resolveCollision(player2);
            player2.resolveCollision(player1);

            checkVictory();
        }
        repaint();
    }

    private void checkVictory() {
        if (player1.getY() > centralPlatform.y + 200) {
            gameOver = true;
            winner = "Player 2 vince!";
        } else if (player2.getY() > centralPlatform.y + 200) {
            gameOver = true;
            winner = "Player 1 vince!";
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // piattaforma centrale
        g.setColor(Color.GRAY);
        g.fillRect(centralPlatform.x, centralPlatform.y, centralPlatform.width, centralPlatform.height);

        // player
        player1.draw(g);
        player2.draw(g);

        // HUD
        g.setColor(Color.WHITE);
        g.drawString("P1 Vel: " + player1.getVelocityX() + "," + player1.getVelocityY() +
                " Stato: " + player1.getState(), 10, 20);
        g.drawString("P2 Vel: " + player2.getVelocityX() + "," + player2.getVelocityY() +
                " Stato: " + player2.getState(), 10, 40);

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.setColor(Color.GREEN);
            g.drawString(winner, getWidth()/2 - 150, getHeight()/2);

            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.setColor(Color.WHITE);
            g.drawString("Premi R per ricominciare", getWidth()/2 - 100, getHeight()/2 + 50);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameOver) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        } else {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                initGame(); // reset partita
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            game.showPause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.keyReleased(e);
        player2.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
