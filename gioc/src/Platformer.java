import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Platformer extends JPanel implements KeyListener, ActionListener {

    private Timer timer = new Timer(16, this);

    // Player
    private int playerX = 100;
    private int playerY = 300;
    private int playerW = 40;
    private int playerH = 60;
    private int normalH = 60;
    private int crawlH = 35;

    private int velX = 0;
    private int velY = 0;

    // Fisica
    private int SPEED = 6;
    private final int NORMAL_SPEED = 6;
    private final int RUN_SPEED = 10;
    private final int CRAWL_SPEED = 3;

    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = -15;

    // Pavimento
    private int floorY = 400;

    // Tasti
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean shiftPressed = false;
    private boolean ctrlPressed = false;

    // Stati salto/volo
    private boolean jumping = false;
    private boolean flying = false;
    private int jumpCount = 0;

    public Platformer() {
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sfondo
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Pavimento
        g.setColor(new Color(100, 200, 100));
        g.fillRect(0, floorY, getWidth(), getHeight() - floorY);

        // Player
        g.setColor(flying ? Color.CYAN : Color.BLUE);
        g.fillRect(playerX, playerY, playerW, playerH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Impostazione velocità
        if (!flying) {
            if (shiftPressed && !jumping) {    // Crawl solo a terra
                SPEED = CRAWL_SPEED;
                if (playerH != crawlH) {
                    // abbasso player
                    playerY += (normalH - crawlH);
                    playerH = crawlH;
                }
            }
            else if (ctrlPressed && !jumping) { // Corsa solo a terra
                SPEED = RUN_SPEED;
                if (playerH != normalH) {
                    playerY -= (normalH - crawlH);
                    playerH = normalH;
                }
            }
            else { // Stato normale
                SPEED = NORMAL_SPEED;
                if (playerH != normalH) {
                    playerY -= (normalH - crawlH);
                    playerH = normalH;
                }
            }
        }

        // Movimento orizzontale
        velX = 0;
        if (leftPressed) velX = -SPEED;
        if (rightPressed) velX = SPEED;

        playerX += velX;

        // Volo
        if (flying) {
            velY = 0;
            if (upPressed) playerY -= SPEED;
            if (downPressed) playerY += SPEED;
        } else {
            velY += GRAVITY;
            playerY += velY;
        }

        // Collisione con pavimento
        if (playerY + playerH >= floorY) {
            playerY = floorY - playerH;
            velY = 0;
            jumping = false;
            flying = false;
            jumpCount = 0;
        }

        // Bordi finestra
        if (playerX < 0) playerX = 0;
        if (playerX + playerW > getWidth()) playerX = getWidth() - playerW;
        if (playerY < 0) playerY = 0;

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int t = e.getKeyCode();

        switch (t) {
            case KeyEvent.VK_A -> leftPressed = true;
            case KeyEvent.VK_D -> rightPressed = true;
            case KeyEvent.VK_W -> upPressed = true;
            case KeyEvent.VK_S -> downPressed = true;
            case KeyEvent.VK_SHIFT -> shiftPressed = true;
            case KeyEvent.VK_CONTROL -> ctrlPressed = true;

            case KeyEvent.VK_SPACE -> {
                if (jumpCount == 0) {
                    velY = JUMP_STRENGTH;
                    jumping = true;
                    jumpCount = 1;
                } else if (jumpCount == 1 && !flying) {
                    flying = true;
                    jumpCount = 2;
                } else if (flying) {
                    flying = false;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int t = e.getKeyCode();

        switch (t) {
            case KeyEvent.VK_A -> leftPressed = false;
            case KeyEvent.VK_D -> rightPressed = false;
            case KeyEvent.VK_W -> upPressed = false;
            case KeyEvent.VK_S -> downPressed = false;
            case KeyEvent.VK_SHIFT -> shiftPressed = false;
            case KeyEvent.VK_CONTROL -> ctrlPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame f = new JFrame("Platformer Avanzato");
        Platformer p = new Platformer();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 500);
        f.add(p);
        f.setVisible(true);
    }
}