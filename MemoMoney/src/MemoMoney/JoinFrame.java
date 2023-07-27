package MemoMoney;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JoinFrame extends JFrame {
	/* Panel */
	
	static JPanel join_p = new JPanel() {
		Image background = new ImageIcon(MainFrame.class.getResource("../Image/join_p.png")).getImage(); 
		public void paintComponent(Graphics g) { 
			g.drawImage(background, 0, 0, null);
			setOpaque(false); 
			super.paintComponent(g);
		}
	};
	
	ImageIcon pwcbtn = new ImageIcon(MainFrame.class.getResource("../Image/pwc_btn.png"));
	ImageIcon joinbtn = new ImageIcon(MainFrame.class.getResource("../Image/join_btn.png"));
	
	
	/* TextField */
	JTextField name = new JTextField();
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	JPasswordField pwc = new JPasswordField();
	
	/* Button */
	JButton joinBtn = new JButton();
	JButton pwcBtn = new JButton();
	
	Operator o = null;
	
	JoinFrame(Operator _o) {
		o = _o;
		
		setTitle("회원가입");
		
		/* TextField 크기 작업 */
		name.setBounds(80, 26, 140, 30);
		id.setBounds(80, 76, 140, 30);
		pw.setBounds(80, 126, 140, 30);
		pwc.setBounds(112, 170, 105, 30);

	
		/* Button 크기 작업 */
		joinBtn.setBounds(123, 210, 95, 32);
		pwcBtn.setBounds(15, 210, 95, 32);
		
		pwcBtn.setIcon(pwcbtn);
		joinBtn.setIcon(joinbtn);
		
		pwcBtn.setContentAreaFilled(false);
		joinBtn.setContentAreaFilled(false);
		
		pwcBtn.setBorderPainted(false);
		joinBtn.setBorderPainted(false);
		
	
		/* Panel 추가 작업 */
		join_p.add(name);
		join_p.add(id);
		join_p.add(pw);
		join_p.add(pwc);
		join_p.add(pwcBtn);
		join_p.add(joinBtn);
		join_p.setLayout(null);//레이아웃 설정
		add(join_p);  
		
		
		/* Button 이벤트 리스너 추가 */
		ButtonListener bl = new ButtonListener();
		joinBtn.addActionListener(bl);
		pwcBtn.addActionListener(bl);
		
		setSize(250, 300);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	/* Button 이벤트 리스너 */
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			/* TextField에 입력된 회원 정보들을 변수에 초기화 */
			String uid = name.getText();
			String uid1 = id.getText();
			String pass = pw.getText();
			String passC = pwc.getText();
			String upass = "";
			for(int i=0; i<pw.getPassword().length; i++) {
				upass = upass + pw.getPassword()[i];
			}
			
			/* 비밀번호 확인 버튼 이벤트 */
			if(e.getSource()==pwcBtn) {
				if(passC.equals(" ")) {
					JOptionPane.showMessageDialog(null, "비교할 비밀번호를 입력해 주시기 바랍니다");
				} else if(!pass.equals(passC)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
				} else if(pass.equals(passC)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
				}
			}
			
			
			/* 가입하기 버튼 이벤트 */
			else if(e.getSource()==joinBtn) {
				if(uid.equals("") || upass.equals("")|| uid1.equals("")||passC.equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("회원가입 실패 > 회원정보 미입력");
				}else if(!pass.equals(passC)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
				}
				
				else if(!uid.equals("") && !upass.equals("")&& !uid1.equals("")&& !passC.equals("")) {
					if(o.db.joinCheck(uid, upass, uid1)) {
						JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");
						id.setText("");
						pw.setText("");
					}
				}
				
			}
		}
	}
}