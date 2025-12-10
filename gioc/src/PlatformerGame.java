import javax.swing.*;

public class PlatformerGame {
    private JFrame frame;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private PausePanel pausePanel;

    public PlatformerGame() {
        frame = new JFrame("Platformer Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1330, 768); // risoluzione aggiornata
        frame.setLocationRelativeTo(null);

        // Inizializza i pannelli
        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(this);
        pausePanel = new PausePanel(this);

        // Mostra il menu iniziale
        frame.setContentPane(menuPanel);
        frame.setVisible(true);
    }

    // Torna al menu principale
    public void showMenu() {
        frame.setContentPane(menuPanel);
        frame.revalidate();
    }

    // Avvia il gioco
    public void showGame() {
        frame.setContentPane(gamePanel);
        gamePanel.requestFocusInWindow();
        frame.revalidate();
    }

    // Mostra il menu pausa
    public void showPause() {
        frame.setContentPane(pausePanel);
        frame.revalidate();
    }

    // Metodo main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlatformerGame::new);
    }
}
