import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;

class EksempelGui {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e ) {
            System.err.println(e);
        }

        JFrame vindu = new JFrame("Hei");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setSize(400, 400);

        JLabel tekst = new JLabel("Er Lennard vedens beste gruppelærer?");
        JButton trueKnapp = new JButton("Ja");
        JButton falseKnapp = new JButton("Nei");

        JPanel knappPanel = new JPanel();
        vindu.add(knappPanel);

        falseKnapp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setRandomPosition(falseKnapp, knappPanel.getHeight(), knappPanel.getWidth());
            }
        });

        JPanel panel = new JPanel();
        panel.add(tekst);
        knappPanel.add(trueKnapp);
        knappPanel.add(falseKnapp);
        vindu.add(panel, BorderLayout.NORTH);
        vindu.setVisible(true);
        vindu.setLocationRelativeTo(null);
    }
    public static void setRandomPosition(JButton button, int height, int width) {
        Random r = new Random();
        int h = r.nextInt(height - button.getHeight());
        int w = r.nextInt(width - button.getWidth());
        System.out.println("height: " + h +  " width: " + w);
        button.setBounds(h, w, button.getWidth(), button.getHeight());
    }
}