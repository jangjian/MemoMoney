package MemoMoney;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.GregorianCalendar;
import javax.swing.*;

import MemoMoney.CalendarFunction;

class Calendarmain extends JFrame implements ActionListener{
	static JPanel bg = new JPanel() {
		Image background = new ImageIcon(MainFrame.class.getResource("../Image/Calendar_p.png")).getImage(); 
		public void paintComponent(Graphics g) { 
			g.drawImage(background, 0, 0, null);
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	
	Container container = getContentPane();
	
	JButton buttonBefore = new JButton("Before");
	JButton buttonAfter = new JButton("After");
	
	JLabel label = new JLabel("00년 0월");
	
	JButton[] buttons = new JButton[49];
	String[] dayNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	
	CalendarFunction cF = new CalendarFunction();
	
	public Calendarmain() {
		bg.setLayout(null);//레이아웃 설정
		add(bg);   
		
		setTitle("만년 달력");
		setSize(1280, 720);
		setLocation(0, 0);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		 
		 bg.setLayout(new FlowLayout());
		 bg.add(buttonBefore);
		 bg.add(label);
		 bg.add(buttonAfter);
		 
		 Font font = new Font("SansSerif", Font.BOLD, 20);
		 buttonAfter.setFont(font);
		 buttonBefore.setFont(font);
		 label.setFont(font);
		 
		 label.setText(cF.getCalText());
		 
		 bg.setLayout(new GridLayout(7, 7, 5, 5));
		 for(int i = 0; i < buttons.length; i++) {
			 buttons[i] = new JButton();
			 bg.add(buttons[i]);
			 
			 buttons[i].setFont(new Font("SansSerif", Font.BOLD, 24));
			 
			 if(i < 7) buttons[i].setText(dayNames[i]); 
			 
			 if(i%7 == 0) buttons[i].setForeground(Color.RED);
			 if(i%7 == 6) buttons[i].setForeground(Color.BLUE);
		 }
		 cF.setButtons(buttons);
		 cF.calSet();
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonAfter.addActionListener(this);
		buttonBefore.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int gap = 0;
		if(e.getSource() == buttonAfter) {				// 1달 후
			gap = 1;
		} else if(e.getSource() == buttonBefore ) {		// 1달 전
			gap = -1;
		}
		cF.allInit(gap);
		label.setText(cF.getCalText());		// 년월 글자 갱신		
	}	
	public static void main(String[] args){
		new Calendarmain();
	}
}

