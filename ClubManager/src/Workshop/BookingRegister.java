package Workshop;

import java.time.LocalDateTime;
import java.util.*;

import club.BadBookingException;
import club.Booking; 

public class BookingRegister {
	
	private Booking booking;
	private static HashMap<Facility,ArrayList<Booking>>bookinglisting = new HashMap<Facility,ArrayList<Booking>>();;

	public void addBooking(Member member, Facility fac, LocalDateTime start, LocalDateTime end) throws MissingFillsException {
		
			booking = new Booking(member, fac, start, end);
			ArrayList<Booking> bookingList = bookinglisting.get(fac);
			if(bookingList == null) {
				bookingList = new ArrayList<Booking>();
				bookinglisting.put(fac,bookingList);
			} else {
	            Iterator<Booking> i = bookingList.iterator ();
	            while (i.hasNext ()) {
	                Booking other = i.next();
	                if (booking.overlaps(other)) {
	                    throw new MissingFillsException ("New booking overlaps with existing one");
	                }
	            }
					
			}
			bookingList.add (booking);
		}
	public ArrayList<Booking> getBookings(Facility Fac, LocalDateTime start, LocalDateTime end){
		ArrayList<Booking> bookingList = bookinglisting.get(Fac);
		if (bookingList == null) {
			
		}else if(bookingList.)
		
		
		
		return 
		
	}
}
