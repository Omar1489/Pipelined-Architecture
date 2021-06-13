
public class Cache {
	public static Block[] cache = new Block[8];
	
	public static String cacheload(String address){
		int addressDec = convertToDecimal(address);
		int index=addressDec%8;
		int tag=addressDec/8;
		Block block=cache[index];
		if(block != null) {
		if(block.isValidBit()==true) {
			if(tag==block.getTag()) {
				String cacheData= block.getData();
				return cacheData;
			}
			else { 
				cache[index].setTag(tag);
				cache[index].setData(DataMem.dataMem[addressDec]);
				return DataMem.dataMem[addressDec];
		}
		}
		else {
			
			cache[index].setIndex(index);
			cache[index].setTag(tag);
			cache[index].setData(DataMem.dataMem[addressDec]);
			cache[index].setValidBit(true);
			return DataMem.dataMem[addressDec];
		}
		}
		else {
			cache[index] = new Block(true,tag,index,DataMem.dataMem[addressDec]);
			return DataMem.dataMem[addressDec];
		}
	}
	public static void cachestore(String regdata,String address){
		int addressDec = convertToDecimal(address);
		int index=addressDec%8;
		int tag=addressDec/8;
		Block block=cache[index];
		if(block != null) {
		if(block.isValidBit()==true) {
			if(tag==block.getTag()) {
				cache[index].setData(regdata);
				DataMem.dataMem[addressDec] = regdata;
			}
			else { 
				cache[index].setData(regdata);
				DataMem.dataMem[addressDec] = regdata;
		}
		}
		else {
			cache[index].setTag(tag);
			cache[index].setData(regdata);
			DataMem.dataMem[addressDec] = regdata;
			cache[index].setValidBit(true);
		}
		}
		else {
			cache[index] = new Block(true,tag,index,DataMem.dataMem[addressDec]);
			DataMem.dataMem[addressDec] = regdata;
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
