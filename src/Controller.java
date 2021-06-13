import java.util.ArrayList;

public class Controller {
	public static String[] IFID = new String[500000];
	public static String[] IDEX = new String[500000];
	public static String[] EXMEM = new String[500000];
	public static String[] MEMWB = new String[500000];
	public static int IFIDindex = 0;
	public static int IDEXindex = 0;
	public static int EXMEMindex = 0;
	public static int MEMWBindex = 0;
	public static int cycle = 0;
	public static ArrayList<Instruction> running = new ArrayList<Instruction>();
	
	public static void main(String[] args) {
		RegFile rg = new RegFile();
		InstructionFetch ife = new InstructionFetch();
		InstructionDecode ide = new InstructionDecode();
		Execute exe = new Execute();
		MemoryAccess memacc = new MemoryAccess();
		WriteBack wb = new WriteBack();
		DataMem.dataMem[7] = "00000000000000000000000000010101";  
		DataMem.dataMem[15] = "00000000000000000000000000000000" ; 
		InstMem.instMemory[0] = "00000000010000010000100000000000"; // add
		InstMem.instMemory[1] = "00000000110001110001000000000000"; //sub
		InstMem.instMemory[2] = "00000000100000010000000000000100"; // addi
		InstMem.instMemory[3] = "00000001000001000000110000000000"; //mult
		InstMem.instMemory[4] = "00000001010010110011000000000000"; // and
		InstMem.instMemory[5] = "00000001100010010000000000000011"; // ori
		InstMem.instMemory[6] = "00000001110000010000000000000010"; // sll
		InstMem.instMemory[7] = "00000010000110000000000000000011"; // srl
		InstMem.instMemory[8] = "00000010010010000000000000000111"; // lw
		InstMem.instMemory[9] = "00000010100011000000000000001111"; // sw
		InstMem.instMemory[10] = "00000011010000000100100010010010"; // slt
		InstMem.instMemory[11] = "00000010110001010001110000001010"; // branch not equal

		
		while(true) {
			System.out.println("");
			cycle += 1;
			System.out.println("Cycle : " + cycle);
			if((convertToDecimal(InstructionFetch.pc)<=InstMem.instMemory.length)&&InstMem.instMemory[convertToDecimal(InstructionFetch.pc)]!= null) {
				running.add(new Instruction(InstMem.instMemory[convertToDecimal(InstructionFetch.pc)]));
			}
			for(int i=0;i<running.size();i++) {
				if((running.isEmpty() == false) && i>=0) {
					if(running.get(i).stage == 1) {
					InstructionFetch.InstFetch(InstructionFetch.pc);
					running.get(i).stage += 1;
				}
				else if(running.get(i).stage == 2) {
					InstructionDecode.InstDecode();
					running.get(i).stage += 1;
				}
				else if(running.get(i).stage == 3) {
					Execute.execute();
					running.get(i).stage += 1;
				}
				else if(running.get(i).stage == 4) {
					MemoryAccess.memAccess();
					running.get(i).stage += 1;
				}
				else if(running.get(i).stage == 5) {
					WriteBack.writeBack();
					running.get(i).stage += 1;
				}
				else if(running.get(i).stage == 6) {
					running.remove(i);
					i--;
				}
				}
				
			}
			if(running.isEmpty()) {
				System.out.println("End");
				break;
			}
		}
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
