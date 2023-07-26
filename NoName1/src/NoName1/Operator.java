package NoName1;

import NoName1.MainFrame;
import NoName1.Operator;

public class Operator {
	MainFrame mf = null;
	
	public static void main(String[] args) {
		Operator opt = new Operator();
		opt.mf = new MainFrame(opt);
	}  
}
