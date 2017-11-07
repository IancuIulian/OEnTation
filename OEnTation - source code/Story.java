package oentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ulise on 20/03/2017.
 */
public class Story {

    public Story(){
        JFrame f = new JFrame("Story");
        f.setSize(500, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.black);
        f.add(p);

        JLabel label = new JLabel(">>>     Story     <<<");
        label.setForeground(Color.yellow);
        label.setBounds(165, 10, 400,20);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        p.add(label);

        JButton bBack = new JButton("Back");
        bBack.setBounds(180,410,130,40);

        p.add(bBack);

        bBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println("dispose();\nnew Menu();");
                f.dispose();
                new Menu();
            }
        });

        JTextArea t = new JTextArea();
        t.setBounds(10,35,460,400);
        p.add(t);
        t.setEditable(false);

        //too lazy to write from a file :P
        t.setText("> you are a lost member of an interstellar project and your\n   ship is running out of fuel;\n" +
                "> disoriented due to the lack of vision, you are wandering\n   through the darky space; you observe a powerful source\n   of light, it appears to be some kind of merged star dust\n   from another dimension;\n" +
                "> there are more than one! but wait.. they turn red and\n   disappear after a while..\n" +
                "> the ship has small boosts of energy, letting you get to one\n   of the lights; you note that these give you a little energy;\n" +
                "> your hope is rising like the dawn, you start collecting more\n   and more star dust, trying to guess your position as you\n pierce the darkness;\n" +
                "> will you find your lost colleagues?\n" +
                "> will you get back to earth?");
        t.setBackground(Color.black);
        t.setForeground(Color.yellow);
        Font font = new Font("Serif", Font.PLAIN,18);
        t.setFont(font);

        f.setVisible(true);
    }
}
