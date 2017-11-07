package oentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ulise on 19/03/2017.
 */
public class Instructions {

    public Instructions(){
        JFrame f = new JFrame("Instructions");
        f.setSize(500, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.black);
        f.add(p);

        JLabel label = new JLabel(">>>     Instructions     <<<");
        label.setForeground(Color.yellow);
        label.setBounds(140, 10, 400,20);
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
        t.setText("> you are a square, use the arrow keys to move\n   (up, down, left, right);\n" +
                "> the square is flickering and disappearing, but you are\n   still controling it through the dark;\n" +
                "> the square appears back on the screen every few seconds\n   OR when you colect a dot (orange-red circle);\n" +
                "> the circles are orange at first, but they go from orange\n   to red as theyr lifetime shortens (then they dissapear);\n" +
                "> if any circle dissapears (later in the game you are allowed\n   to miss few circles) the game is over;");

        t.setBackground(Color.black);
        t.setForeground(Color.yellow);
        Font font = new Font("Serif", Font.PLAIN,18);
        t.setFont(font);

        f.setVisible(true);
    }
}
