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

	Container container = getContentPane();
	
	JButton beforeBtn = new JButton();
	JButton afterBtn = new JButton();
	
	JLabel label = new JLabel("00년 0월");
	
	JButton[] dayBtn = new JButton[49];
	
	ImageIcon bBtn = new ImageIcon(MainFrame.class.getResource("../Image/before.png"));
	ImageIcon aBtn = new ImageIcon(MainFrame.class.getResource("../Image/after.png"));
	
	CalendarFunction cF = new CalendarFunction();
	
	public Calendarmain() {
		setTitle("MemoMoney");
		setSize(1280, 720);
		init();
		start();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", day);
		container.add("Center", day1);
		
		/* 공백 추가 */
		day.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		day1.setBorder(BorderFactory.createEmptyBorder(30,100,50,100));
		 
		day.setLayout(new FlowLayout());
		day.add(beforeBtn);
		day.add(label);
		day.add(afterBtn);
		
		Font font = new Font("SansSerif", Font.BOLD, 35);
		label.setFont(font);
		
		/* 버튼 이미지 추가 */
		beforeBtn.setIcon(bBtn);
		afterBtn.setIcon(aBtn);
		
		/* 버튼 투명하게 */
		beforeBtn.setContentAreaFilled(false);
		afterBtn.setContentAreaFilled(false);
		
		/* 버튼 외곽선 삭제 */
		beforeBtn.setBorderPainted(false);
		afterBtn.setBorderPainted(false);
		
		/* 선택 됐을 때 버튼 외곽선 삭제 */
		beforeBtn.setFocusPainted(false);
		afterBtn.setFocusPainted(false);
		
		label.setText(cF.getCalText());
		
		 
		day1.setLayout(new GridLayout(7, 7, 10, 10));
	    for(int i = 0; i < dayBtn.length; i++) {
	    	dayBtn[i] = new JButton();
			day1.add(dayBtn[i]);
			 
			dayBtn[i].setContentAreaFilled(false);
			dayBtn[i].setBorderPainted(false);
			dayBtn[i].setFocusPainted(false);
			 
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

