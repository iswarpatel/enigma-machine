package enigma2;

public class EnigmaMachine {
	private Rotor r1;
	private Rotor r2;
	private Rotor r3;
	private Reflector r;	
	public EnigmaMachine(Rotor r1,Rotor r2,Rotor r3,Reflector r){	
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r = r;		
	}	
	public String encodeLine(String s){	
		StringBuilder sb = new StringBuilder();	
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>=65 && s.charAt(i)<=90){	
		char a = r1.encodeLR(s.charAt(i));	
		 a = r2.encodeLR(a);
		 a = r3.encodeLR(a);
		a = r.convert(a);
		a = r3.encodeRL(a);
		a = r2.encodeRL(a);
		a = r1.encodeRL(a);
		incrementRotors();
	    sb.append(a);
			}
			else sb.append(s.charAt(i));
	}	
		return new String(sb);
	}
	public void setRotors(int a,int b, int c){
		r1.set(a);
		r2.set(b);
		r3.set(c);
	}
	private void incrementRotors(){
		if(r1.inc())
			if(r2.inc())
				r3.inc();
	}
}