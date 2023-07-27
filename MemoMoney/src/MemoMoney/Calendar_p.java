package MemoMoney;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.GregorianCalendar;
import javax.swing.*;

import MemoMoney.CalendarFunction;

class Calendarmain extends JFrame implements ActionListener{
	static JPanel day = new JPanel() {
		Image background = new ImageIcon(MainFrame.class.getResource("../Image/Calendar_p.png")).getImage(); 
		public void paintComponent(Graphics g) { 
			g.drawImage(background, 0, 0, null);
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	static JPanel day1 = new JPanel() {
		Image background = new ImageIcon(MainFrame.class.getResource("../Image/Calendar_p.png")).getImage(); 
		public void paintComponent(Graphics g) { 
			g.drawImage(background, 0, 0, null);
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	
	ImageIcon dBtn = new ImageIcon(MainFrame.class.getResource("../Image/test.png"));

	Container container = getContentPane();
	
	JButton beforeBtn = new JButton("Before");
	JButton afterBtn = new JButton("After");
	
	JLabel label = new JLabel("00년 0월");
	
	JButton[] dayBtn = new JButton[49];
	String[] dayNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	
	CalendarFunction cF = new CalendarFunction();
	
	public Calendarmain() {
		setTitle("만년 달력");
		setSize(1280, 720);
		init();
		start();
		setVisible(true);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", day);
		day.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		day1.setBorder(BorderFactory.createEmptyBorder(30,100,50,100));
		container.add("Center", day1);
		 
		day.setLayout(new FlowLayout());
		day.add(afterBtn);
		day.add(label);
		day.add(beforeBtn);
		 
		
		
		Font font = new Font("SansSerif", Font.BOLD, 35);
		afterBtn.setFont(font);
		beforeBtn.setFont(font);
		label.setFont(font);
		 
		label.setText(cF.getCalText());
		 
		day1.setLayout(new GridLayout(7, 7, 10, 10));
	    for(int i = 0; i < dayBtn.length; i++) {
	    	dayBtn[i] = new JButton();
			day1.add(dayBtn[i]);
			 
			dayBtn[i].setContentAreaFilled(false);
			 
			 if(i < 7) dayBtn[i].setText(dayNames[i]); 
			 
			if(i%7 == 0) dayBtn[i].setForeground(Color.RED);
			if(i%7 == 6) dayBtn[i].setForeground(Color.BLUE);
		}
		 
			
		cF.setButtons(dayBtn);
		cF.calSet();
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		afterBtn.addActionListener(this);
		beforeBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int gap = 0;
		if(e.getSource() == afterBtn) {				// 1달 후
			gap = 1;
		} else if(e.getSource() == beforeBtn ) {		// 1달 전
			gap = -1;
		}
		cF.allInit(gap);
		label.setText(cF.getCalText());		// 년월 글자 갱신		
	}	
	public static void main(String[] args){
		new Calendarmain();
	}
}

