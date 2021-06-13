
public class WriteBack {

	public static String WriteData = "";
	public static int MEMWBindex = 0;
	
	public static void writeBack() {
		
		String inst = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String pc = Controller.MEMWB[MEMWBindex];
		MEMWBindex +=1;
		String op = Controller.MEMWB[MEMWBindex];
		MEMWBindex -=1;
		MEMWBindex -=1;
		if(op.equals("0000000001")) {
			writeBackALCB();
		}
		if(op.equals("0000000010")) {
			writeBackALCB();
		}
		if(op.equals("0000000011")) {
			writeBackALCB();
		}
		if(op.equals("0000000100")) {
			writeBackALCB();
		}
		if(op.equals("0000000101")) {
			writeBackALCB();
		}
		if(op.equals("0000000110")) {
			writeBackALCB();
		}
		if(op.equals("0000000111")) {
			writeBackALCB();
		}
		if(op.equals("0000001000")) {
			writeBackALCB();
		}
		if(op.equals("0000001011")) {
			writeBackALCB();
		}
		if(op.equals("0000001100")) {
			writeBackALCB();
		}
		if(op.equals("0000001001")) {
			writeBackD();
		}
		if(op.equals("0000001010")) {
			writeBackD();
		}
		if(op.equals("0000001101")) {
			writeBackC();
		}
	}
	public static void writeBackALCB() {
		String inst = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String pc = Controller.MEMWB[MEMWBindex];
		MEMWBindex +=1;
		String op = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String rxBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String signExtendOut = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String readData1 = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String readData2 = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String RegDst = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String RegWrite = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String PCSrc = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemRead = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemWrite = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemToReg = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String ALUresult= Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String BranchAddressResult = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		RegFile.registers[rx] = ALUresult;
		WriteData = ALUresult;
		int immediateDec = convertToDecimal(immediate);
		if(op.equals("0000000001")) {
			System.out.println("ADD " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000000010")) {
			System.out.println("ADDi " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000000011")) {
			System.out.println("SUB " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000000100")) {
			System.out.println("MULT " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000000101")) {
			System.out.println("AND " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000000110")) {
			System.out.println("ORi " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000000111")) {
			System.out.println("SLL " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000001000")) {
			System.out.println("SRL " + "r" + rx + " r" + ry + " " +immediateDec + " in WriteBack stage:");
		}
		if(op.equals("0000001011")) {
			System.out.println("BNE " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in WriteBack stage:");
			return;
		}
		if(op.equals("0000001100")) {
			System.out.println("BGT " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
			return;
		}
		System.out.println("rx new data : " + RegFile.registers[rx]);
		System.out.println("ALUresult : " + ALUresult );
		System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
		System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
		System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		
	}
	
	public static void writeBackD() {
		String inst = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String pc = Controller.MEMWB[MEMWBindex];
		MEMWBindex +=1;
		String op = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String rxBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String signExtendOut = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String readData1 = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String readData2 = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String RegDst = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String RegWrite = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String PCSrc = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemRead = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemWrite = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemToReg = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String ALUresult= Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String BranchAddressResult = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;

		if(op.equals("0000001010")) {
			System.out.println("SW  " + "r" + rx + " " + convertToDecimal(immediate) + " in WriteBack stage:");
			return;
		}
		int address2 = convertToDecimal(immediate);
		RegFile.registers[rx] = Cache.cacheload(immediate);
		WriteData =  DataMem.dataMem[address2];
		System.out.println("LW  " + "r" + rx + " " + convertToDecimal(immediate) + " in WriteBack stage:");
		System.out.println("rx new data : " + RegFile.registers[rx]);
		System.out.println("ALUresult : " + ALUresult );
		System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
		System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
		System.out.println("EXT Controls : " + "RegDst : " + RegDst );
	}
	
	public static void writeBackC() {
		String inst = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String pc = Controller.MEMWB[MEMWBindex];
		MEMWBindex +=1;
		String op = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String rxBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String signExtendOut = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String readData1 = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String readData2 = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String RegDst = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String RegWrite = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String PCSrc = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemRead = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemWrite = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String MemToReg = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String ALUresult= Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		String BranchAddressResult = Controller.MEMWB[MEMWBindex];
		MEMWBindex += 1;
		RegFile.registers[rx] = ALUresult;
		WriteData = ALUresult;
		System.out.println("SLT " + "r" + rx+ " r" + ry + " r" + rz + " in WriteBack stage:");
		System.out.println("rx new data : " + RegFile.registers[rx]);
		System.out.println("ALUresult : " + ALUresult );
		System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
		System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
		System.out.println("EXT Controls : " + "RegDst : " + RegDst );
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
}
