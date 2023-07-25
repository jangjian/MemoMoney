package NoName;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	
	/* TextField */
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	
	/* Button */
	JButton loginBtn = new JButton("로그인");
	JButton joinBtn = new JButton("회원가입");
	JButton exitBtn = new JButton("프로그램 종료");
	
	static JPanel p1 = new JPanel() {
		Image background = new ImageIcon(MainFrame.class.getResource("../Image/test.jpg")).getImage(); 
		public void paintComponent(Graphics g) {
			g.drawImage(background, 0, 0, null);
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	
	Operator o = null;
	
	MainFrame(Operator _o){
		o = _o;
		
		/* TextField 크기 작업 */
		id.setPreferredSize(new Dimension(140, 30));
		pw.setPreferredSize(new Dimension(140, 30));
		
		/* TextField 크기 & 위치 */
		id.setBounds(510, 462, 200, 30);
		pw.setBounds(510, 502, 200, 30);   
		
		/* TextField 편집 */
		id.setEditable(true); 
		id.setFont(new Font("Arial", Font.BOLD, 18));
		pw.setEditable(true); 
		pw.setFont(new Font("Arial", Font.BOLD, 18));
		
		/* TextField 추가 */
		p1.add(id);
		p1.add(pw);
		
		/* Button 크기 작업 */
		loginBtn.setPreferredSize(new Dimension(75, 63));
		joinBtn.setPreferredSize(new Dimension(135, 25));
		exitBtn.setPreferredSize(new Dimension(135, 25));
		
		/* Button 이벤트 리스너 추가 */
		ButtonListener bl = new ButtonListener();
		
		loginBtn.addActionListener(bl);
		exitBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		p1.setBounds(0, 0, 1280, 720);//페이지1의 위치 설정
		p1.setLayout(null);//레이아웃 설정
		add(p1);   
			  
		setSize(1280, 720);
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
			
			/* 프로그램 종료 버튼 이벤트 */
			if(b.getText().equals("프로그램 종료")) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
			/* 회원가입 버튼 이벤트 */
			else if(b.getText().equals("회원가입")) {
				
			}
			
			/* 로그인 버튼 이벤트 */
			else if(b.getText().equals("로그인")) {
				if(uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("로그인 실패 > 로그인 정보 미입력");
				}
				
				else if(uid != null && upass != null) {
//					if(o.db.logincheck(uid, upass)) {	//이 부분이 데이터베이스에 접속해 로그인 정보를 확인하는 부분이다.
//						System.out.println("로그인 성공");
//						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
//					} else {
//						System.out.println("로그인 실패 > 로그인 정보 불일치");
//						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
//					}
				}
			}
		}
	}
}
