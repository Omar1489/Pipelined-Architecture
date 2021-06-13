
public class InstructionDecode {
	public static String op = "";
	public static int rx = 0;
	public static int ry = 0;
	public static int rz = 0;
	public static String immediate = "";
	public static String signExtendOut = "";
	public static String readData1="";
	public static String readData2="";
	public static String RegDst="0";
	public static String RegWrite="0";
	public static String PCSrc="0";
	public static String MemRead="0";
	public static String MemWrite="0";
	public static String MemToReg="0";
	public static int IFIDindex = 0;
	

	public static void InstDecode() {
		String inst = Controller.IFID[IFIDindex];
		IFIDindex += 1;
		String pc = Controller.IFID[IFIDindex];
		IFIDindex +=1;
		op = inst.substring(0,10);
		ControlUnit.ContUnit(op);
		if(op.equals("0000001001")) {
			//D format lw
			String rx2 = inst.substring(10,16);
			rx = convertToDecimal(rx2);
			ry = 0;
			rz = 0;
			readData1="";
			readData2="";
			immediate = inst.substring(16,32);
			System.out.println(op + " " + rx2 + " " + immediate);
			System.out.println("LW  " + "r" + rx + " " + convertToDecimal(immediate) + " in Decode stage:");
			System.out.println("Read Data1 : " + readData1);
			System.out.println("Read Data2 : " + readData2);
			System.out.println("Sign Extend : " + signExtendOut);
			int pcDec = convertToDecimal(pc);
			pcDec += 1;
			System.out.println("Next PC : " + convertToBinary(pcDec) );
			System.out.println("rx : " + convertToBinary(rx));
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			
		}
		if(op.equals("0000001010")) {
			//D format sw
			String rx2 = inst.substring(10,16);
			rx = convertToDecimal(rx2);
			ry = 0;
			rz = 0;
			readData1=RegFile.registers[rx];
			readData2="";
			immediate = inst.substring(16,32);
			System.out.println("SW  " + "r" + rx + " " + convertToDecimal(immediate) + " in Decode stage:");
			System.out.println("Read Data1 : " + readData1);
			System.out.println("Read Data2 : " + readData2);
			System.out.println("Sign Extend : " + signExtendOut);
			int pcDec = convertToDecimal(pc);
			pcDec += 1;
			System.out.println("Next PC : " + convertToBinary(pcDec) );
			System.out.println("rx : " + convertToBinary(rx));
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			
		}
		if(op.equals("0000000001")||op.equals("0000000010")||op.equals("0000000011")||op.equals("0000000100")||op.equals("0000000101")||op.equals("0000000110")||op.equals("0000000111")||op.equals("0000001000")||op.equals("0000001011") || op.equals("0000001100")) {
		    //ALCB format
			String rx2 = inst.substring(10,16);
			String ry2 = inst.substring(16,22);
			rx = convertToDecimal(rx2);
			ry = convertToDecimal(ry2);
			rz = 0;
			readData1=RegFile.registers[rx];
			readData2=RegFile.registers[ry];
			immediate = inst.substring(22,32);
			SignExtendALCB(immediate);
			if(op.equals("0000000001")) {
				System.out.println("ADD " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000000010")) {
				System.out.println("ADDi " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000000011")) {
				System.out.println("SUB " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000000100")) {
				System.out.println("MULT " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000000101")) {
				System.out.println("AND " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000000110")) {
				System.out.println("ORi " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000000111")) {
				System.out.println("SLL " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000001000")) {
				System.out.println("SRL " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
				System.out.println("Read Data1 : " + readData1);
				System.out.println("Read Data2 : " + readData2);
				System.out.println("Sign Extend : " + signExtendOut);
				System.out.println("Next PC : " + pc );
				System.out.println("rx : " + rx2);
				System.out.println("ry : " + ry2);
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			if(op.equals("0000001011")) {
				if(!(RegFile.registers[rx].equals(RegFile.registers[ry]))) {
					pc = sum(pc,signExtendOut);
					System.out.println("BNE " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
					System.out.println("Read Data1 : " + readData1);
					System.out.println("Read Data2 : " + readData2);
					System.out.println("Sign Extend : " + signExtendOut);
					System.out.println("Next PC : " + pc);
					System.out.println("rx : " + rx2);
					System.out.println("ry : " + ry2);
					System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
					System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
					System.out.println("EXT Controls : " + "RegDst : " + RegDst );
				}
				else {
					System.out.println("BNE " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
					System.out.println("Read Data1 : " + readData1);
					System.out.println("Read Data2 : " + readData2);
					System.out.println("Sign Extend : " + signExtendOut);
					System.out.println("Next PC : " + pc );
					System.out.println("rx : " + rx2);
					System.out.println("ry : " + ry2);
					System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
					System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
					System.out.println("EXT Controls : " + "RegDst : " + RegDst );
				}
				
			}
			if(op.equals("0000001100")) {
				int rxdec = convertToDecimal(RegFile.registers[rx]);
				int rydec = convertToDecimal(RegFile.registers[ry]);
				if(rxdec > rydec) {
					pc = sum(pc,signExtendOut);
					System.out.println("BGT " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
					System.out.println("Read Data1 : " + readData1);
					System.out.println("Read Data2 : " + readData2);
					System.out.println("Sign Extend : " + signExtendOut);
					System.out.println("Next PC : " + pc);
					System.out.println("rx : " + rx2);
					System.out.println("ry : " + ry2);
					System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
					System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
					System.out.println("EXT Controls : " + "RegDst : " + RegDst );
				}
				else {
					System.out.println("BGT " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Decode stage:");
					System.out.println("Read Data1 : " + readData1);
					System.out.println("Read Data2 : " + readData2);
					System.out.println("Sign Extend : " + signExtendOut);
					System.out.println("Next PC : " + pc );
					System.out.println("rx : " + rx2);
					System.out.println("ry : " + ry2);
					System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
					System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
					System.out.println("EXT Controls : " + "RegDst : " + RegDst );
				}
			}
		}
		
		if(op.equals("0000001101")) {
			// C format
			String rx2 = inst.substring(10,18);
			String ry2 = inst.substring(18,25);
			String rz2 = inst.substring(25,32);
			rx = convertToDecimal(rx2);
			ry = convertToDecimal(ry2);
			readData1=RegFile.registers[rx];
			readData2=RegFile.registers[ry];
			rz = convertToDecimal(rz2);
			immediate = "";
			System.out.println("SLT " + "r" + rx+ " r" + ry + " r" + rz + " in Decode stage:");
			System.out.println("Read Data1 : " + readData1);
			System.out.println("Read Data2 : " + readData2);
			System.out.println("Sign Extend : " + signExtendOut);
			System.out.println("Next PC : " + pc );
			System.out.println("rx : " + rx2);
			System.out.println("ry : " + ry2);
			System.out.println("rz : " + rz2);
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		
		if(op.equals("0000001110")) {
			// U format 
			immediate = inst.substring(10,32);
			readData1="";
			readData2="";
			SignExtendU(immediate);
			pc = sum(pc,signExtendOut);
			System.out.println("J " + convertToDecimal(immediate) + " in Decode stage:");
			System.out.println("Read Data1 : " + readData1);
			System.out.println("Read Data2 : " + readData2);
			System.out.println("Sign Extend : " + signExtendOut);
			System.out.println("Next PC : " + pc);
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		Controller.IDEX[Controller.IDEXindex] = inst;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = pc;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = op;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = convertToBinary(rx);
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = convertToBinary(ry);
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = convertToBinary(rz);
		Controller.IDEXindex += 1 ;
		Controller.IDEX[Controller.IDEXindex] = immediate;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = signExtendOut;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = readData1;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = readData2;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = RegDst;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = RegWrite;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = PCSrc;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = MemRead;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = MemWrite;
		Controller.IDEXindex += 1;
		Controller.IDEX[Controller.IDEXindex] = MemToReg;
		Controller.IDEXindex += 1;
	}
	
	public static void SignExtendALCB(String bits) {
		String extend = "";
		char c = bits.charAt(0);
		for(int i=0;i<22;i++) {
			extend += c;
		}
		signExtendOut = extend + bits;
//		System.out.println("sign extended:" + signExtendOut);
	}

	public static void SignExtendU(String bits) {
		String extend = "";
		char c = bits.charAt(0);
		for(int i=0;i<10;i++) {
			extend += c;
		}
		signExtendOut = extend + bits;
//		System.out.println("sign extended:" + signExtendOut);
	}
	
	public static String sum(String b1, String b2) { 
		int len1 = b1.length(); int len2 = b2.length(); 
		int carry = 0; String res = "";
		int maxLen = Math.max(len1, len2);
		for (int i = 0; i < maxLen; i++) { 

			int p = i < len1 ? b1.charAt(len1 - 1 - i) - '0' : 0; 
			int q = i < len2 ? b2.charAt(len2 - 1 - i) - '0' : 0;
			int tmp = p + q + carry; carry = tmp / 2; res = tmp % 2 + res; } 
		return (carry == 0) ? res : "1" + res;
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
