import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {
    public MenuPanel(PlatformerGame game) {
        setLayout(new GridBagLayout());
        JButton playButton = new JButton("Play");
        JButton controlsButton = new JButton("Controls");
        JButton quitButton = new JButton("Quit");

        playButton.addActionListener(e -> game.showGame());
        controlsButton.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Controls:\nArrow keys = Move\nSpace = Jump\nQ = Dash\nESC = Pause"));
        quitButton.addActionListener(e -> System.exit(0));

        add(playButton);
        add(controlsButton);
        add(quitButton);
    }
}
