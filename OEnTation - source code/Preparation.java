package oentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ulise on 19/03/2017.
 */
public class Preparation{// extends Canvas {

    public Preparation(int width, int height) throws InterruptedException {

		JFrame countDownFrame = new JFrame("");
		countDownFrame.setPreferredSize(new Dimension(width, height));
		countDownFrame.setMaximumSize(new Dimension(width, height));
		countDownFrame.setMinimumSize(new Dimension(width, height));

		countDownFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		countDownFrame.setResizable(false);
		countDownFrame.setLocationRelativeTo(null);
        countDownFrame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.black);
        countDownFrame.add(panel);

		JLabel label = new JLabel();
		label.setForeground(Color.lightGray);
		label.setBounds(width/2-85, height/2-30, 400,50);
		label.setFont(new Font("Serif", Font.PLAIN, 24));
		panel.add(label);

        label.setText("Starting game...");
        int delay = 1500; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                countDownFrame.dispose();
                new OEnTation();
            }
        };
        Timer t = new Timer(delay, taskPerformer);
        t.start();
        t.setRepeats(false);
    }

}
