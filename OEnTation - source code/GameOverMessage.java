package oentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ulise on 18/03/2017.
 */
public class GameOverMessage {

    public GameOverMessage(){
        JFrame f = new JFrame("    ^_^");

        f.setSize(450, 310);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setLayout(null);
        f.add(p);

        JLabel label = new JLabel("Game over!");
        label.setBounds(145, 40, 200,50);
        label.setFont(new Font("Serif", Font.PLAIN, 32));
        p.add(label);

        JButton b1 = new JButton("Play again");
        JButton b2 = new JButton("Exit");
        b1.setBounds(70,150, 130,40);
        b2.setBounds(240,150, 130,40);
        p.add(b1);
        p.add(b2);

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Thread t = new Thread(new Runnable(){
                    public void run(){
                        JOptionPane.showMessageDialog(f, "Something went wrong!\n Your system will now explode.");
                        System.exit(0);
                    }
                });
                t.start();
            }
        });

        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        f.setVisible(true);

    }
}
