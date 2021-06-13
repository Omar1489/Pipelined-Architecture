
public class Block {
	public boolean validBit = false;
	public int tag;
	public int index;
	public String data;
	
	public Block(boolean validBit,int tag,int index,String data){
		this.validBit = validBit;
		this.tag = tag;
		this.index= index;
		this.data = data;
	}
	public boolean isValidBit() {
		return validBit;
	}
	public void setValidBit(boolean validBit) {
		this.validBit = validBit;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
