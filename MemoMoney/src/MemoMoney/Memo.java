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

    Memo() {
        setTitle("MemoMoney");

        JPanel memo = new JPanel();
        memo.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        memo.add(textArea, BorderLayout.CENTER);
        
        memo.setBounds(0,0 , 650, 750);;

        p1.add(memo);

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
