package MemoMoney;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Memo extends JFrame {
    static JPanel p1 = new JPanel() {
        Image background = new ImageIcon(Memo.class.getResource("../Image/Memo_p.png")).getImage();
        public void paintComponent(Graphics g) {
            g.drawImage(background, 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
        }
    };
    // km
    Memo() {
        setTitle("MemoMoney");

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20,30,600,700);
        p1.add(scrollPane);
        scrollPane.setVisible(true);
        
        add(p1);
        setSize(1290, 750);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Memo();
    }
}
