package MemoMoney;

import MemoMoney.MainFrame;
import MemoMoney.Operator;

public class Operator {
	Database db = null;
	MainFrame mf = null;
	
	public static void main(String[] args) {
		Operator opt = new Operator();
		opt.db = new Database();
		opt.mf = new MainFrame(opt);
	}
}
