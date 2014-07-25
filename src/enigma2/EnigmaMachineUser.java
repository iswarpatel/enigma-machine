package enigma2;

import java.io.*;
public class EnigmaMachineUser {
public static void main(String[] args) throws IOException{		
		final int errorsAllowed = 7;
		final double multiplier = 2  ;	
		Rotor r1 = new Rotor("QWERTYUIOPLKJHGFDSAZXCVBNM");
		Rotor r2 = new Rotor("ZAQWSXCDERFVBGTYHNMJUIKLOP");
		Rotor r3 = new Rotor("PLOKMIJNUHBYGVTFCRDXESZWAQ");	
		Reflector r = new Reflector("NPKMSLZTWQCFDAVBJYEHXOIURG");
		EnigmaMachine E = new EnigmaMachine(r1,r2,r3,r);
		FileReader f = new FileReader ("input.txt");
		BufferedReader b = new BufferedReader(f);
		StringBuilder sb = new StringBuilder();
		String s;
		while((s=b.readLine())!=null){
			sb.append(s);
		}
		String s1 = new String(sb);
		FindRotorSettings frs = new FindRotorSettings();
		frs.findSettings(s1, E, multiplier, errorsAllowed);
}
}
