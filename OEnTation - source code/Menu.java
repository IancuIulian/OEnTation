package oentation;

import com.sun.org.apache.bcel.internal.generic.Instruction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static oentation.OEnTation.HEIGHT;
import static oentation.OEnTation.WIDTH;

/**
 * Created by ulise on 19/03/2017.
 */

public class Menu {
    public Menu(){
        JFrame f = new JFrame("OEnTation");

        f.setSize(500, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.black);
        f.add(p);

        JLabel label = new JLabel(">>>   Welcome to OEnTation   <<<");
        label.setForeground(Color.lightGray);
        label.setBounds(70, 40, 400,50);
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        p.add(label);

        JButton bPlay = new JButton("Play");
        JButton bExit = new JButton("Exit");
        JButton bStory = new JButton("Story");
        JButton bInstructions = new JButton("Instructions");
        bPlay.setBounds(175,150, 130,40);
        bExit.setBounds(300,370, 130,40);
        bStory.setBounds(55,370,130,40);
        bInstructions.setBounds(175,280, 130,40);

        p.add(bPlay);
        p.add(bExit);
        p.add(bStory);
        p.add(bInstructions);

        bPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            f.dispose();
            try {
                new Preparation(WIDTH, HEIGHT);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            }
        });

        bExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        bStory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            f.dispose();
            new Story();
            }
        });

        bInstructions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.dispose();
                new Instructions();
            }
        });

        f.setVisible(true);
    }
}
