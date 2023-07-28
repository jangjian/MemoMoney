package MemoMoney;

import java.util.Calendar;
import javax.swing.*;

import MemoMoney.JoinFrame.ButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class CalendarFunction extends JFrame implements ActionListener {
	JButton[] buttons;
	
	ImageIcon[] dBtn = { // ImageIcon 클래스 객체 images를 배열로 선언합니다.
			   new ImageIcon(MainFrame.class.getResource("../Image/Calendar_p.png")), // [0]
			   new ImageIcon(MainFrame.class.getResource("../Image/001.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/002.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/003.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/004.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/005.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/006.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/007.png")), // [0]
			   new ImageIcon(MainFrame.class.getResource("../Image/008.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/009.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/010.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/011.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/012.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/013.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/014.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/015.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/016.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/017.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/018.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/019.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/020.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/021.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/022.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/023.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/024.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/025.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/026.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/027.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/028.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/029.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/030.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/031.png")),
			 };
	
	ImageIcon[] wBtn = {
			   new ImageIcon(MainFrame.class.getResource("../Image/su.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/mo.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/tu.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/we.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/th.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/fr.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/sa.png")),	
	};
	ImageIcon Btn = new ImageIcon(MainFrame.class.getResource("../Image/Calendar_p.png"));
	
	Calendar cal = Calendar.getInstance();
	int year, month;
	
	

	public CalendarFunction() {
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
	}
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	// Label -> 0000년 00월 문자열 리턴
	public String getCalText() {
		return year + "년" + "    "+  month + "월";
	}
	// 버튼 날짜 출력
	public void calSet() {
		// calendar 객체 날짜 1일 설정
		cal.set(year, month-1, 1);
		
		// 그 달의 1일 요일 수
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		// 요일 수 1일 시작, 배열 0부터 시작
		firstDay--;
		for(int i = 0; i<7; i++) {
			buttons[i].setIcon(wBtn[i]);
		}
		
		for(int i = 1; i <= cal.getActualMaximum(cal.DATE); i++) {
			// buttons[0] ~ [6] : 일 ~ 토
			// buttons[7] ~     : 날짜 출력
			buttons[6 + firstDay + i].setIcon(dBtn[i]);
			buttons[6 + firstDay + i].addActionListener(this);
		}			
		
	}
	// 달력 새로운 년월 출력
	public void allInit(int gap) {
		// 버튼 날짜 지우기
		for(int i =7; i < buttons.length; i++) {
			buttons[i].setText("");
			buttons[i].setIcon(Btn);
		}
		month += gap;
		if(month <= 0) {
			year--;
			month = 12;
		} else if(month >= 13) {
			year++;
			month = 1;
		}
		calSet();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		calSet();
	}		
}

