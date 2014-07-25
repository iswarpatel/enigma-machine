package enigma2;

public class Rotor {
	private int position;
	final static int max = 26;
	private char[] leftToRightWiring = new char[max];
	private char[] rightToLeftWiring = new char[max];
	public Rotor(String s){	
		leftToRightWiring = s.toCharArray();
		rightToLeftWiring = s.toCharArray();	
	}
	public boolean inc(){	
		if(position<26)
			position++;	
		if(position==26){
			position = 0;		
			return true;
		}	
		return false;
	}	
	public void set(int n){
		this.position = n;			
	}
	public char encodeLR(char c){	
		if(c>=65 && c<=90){	
		int a = c- 65;	
		if(a+position>25)
			return rightToLeftWiring[a+position-26];
		else
			return rightToLeftWiring[a+position];
	}
		return c;
	}
	public char encodeRL(char c){	
		char ch = c;
		for(int i=0;i<26;i++){
			if(rightToLeftWiring[i]==c){			
				if(i-position<0)
					i+=26;		
				i+=65-position;		
				ch = (char)i;	
			}		
		}
		return ch;
	}	
}