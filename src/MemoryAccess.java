
public class MemoryAccess {
	public static int EXMEMindex =0;
	
	public static void memAccess() {
		String inst = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String pc = Controller.EXMEM[EXMEMindex];
		EXMEMindex +=1;
		String op = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String rxBinary = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String signExtendOut = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String readData1 = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String readData2 = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String RegDst = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String RegWrite = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String PCSrc = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String MemRead = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String MemWrite = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String MemToReg = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String ALUresult= Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		String BranchAddressResult = Controller.EXMEM[EXMEMindex];
		EXMEMindex += 1;
		if(op.equals("0000000001")) {
			System.out.println("ADD " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000000010")) {
			System.out.println("ADDi " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000000011")) {
			System.out.println("SUB " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000000100")) {
			System.out.println("MULT " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000000101")) {
			System.out.println("AND " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000000110")) {
			System.out.println("ORi " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000000111")) {
			System.out.println("SLL " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000001000")) {
			System.out.println("SRL " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000001001")) {
			System.out.println("LW  " + "r" + InstructionDecode.rx + " " + convertToDecimal(immediate) + " in MemoryAccess stage:");
		}

		if(op.equals("0000001011")) {
			System.out.println("BNE " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000001100")) {
			System.out.println("BGT " + "r" + rx + " r" + ry + " " +convertToDecimal(immediate)+ " in MemoryAccess stage:");
		}
		if(op.equals("0000001101")) {
			System.out.println("SLT " + "r" + rx + " r" + ry + " r" + rz + " in MemoryAccess stage:");

		}
		if(op.equals("0000001110")) {
			System.out.println("J " + immediate + " in MemoryAccess stage:");
		}
		if(op.equals("0000001010")) {
		Cache.cachestore(RegFile.registers[rx], immediate);
		System.out.println("SW  " + "r" + rx + " " + convertToDecimal(immediate) + " in MemoryAccess stage:");
		System.out.println("memory new data : " + RegFile.registers[rx]);
		System.out.println("ALUresult : " + ALUresult );
		System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
		System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
		System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		Controller.MEMWB[Controller.MEMWBindex] = inst;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = pc;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = op;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = convertToBinary(rx);
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = convertToBinary(ry);
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = convertToBinary(rz);
		Controller.MEMWBindex += 1 ;
		Controller.MEMWB[Controller.MEMWBindex] = immediate;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = signExtendOut;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = readData1;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = readData2;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = RegDst;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = RegWrite;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = PCSrc;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = MemRead;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = MemWrite;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = MemToReg;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = ALUresult;
		Controller.MEMWBindex += 1;
		Controller.MEMWB[Controller.MEMWBindex] = BranchAddressResult;
		Controller.MEMWBindex += 1;
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
