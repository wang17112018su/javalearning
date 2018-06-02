package workshop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BookingRegister {

	private static HashMap<Facility, ArrayList<Booking>> allBooking = new HashMap<Facility, ArrayList<Booking>>();

	public void addBooking(Member member, Facility facility, LocalDateTime startDate, LocalDateTime endDate)
			throws BadBookingException {
		try {
			Booking b = new Booking(member, facility, startDate, endDate);
			if (allBooking.containsKey(facility) == false) {
				ArrayList<Booking> bookings = new ArrayList<Booking>();
				bookings.add(b);
				allBooking.put(facility, bookings);

			} else {
				ArrayList<Booking> bookings = allBooking.get(facility);
				Iterator<Booking> i = bookings.iterator();
				while (i.hasNext()) {
					if (b.overlaps(i.next())) {
						throw new BadBookingException("New booking overlaps with existing one");
					}
				}
				bookings.add(b);
				allBooking.put(facility, bookings);
			}
		} catch (BadBookingException be) {
			System.out.println("Bad Booking Exception: " + be.getMessage());
		}
	}

	public ArrayList<Booking> getBookings(Facility facility, LocalDateTime start, LocalDateTime endDate) {

		ArrayList<Booking> result = new ArrayList<Booking>();
		ArrayList<Booking> bookings = allBooking.get(facility);
		Iterator<Booking> i = bookings.iterator();
		while (i.hasNext()) {
			
			Booking b = i.next();
			if ((start.isBefore(b.getStartDate())) && (endDate.isAfter(b.getEndDate()))) {

				result.add(b);

			}
		}
		return result;
	}
	
	public void removeBookings(Booking booking) {
		//Get the Listbooking based on the facility
		ArrayList<Booking> result = allBooking.get(booking.getFacility());
		//Remove the booking from the List booking
		result.remove(booking);
	}
}
