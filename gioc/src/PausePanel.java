import javax.swing.*;
import java.awt.*;

public class PausePanel extends JPanel {
    public PausePanel(PlatformerGame game) {
        setLayout(new GridBagLayout());
        JButton continueButton = new JButton("Continue");
        JButton menuButton = new JButton("Menu");
        JButton quitButton = new JButton("Quit");

        continueButton.addActionListener(e -> game.showGame());
        menuButton.addActionListener(e -> game.showMenu());
        quitButton.addActionListener(e -> System.exit(0));

        add(continueButton);
        add(menuButton);
        add(quitButton);
    }
}
