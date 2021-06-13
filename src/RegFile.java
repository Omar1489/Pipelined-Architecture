
public class RegFile {
	public static String[] registers = new String[32];
	{for(int i=0;i<registers.length;i++) {
		String zeros="";
		String z = Integer.toBinaryString(i);
		int rem = 32-z.length();
		for(int j=0;j<rem;j++) {
			zeros += "0";
		}
		registers[i] = zeros+z ;
	}}
}
