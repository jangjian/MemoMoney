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
    
    private JTextArea[] textAreas = new JTextArea[4];
    private JScrollPane[] scrollPanes = new JScrollPane[4];
   
    Memo() {
        setTitle("MemoMoney");

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        Font font = new Font("나눔손글씨 장미체", Font.PLAIN, 30);
        textArea.setFont(font);

        
        // 레이아웃 매니저 설정
        p1.setLayout(null);
        p1.add(scrollPane);
        
        scrollPane.setBounds(45,185,505,480);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        textArea.setOpaque(false);
        scrollPane.setVisible(true);
        
        for (int i = 0; i < 4; i++) {
            textAreas[i] = new JTextArea();
            textAreas[i].setFont(font);
            scrollPanes[i] = new JScrollPane(textAreas[i]);

            // Set location and size for each JScrollPane
            int x = (i < 4) ? 740 : 600;
            int y = (i % 4) * 60 + 280;
            scrollPanes[i].setBounds(x, y, 500, 40);

            // Customize JScrollPane appearance
            scrollPanes[i].setOpaque(false);
            scrollPanes[i].getViewport().setOpaque(false);
            scrollPanes[i].setBorder(null);
            textAreas[i].setOpaque(false);

            p1.add(scrollPanes[i]);
        }

        p1.setLayout(null);
        
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
