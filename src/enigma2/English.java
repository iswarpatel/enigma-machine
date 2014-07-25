package enigma2;

 public class English {
		private static int totalNumberOfLetters;
		final private static int max=Rotor.max;
		private static double[] engLetterFreq={8.1,1.6,3.2,3.6,12.3,2.3,1.6,5.1,7.2,0.1,0.5,
			4.0,2.2,7.2,7.9,2.3,0.2,6.0,6.6,9.6,3.1,0.9,2.0,0.2,1.9,0.1};
		private static int[] engLetterDeviation={10,50,30,30,10,30,50,20,15,100,80,30,30,20,20,30,100,30,20,15,30,60,40,100,40,100};
		private static int[] letterCount = new int[max];
	    public static void countAllLetters(String s){	
	    	for(int i=0;i<max;i++){
	        	letterCount[i] =0;
	        	}
	    	 for(int i=0;i<s.length();i++){
	    	if(s.charAt(i)>=65 && s.charAt(i)<=90){
	    		letterCount[s.charAt(i)-65]++;	
	    	}	
	    }
	    for(int i=0;i<max;i++){
	    	char a = (char)(i+65);
	    	}
	    }
	    public static int getErrorCount(double mult, String s){
	    	double pc;
	    	int errcnt=0;
	    	int sum=0;
	    	for(int i=0;i<26;i++){
	    		sum=sum+letterCount[i];
	    	}
	    	for(int i=0;i<26;i++){	
	    char a = (char)(i+65);
	   pc = ((letterCount[i]*100)/sum);
	  	double lowbound = engLetterFreq[i]*(1-(mult*engLetterDeviation[i]/100));
	   	double upbound = engLetterFreq[i]*(1+(mult*engLetterDeviation[i]/100));
	  	if(!(pc>(engLetterFreq[i]*(1-(mult*engLetterDeviation[i]/100)))
	   		&& pc<(engLetterFreq[i]*(1+(mult*engLetterDeviation[i]/100))))){	
	    	++errcnt;	
	    		}
	    	}
	    return errcnt;
	    } 
	}