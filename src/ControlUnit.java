
public class ControlUnit {

	
	public static void ContUnit(String op) {
		if(op.equals("0000001001")) {
			//loadWord
			InstructionDecode.RegDst="0";
		    InstructionDecode.RegWrite="1";
			InstructionDecode.PCSrc="0";
			InstructionDecode.MemRead="1";
			InstructionDecode.MemWrite="0";
			InstructionDecode.MemToReg="1";
		}
		if(op.equals("0000001010")) {
//			storeWord
			InstructionDecode.RegDst="x";
			InstructionDecode.RegWrite="0";
			InstructionDecode.PCSrc="0";
			InstructionDecode.MemRead="0";
			InstructionDecode.MemWrite="1";
			InstructionDecode.MemToReg="x";
		}
		if(op.equals("0000000001")||op.equals("0000000010")||op.equals("0000000011")||op.equals("0000000100")||op.equals("0000000101")||op.equals("0000000110")||op.equals("0000000111")||op.equals("0000001000")||op.equals("0000001101")) {
			//rest
			InstructionDecode.RegDst="1";
			InstructionDecode.RegWrite="1";
			InstructionDecode.PCSrc="0";
			InstructionDecode.MemRead="0";
			InstructionDecode.MemWrite="0";
			InstructionDecode.MemToReg="0";
		}
		if(op.equals("0000001011") || op.equals("0000001100")) {
			//branch
			InstructionDecode.RegDst="x";
			InstructionDecode.RegWrite="0";
		    InstructionDecode.PCSrc="1";
			InstructionDecode.MemRead="0";
			InstructionDecode.MemWrite="0";
			InstructionDecode.MemToReg="x";			
		}
		if(op.equals("0000001110")) {
			//jump
			InstructionDecode.RegDst="x";
			InstructionDecode.RegWrite="0";
			InstructionDecode.PCSrc="1";
			InstructionDecode.MemRead="0";
			InstructionDecode.MemWrite="0";
			InstructionDecode.MemToReg="x";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
