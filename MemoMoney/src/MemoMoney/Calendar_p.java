package MemoMoney;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Calendar;

public class Calendar_p extends JFrame {
	static JPanel day = new JPanel() {
		Image background = new ImageIcon(Calendar_p.class.getResource("../Image/Calendar_p.png")).getImage(); 
		public void paintComponent(Graphics g) { 
			g.drawImage(background, 0, 0, null);    
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	static JPanel day1 = new JPanel() {
		Image background = new ImageIcon(Calendar_p.class.getResource("../Image/Calendar_p.png")).getImage(); 
		public void paintComponent(Graphics g) { 
			g.drawImage(background, 0, 0, null);
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	
	ImageIcon bBtn = new ImageIcon(Calendar_p.class.getResource("../Image/before.png"));
	ImageIcon aBtn = new ImageIcon(Calendar_p.class.getResource("../Image/after.png"));
	ImageIcon Btn = new ImageIcon(Calendar_p.class.getResource("../Image/Calendar_p.png"));
	
	ImageIcon[] dBtn = { 
			   new ImageIcon(Calendar_p.class.getResource("../Image/Calendar_p.png")), // [0]
			   new ImageIcon(Calendar_p.class.getResource("../Image/001.png")),
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
	
	ImageIcon[] cBtn = {
			new ImageIcon(MainFrame.class.getResource("../Image/Calendar_p.png")), 
			new ImageIcon(Calendar_p.class.getResource("../Image/001_c.png")),
			new ImageIcon(MainFrame.class.getResource("../Image/002_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/003_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/004_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/005_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/006_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/007_c.png")), // [0]
			   new ImageIcon(MainFrame.class.getResource("../Image/008_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/009_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/010_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/011_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/012_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/013_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/014_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/015_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/016_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/017_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/018_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/019_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/020_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/021_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/022_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/023_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/024_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/025_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/026_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/027_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/028_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/029_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/030_c.png")),
			   new ImageIcon(MainFrame.class.getResource("../Image/031_c.png")),
	};
	
	int DATE_MONTH = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int DATE_YEAR = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	String DATE_DAY = "";
	Container container = getContentPane();
	JButton backBtn = new JButton();
	JLabel J_Label = new JLabel("", JLabel.CENTER);
	JButton nextBtn = new JButton();
	JButton[] dayBtn = new JButton[49];
	
	Calendar_p(){
		container.setLayout(new BorderLayout());
		container.add("North", day);
		container.add("Center", day1);
		
		
		day1.setLayout(new GridLayout(7, 7, 10, 10));
		day.setBorder(BorderFactory.createEmptyBorder(35,0,0,0));
		day1.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
		
		for (int i = 0; i < dayBtn.length; i++) {
            final int selection = i;
            dayBtn[i] = new JButton();
            dayBtn[i].setBackground(Color.white);
            dayBtn[i].setContentAreaFilled(false);
			dayBtn[i].setBorderPainted(false);
			dayBtn[i].setFocusPainted(false);
			
            if (i < 7) {
            	dayBtn[i].setIcon(wBtn[i]);
            }
            day1.add(dayBtn[i]);
        }
		
		backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                DATE_MONTH--;
                Display_Date();
                allInit();
            }
        });
		nextBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	            DATE_MONTH++;
	            Display_Date();
	            allInit();
	        }
	    });
		for (int i = 7; i < dayBtn.length; i++) {
		    final int dayOfMonth = i - 6 - (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1);

		    // Check if the button corresponds to a valid day of the month
		    if (dayOfMonth > 0 && dayOfMonth <= Calendar.getInstance().getActualMaximum(Calendar.DATE)) {
		        final JButton button = dayBtn[i]; // dayBtn[i]를 final 변수로 복사
		        final int dayOfMonthCopy = dayOfMonth; // dayOfMonth를 복사

		        button.addMouseListener(new MouseAdapter() {
		            public void mouseEntered(MouseEvent e) {
		                button.setIcon(cBtn[dayOfMonthCopy-1]);
		            }
		        });
		        button.addMouseListener(new MouseAdapter() {
		            public void mouseExited(MouseEvent e) {
		                button.setIcon(dBtn[dayOfMonthCopy-1]);
		            }
		        });

		        button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent ae) {
		                DATE_DAY = String.valueOf(dayOfMonthCopy);
		                String selectedDate = Set_Picked_Date();
		                System.out.println("선택된 날짜: " + selectedDate);

		                // 선택된 날짜에 해당하는 Memo 인스턴스 생성
		                Memo memoPage = new Memo(selectedDate);
		                // 선택된 날짜에 대한 기존 메모 불러오기
//		                memoPage.loadMemos(selectedDate);

		                setVisible(false);
		            }
		        });


		    }
		}
    
		
		Font font = new Font("SansSerif", Font.BOLD, 35);
		J_Label.setFont(font);
		
		backBtn.setIcon(bBtn);
		nextBtn.setIcon(aBtn);
		
		/* 버튼 투명하게 */
		backBtn.setContentAreaFilled(false);
		nextBtn.setContentAreaFilled(false);
		
		/* 버튼 외곽선 삭제 */
		backBtn.setBorderPainted(false);
		nextBtn.setBorderPainted(false);
		
		/* 선택 됐을 때 버튼 외곽선 삭제 */
		backBtn.setFocusPainted(false);
		nextBtn.setFocusPainted(false);
		
		Display_Date();
		day.add(backBtn);
		day.add(J_Label);
		day.add(nextBtn);
		
		setTitle("MemoMoney");
		setSize(1290, 750);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void Display_Date() {
	    for (int i = 7; i < dayBtn.length; i++)
	        dayBtn[i].setText("");
	    java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat(
	            "MMMM yyyy");
	    java.util.Calendar Calendar = java.util.Calendar.getInstance();
	    Calendar.set(DATE_YEAR, DATE_MONTH, 1);
	    // 그 달의 1일 요일 수
	    int firstDay = Calendar.get(Calendar.DAY_OF_WEEK);
	    // 요일 수 1일 시작, 배열 0부터 시작
	    firstDay--;

	    for(int i = 1; i <= Calendar.getActualMaximum(Calendar.DATE); i++) {
	        // buttons[0] ~ [6] : 일 ~ 토
	        // buttons[7] ~     : 날짜 출력
	        dayBtn[6 + firstDay + i].setIcon(dBtn[i]);
	        dayBtn[6 + firstDay + i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	                System.out.println("선택");
	            }
	        });
	    }
	    J_Label.setText(Simple_Date_Format.format(Calendar.getTime()));
	}


	public String Set_Picked_Date() {
	        if (DATE_DAY.equals(""))
	            return DATE_DAY;
	        java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat(
	                "yyyy년 MM월 dd일");
	        java.util.Calendar Calendar = java.util.Calendar.getInstance();
	        Calendar.set(DATE_YEAR, DATE_MONTH, Integer.parseInt(DATE_DAY)-1);
	        return Simple_Date_Format.format(Calendar.getTime());
	}
	public void allInit() {
		// 버튼 날짜 지우기
		for(int i =7; i < dayBtn.length; i++) {
			dayBtn[i].setIcon(Btn);
		}
		Display_Date();
	}
	public static void main(String[] args) {
		new Calendar_p();
	}
}