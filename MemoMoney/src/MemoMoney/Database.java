package MemoMoney;

import java.sql.*;

public class Database {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/memomoney?serverTimezone=Asia/Seoul";	
	String user = "root";
	String passwd = "1011";	

	Database() {//데이터베이스에 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			System.out.println("MySQL 서버 연동 성공");
		} catch(Exception e) {
			System.out.println("MySQL 서버 연동 실패 > " + e.toString());
		}		
	}
	//로그인 정보 확인
	boolean logincheck(String _i, String _p) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		
		try { //member 테이블에서 password와 id를 조회
			String checkingStr = "SELECT password FROM member WHERE id='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				if(pw.equals(result.getString("password"))) { //입력한 password와 db의 password를 비교
					flag = true;
				}	
				else {
					flag = false;
				}
				count++;
			}
		} catch(Exception e) {
			flag = false;
			System.out.println("로그인 실패 > " + e.toString());
		}		
		return flag;
	}
	boolean joinCheck(String _i, String _p, String _n) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		String name = _n;
			
		try {
			String insertStr = "INSERT INTO member VALUES('" + name + "', '" + pw + "', '" + id + "')";
			stmt.executeUpdate(insertStr);
				
			flag = true;
		} catch(Exception e) {
			flag = false;
			System.out.println("회원가입 실패 > " + e.toString());
		}
			
		return flag;
	}
}