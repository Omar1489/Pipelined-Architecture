
public class ALU {
	public static String addOp(String Operand1 , String Operand2) {
		String out = "";
		int Operand1Dec = convertToDecimal(Operand1);
		int Operand2Dec = convertToDecimal(Operand2);
		int outDec = Operand1Dec + Operand2Dec;
		String zeros = "";
		String z = Integer.toBinaryString(outDec);
		int rem = 32 - z.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + z;
		return out;
	}
	
	public static String subOp(String Operand1 , String Operand2) {
		String out = "";
		int Operand1Dec = convertToDecimal(Operand1);
		int Operand2Dec = convertToDecimal(Operand2);
		int outDec = Operand1Dec - Operand2Dec;
		String zeros = "";
		String z = Integer.toBinaryString(outDec);
		int rem = 32 - z.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + z;
		return out;
	}
	
	public static String multOp(String Operand1 , String Operand2) {
		String out = "";
		int Operand1Dec = convertToDecimal(Operand1);
		int Operand2Dec = convertToDecimal(Operand2);
		int outDec = Operand1Dec * Operand2Dec;
		String zeros = "";
		String z = Integer.toBinaryString(outDec);
		int rem = 32 - z.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + z;
		return out;
	}
	
	public static String ANDOp(String Operand1 , String Operand2) {
		String out = "";
		for(int i=0;i<Operand1.length();i++) {
			if((Operand1.charAt(i)=='1')&&(Operand2.charAt(i)=='1')) {
				out += "1";
			}
			else {
				out += "0";
			}
		}
		String zeros = "";
		int rem = 32 - out.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + out;
		return out;		
	}
	
	public static String OROp(String Operand1 , String Operand2) {
		String out = "";
		for(int i=0;i<Operand2.length();i++) {
			if((Operand1.charAt(i)=='0')&&(Operand2.charAt(i)=='0')) {
				out += "0";
			}
			else {
				out += "1";
			}
		}
		String zeros = "";
		int rem = 32 - out.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + out;
		return out;	
	}
	
	public static String sllOp(String Operand1 , String Operand2) {
		String out = "";
		int Operand1Dec = convertToDecimal(Operand1);
		int Operand2Dec = convertToDecimal(Operand2);
		int outDec = 0;
		for(int i=0;i<Operand2Dec;i++) {
			 Operand1Dec = Operand1Dec * 2;
		}
		out = convertToBinary(Operand1Dec);
		String zeros = "";
		int rem = 32 - out.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + out;
		return out;	
	}
	
	public static String srlOp(String Operand1 , String Operand2) {
		String out = "";
		int Operand1Dec = convertToDecimal(Operand1);
		int Operand2Dec = convertToDecimal(Operand2);
		int outDec = 0;
		for(int i=0;i<Operand2Dec;i++) {
			 Operand1Dec = Operand1Dec / 2;
		}
		out = convertToBinary(Operand1Dec);
		String zeros = "";
		int rem = 32 - out.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + out;
		return out;	
	}
	
	public static String sltOp(String Operand1 , String Operand2) {
		String out = "";
		int Operand1Dec = convertToDecimal(Operand1);
		int Operand2Dec = convertToDecimal(Operand2);
		if(Operand1Dec < Operand2Dec){
			out = "00000000000000000000000000000001";
		}
		else {
			out = "00000000000000000000000000000000";
		}
		String zeros = "";
		int rem = 32 - out.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + out;
		return out;	
	}
	
	public static int convertToDecimal(String s){
		int result=0;
		int c=0;
		for(int i=s.length()-1;i>-1;i--) {
			String k = "";
			char h = s.charAt(i);
			k+=h;
			result += (Math.pow(2,c)*Integer.parseInt(k));
			c++;
		}
		return result;
	}
	
	public static String convertToBinary(int n){
		String out = "";
		String zeros = "";
		String z = Integer.toBinaryString(n);
		int rem = 32 - z.length();
		for(int i=0;i<rem;i++) {
			zeros += "0";
		}
		out = zeros + z;
		return out;
	}
	
	
	
}
