package enigma2;

public class Decrypt {	
	public String decryption(String s,EnigmaMachine E){
		String es = E.encodeLine(s);
		return es;
	}
}
