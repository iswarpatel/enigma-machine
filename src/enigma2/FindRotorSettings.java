package enigma2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FindRotorSettings {
	public void findSettings(String s,EnigmaMachine E,double multiplier,int errorsAllowed ) throws IOException{	
	PrintWriter out=new PrintWriter(new FileWriter("decrypted.txt"));	
	for(int i=0;i<26;i++)
		for(int j=0;j<26;j++)
			for(int k=0;k<26;k++){			
	E.setRotors(k,j,i);
	Decrypt d = new Decrypt();
	String es = d.decryption(s, E);
	English e = new English();
	e.countAllLetters(es);
	int a = e.getErrorCount(multiplier,es);	
	if(a<=errorsAllowed){		
out.println(es+" "+"\nThe rotor setting is:"+k+" "+j+" "+i+"And ERROR COUNT ="+a);	
System.out.println("\n\nThe roto rsettingis:"+""+k+" "+j+" "+i+"  ERROR COUNT="+a);	
System.out.println(es);
	}
	}
	out.close();	
	}
}
