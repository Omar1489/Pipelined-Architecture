

public class InstructionFetch {
	public static String pc="0000000000000000000000000000000";
	public static String inst="0000000000000000000000000000000";


		
	public static void InstFetch(String address) {
		int addressDec = convertToDecimal(address);
		inst = InstMem.instMemory[addressDec];
		String op = inst.substring(0,10);
		if(op.equals("0000000001")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);
			System.out.println("ADD " + "r" + rxDec + " r" + ryDec + " " +immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000000010")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("ADDi " + "r" + rxDec + " r" + ryDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000000011")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("SUB " + "r" + rxDec + " r" + ryDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000000100")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("MULT " + "r" + rxDec + " r" + ryDec + " " +  immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000000101")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("AND " + "r" + rxDec + " r" + ryDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000000110")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("ORi " + "r" + rxDec + " r" + ryDec  + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000000111")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("SLL " + "r" + rxDec + " r" + ryDec  + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000001000")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("SRL " + "r" + rxDec + " r" + ryDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000001001")) {
			String rx = inst.substring(10,16);
			String immediate = inst.substring(16,32);
			int rxDec = convertToDecimal(rx);
			int immediateDec = convertToDecimal(immediate);

			System.out.println("LW  " + "r" + rxDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000001010")) {
			String rx = inst.substring(10,16);
			String immediate = inst.substring(16,32);
			int rxDec = convertToDecimal(rx);
			int immediateDec = convertToDecimal(immediate);
			System.out.println("SW " + "r" + rxDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000001011")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);
			System.out.println("BNE " + "r" + rxDec + " r" + ryDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000001100")) {
			String rx = inst.substring(10,16);
			String ry = inst.substring(16,22);
			String immediate = inst.substring(22,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int immediateDec = convertToDecimal(immediate);
			System.out.println("BGT " + "r" + rxDec + " r" + ryDec + " " + immediateDec + " in Fetch stage:");
		}
		if(op.equals("0000001101")) {
			String rx = inst.substring(10,18);
			String ry = inst.substring(18,25);
			String rz = inst.substring(25,32);
			int rxDec = convertToDecimal(rx);
			int ryDec = convertToDecimal(ry);
			int rzDec = convertToDecimal(rz);
			System.out.println("SLT " + "r" + rxDec + " r" + ryDec + " r" + rzDec + " in Fetch stage:");
			
			
		}
		if(op.equals("0000001110")) {
			String immediate = inst.substring(10,32);
			int immediateDec = convertToDecimal(immediate);
			System.out.println("J " + immediateDec + " in Fetch stage:");
		}
		ProgCount();
		System.out.println("Next PC = " + pc);
		System.out.println("Instruction:" + inst);
			Controller.IFID[Controller.IFIDindex] = inst;
			Controller.IFIDindex += 1;
			Controller.IFID[Controller.IFIDindex] = pc;
			Controller.IFIDindex += 1;
		
	}
	
	public static void ProgCount() {
		int pcDec = convertToDecimal(pc);
		pcDec += 1;
		pc = convertToBinary(pcDec);
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
