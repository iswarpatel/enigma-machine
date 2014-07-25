package enigma2;

public class Reflector {
private String convertinString ;
	public char convert(char ch){	
		if(ch>=65 && ch<=90){
		int a = ch- 65;
		return convertinString.charAt(a);
		}
		return ch;
	}
	public Reflector(String s){
		convertinString  = s;
	}
}