package MemoMoney;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	
	/* Page Image */
	static JPanel p1 = new JPanel() {
		Image background = new ImageIcon(MainFrame.class.getResource("../Image/Login.png")).getImage(); 
		public void paintComponent(Graphics g) { 
			g.drawImage(background, 0, 0, null);
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	
	/* TextField */
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	
	/* Button */
	JButton loginBtn = new JButton();
	JButton joinBtn = new JButton();
	
	/* Button Image */
	ImageIcon login = new ImageIcon(MainFrame.class.getResource("../Image/login_btn.png"));
	ImageIcon joinbtn = new ImageIcon(MainFrame.class.getResource("../Image/signup_btn.png"));
	
	
	Operator o = null;
	
	MainFrame(Operator _o){
		o = _o;
		
		setTitle("MemoMoney");
		
		/* TextField 크기 & 위치 */
		id.setBounds(530, 472, 200, 30);
		pw.setBounds(530, 532, 200, 30);
		
		/* TextField 편집 */
		id.setEditable(true); 
		id.setFont(new Font("Arial", Font.BOLD, 18));
		pw.setEditable(true); 
		pw.setFont(new Font("Arial", Font.BOLD, 18));
		id.setBackground(Color.getColor(getName()));
		
		/* TextField 추가 */
		p1.add(id);
		p1.add(pw);
	
		
		/* Button 이벤트 리스너 추가 */
		ButtonListener bl = new ButtonListener();
		loginBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		loginBtn.setLayout(null);
		loginBtn.setBounds(755,451,85,85);
		joinBtn.setLayout(null);
		joinBtn.setBounds(755,544,85,42);
		
		loginBtn.setIcon(login);	// 버튼 이미지
		joinBtn.setIcon(joinbtn);
		
		loginBtn.setContentAreaFilled(false);	//버튼 투명하게
		joinBtn.setContentAreaFilled(false);
		
		loginBtn.setBorderPainted(false);	// 버튼 라인 없애기
		joinBtn.setBorderPainted(false);
		
		p1.add(loginBtn);
		p1.add(joinBtn);
		
		p1.setLayout(null);//레이아웃 설정
		add(p1);   
			  
		setSize(1290, 750);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/* Button 이벤트 리스너 */
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			/* TextField에 입력된 아이디와 비밀번호를 변수에 초기화 */
			String uid = id.getText();
			String upass = "";
			for(int i=0; i<pw.getPassword().length; i++) {
				upass = upass + pw.getPassword()[i];
			}
			
			/* 회원가입 버튼 이벤트 */
			if(e.getSource()==joinBtn) {
				o.jf.setVisible(true);
			}
			
			/* 로그인 버튼 이벤트 */
			else if(e.getSource()==loginBtn) {
				if(uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("로그인 실패 > 로그인 정보 미입력");
				}
				
				else if(uid != null && upass != null) {
					if(o.db.logincheck(uid, upass)) {	//이 부분이 데이터베이스에 접속해 로그인 정보를 확인하는 부분이다.
						System.out.println("로그인 성공");
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
						 new Calendar_p();
						 setVisible(false);
						
					} else {
						System.out.println("로그인 실패 > 로그인 정보 불일치");
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
					}
				}
			}
		}
	}
}
