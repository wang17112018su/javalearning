package workshop;

@SuppressWarnings("serial")
public class BadBookingException extends Exception {
	
	BadBookingException(){
	
	}
	BadBookingException(String s){
		super(s);
		
	}

}
