
public class Execute {
	public static String ALUresult = "";
	public static String BranchAddressResult = "";
	public static int IDEXindex = 0;
	
	public static void execute() {
		String inst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String pc = Controller.IDEX[IDEXindex];
		IDEXindex +=1;
		String op = Controller.IDEX[IDEXindex];
		IDEXindex -=1;
		IDEXindex -=1;
		if(op.equals("0000000001")) {
			executeALCB();
		}
		if(op.equals("0000000010")) {
			executeALCB();
		}
		if(op.equals("0000000011")) {
			executeALCB();
		}
		if(op.equals("0000000100")) {
			executeALCB();
		}
		if(op.equals("0000000101")) {
			executeALCB();
		}
		if(op.equals("0000000110")) {
			executeALCB();
		}
		if(op.equals("0000000111")) {
			executeALCB();
		}
		if(op.equals("0000001000")) {
			executeALCB();
		}
		if(op.equals("0000001001")) {
			executeD();
		}
		if(op.equals("0000001010")) {
			executeD();
		}
		if(op.equals("0000001011")) {
			executeALCB();
		}
		if(op.equals("0000001100")) {
			executeALCB();
		}
		if(op.equals("0000001101")) {
			executeC();
		}
		if(op.equals("0000001110")) {
			executeU();
		}
	}
	public static void executeALCB() {
		String inst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String pc = Controller.IDEX[IDEXindex];
		IDEXindex +=1;
		String op = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String rxBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String signExtendOut = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData1 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData2 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegDst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String PCSrc = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemRead = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemToReg = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		
		if(op.equals("0000000001")) {
			if(immediate.equals("0000000000")) {
			String Operand1 = RegFile.registers[rx];
			String Operand2 = RegFile.registers[ry];
			ALUresult = ALU.addOp(Operand1, Operand2);
			}
			else {
				System.out.println("Can not add immediate in add");
				return;
			}
			BranchAddressResult = "";
			System.out.println("ADD " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
				
		}
		if(op.equals("0000000010")) {
			String Operand1 = RegFile.registers[rx];
			ALUresult = ALU.addOp(Operand1,immediate);;
			BranchAddressResult = "";
			System.out.println("ADDi " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000000011")) {
			if(immediate.equals("0000000000")) {
				String Operand1 = RegFile.registers[rx];
				String Operand2 = RegFile.registers[ry];
				ALUresult = ALU.subOp(Operand1, Operand2);
			}
			else {
					System.out.println("Can not sub immediate in sub");
					return;
				}
			System.out.println("SUB " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			BranchAddressResult = "";
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000000100")) {
			if(immediate.equals("0000000000")) {
				String Operand1 = RegFile.registers[rx];
				String Operand2 = RegFile.registers[ry];
				ALUresult = ALU.multOp(Operand1, Operand2);
			}
			else {
					System.out.println("Can not mult immediate in mult");
					return;
				}
			BranchAddressResult = "";
			System.out.println("MULT " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000000101")) {
			if(immediate.equals("0000000000")) {
				String Operand1 = RegFile.registers[rx];
				String Operand2 = RegFile.registers[ry];
				ALUresult = ALU.ANDOp(Operand1, Operand2);
			}
			else {
					System.out.println("Can not AND immediate in AND");
					return;
				}
			BranchAddressResult = "";
			System.out.println("AND " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000000110")) {
			String Operand1 = RegFile.registers[rx];
			ALUresult = ALU.OROp(Operand1, immediate);
			BranchAddressResult = "";
			System.out.println("ORi " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000000111")) {
			String Operand1 = RegFile.registers[rx];
			ALUresult = ALU.sllOp(Operand1, immediate);
			BranchAddressResult = "";
			System.out.println("SLL " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000001000")) {
			String Operand1 = RegFile.registers[rx];
			ALUresult = ALU.srlOp(Operand1, immediate);
			BranchAddressResult = "";
			System.out.println("SRL " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + ALUresult);
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000001011")) {
			String Operand1 = RegFile.registers[rx];
			String Operand2 = RegFile.registers[ry];
			int Operand1Dec = convertToDecimal(Operand1);
			int Operand2Dec = convertToDecimal(Operand2);
			if(!(RegFile.registers[Operand1Dec].equals(RegFile.registers[Operand2Dec]))) {
				BranchAddressResult = pc;
				ALUresult = "";
				System.out.println("BNE " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
				System.out.println("BranchAddressResult : " + BranchAddressResult);
				System.out.println("rx new data : " + "");
				System.out.println("ALUresult : " +ALUresult );
				System.out.println("register value to write to memory : " + "");
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			else {
				BranchAddressResult = "";
				ALUresult = "";
				System.out.println("BNE " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
				System.out.println("rx new data : " + "");
				System.out.println("ALUresult : " +ALUresult );
				System.out.println("register value to write to memory : " + "");
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + InstructionDecode.MemWrite + " PCSrc : " + InstructionDecode.PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
		}
		if(op.equals("0000001100")) {
			String Operand1 = RegFile.registers[rx];
			String Operand2 = RegFile.registers[ry];
			int Operand1Dec = convertToDecimal(Operand1);
			int Operand2Dec = convertToDecimal(Operand2);
			int rxdec = convertToDecimal(RegFile.registers[Operand1Dec]);
			int rydec = convertToDecimal(RegFile.registers[Operand2Dec]);
			if(rxdec > rydec) {
				BranchAddressResult = pc;
				ALUresult = "";
				System.out.println("BGT " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
				System.out.println("BranchAddressResult : " + BranchAddressResult);
				System.out.println("rx new data : " + "");
				System.out.println("ALUresult : " +ALUresult );
				System.out.println("register value to write to memory : " + "");
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
			else {
				BranchAddressResult = "";
				ALUresult = "";
				System.out.println("BGT " + "r" + rx + " r" + ry + " " + convertToDecimal(immediate) + " in Execute stage:");
				System.out.println("rx new data : " + "");
				System.out.println("ALUresult : " +ALUresult );
				System.out.println("register value to write to memory : " + "");
				System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
				System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
				System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			}
		}
		Controller.EXMEM[Controller.EXMEMindex] = inst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = pc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = op;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rx);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(ry);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rz);
		Controller.EXMEMindex += 1 ;
		Controller.EXMEM[Controller.EXMEMindex] = immediate;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = signExtendOut;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData1;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData2;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegDst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = PCSrc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemRead;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemToReg;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = ALUresult;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = BranchAddressResult;
		Controller.EXMEMindex += 1;
	}
	public static void executeD() {
		String inst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String pc = Controller.IDEX[IDEXindex];
		IDEXindex +=1;
		String op = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String rxBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String signExtendOut = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData1 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData2 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegDst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String PCSrc = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemRead = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemToReg = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		if(op.equals("0000001001")) {
			ALUresult = "";
			System.out.println("LW  " + "r" + InstructionDecode.rx + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + "");
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		}
		if(op.equals("0000001010")) {
			ALUresult = "";
			System.out.println("SW  " + "r" + rx + " " + convertToDecimal(immediate) + " in Execute stage:");
			System.out.println("rx new data : " + "");
			System.out.println("ALUresult : " +ALUresult );
			System.out.println("register value to write to memory : " + RegFile.registers[InstructionDecode.rx]);
			System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
			System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
			System.out.println("EXT Controls : " + "RegDst : " + RegDst );
			
		}

		Controller.EXMEM[Controller.EXMEMindex] = inst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = pc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = op;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rx);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(ry);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rz);
		Controller.EXMEMindex += 1 ;
		Controller.EXMEM[Controller.EXMEMindex] = immediate;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = signExtendOut;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData1;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData2;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegDst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = PCSrc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemRead;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemToReg;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = ALUresult;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = BranchAddressResult;
		Controller.EXMEMindex += 1;
	}
	public static void executeC() {
		String inst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String pc = Controller.IDEX[IDEXindex];
		IDEXindex +=1;
		String op = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String rxBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String signExtendOut = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData1 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData2 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegDst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String PCSrc = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemRead = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemToReg = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String Operand2 = RegFile.registers[ry];
		String Operand3 = RegFile.registers[rz];
		ALUresult = ALU.sltOp(Operand2,Operand3);
		BranchAddressResult = "";
		System.out.println("SLT " + "r" + rx+ " r" + ry + " r" + rz + " in Execute stage:");
		System.out.println("rx new data : " + ALUresult);
		System.out.println("ALUresult : " +ALUresult );
		System.out.println("register value to write to memory : " + "");
		System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
		System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
		System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		Controller.EXMEM[Controller.EXMEMindex] = inst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = pc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = op;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rx);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(ry);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rz);
		Controller.EXMEMindex += 1 ;
		Controller.EXMEM[Controller.EXMEMindex] = immediate;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = signExtendOut;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData1;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData2;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegDst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = PCSrc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemRead;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemToReg;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = ALUresult;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = BranchAddressResult;
		Controller.EXMEMindex += 1;
	}
	public static void executeU() {
		String inst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String pc = Controller.IDEX[IDEXindex];
		IDEXindex +=1;
		String op = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String rxBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rx = convertToDecimal(rxBinary);
		String ryBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int ry = convertToDecimal(ryBinary);
		String rzBinary = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		int rz = convertToDecimal(rzBinary);
		String immediate = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String signExtendOut = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData1 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String readData2 = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegDst = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String RegWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String PCSrc = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemRead = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemWrite = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		String MemToReg = Controller.IDEX[IDEXindex];
		IDEXindex += 1;
		BranchAddressResult = InstructionFetch.pc;
		ALUresult = "";
		System.out.println("J " + convertToDecimal(immediate) + " in Execute stage:");
		System.out.println("rx new data : " + "");
		System.out.println("ALUresult : " +ALUresult );
		System.out.println("register value to write to memory : " + "");
		System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
		System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
		System.out.println("EXT Controls : " + "RegDst : " + RegDst );
		Controller.EXMEM[Controller.EXMEMindex] = inst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = pc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = op;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rx);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(ry);
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = convertToBinary(rz);
		Controller.EXMEMindex += 1 ;
		Controller.EXMEM[Controller.EXMEMindex] = immediate;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = signExtendOut;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData1;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = readData2;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegDst;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = RegWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = PCSrc;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemRead;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemWrite;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = MemToReg;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = ALUresult;
		Controller.EXMEMindex += 1;
		Controller.EXMEM[Controller.EXMEMindex] = BranchAddressResult;
		Controller.EXMEMindex += 1;
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
