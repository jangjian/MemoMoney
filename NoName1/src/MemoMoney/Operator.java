package MemoMoney;

import MemoMoney.MainFrame;
import MemoMoney.Operator;

public class Operator {
	MainFrame mf = null;
	
	public static void main(String[] args) {   
		Operator opt = new Operator();
		opt.mf = new MainFrame(opt);
	}  
}
  