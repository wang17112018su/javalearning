package workshop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {

	private Member member;
	private Facility facility;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public Booking(Member member, Facility facility, LocalDateTime startDate, LocalDateTime endDate)
			throws BadBookingException {
		if (member == null)
			throw new BadBookingException("Member fill is empty");
		else if (facility == null)
			throw new BadBookingException("Facility fill is empty");
		else if (startDate == null)
			throw new BadBookingException("Start date is empty");
		else if (endDate == null)
			throw new BadBookingException("End date is empty");
		else if (startDate == endDate)
			throw new BadBookingException("Both dates are the same");
		else if (startDate.isAfter(endDate))
			throw new BadBookingException("End date is before start date");

		this.member = member;
		this.facility = facility;
		this.startDate = startDate;
		this.endDate = endDate;

	}

	public Member getMember() {
		return member;
	}

	public Facility getFacility() {
		return facility;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public boolean overlaps(Booking other) {
		boolean result = false;
		// check if the facility name is the same
		if (this.facility.getName() == other.facility.getName()) {
		
			// check if start time is between the start and end time of the other booking
			if (this.getStartDate().isAfter(other.getStartDate())
					&& (this.getStartDate().isBefore(other.getEndDate()))) {
				
				result = true;
			}
			// check if end time is between the start and end time of the other booking
			if (this.getEndDate().isAfter(other.getStartDate()) && (this.getEndDate().isBefore(other.getEndDate()))) {
				
				result = true;
			}
			// check if start time is start and end time of the other booking
			if (this.getStartDate().isEqual(other.getStartDate()) || this.getStartDate().isEqual(other.getEndDate())) {
				
				result = true;
			}
			// check if end time is start and end time of the other booking
			if (this.getEndDate().isEqual(other.getStartDate()) || this.getEndDate().isEqual(other.getEndDate())) {
				
				result = true;
			}
		}

		return result;

	}

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");

	public String toString() {
		return this.getMember().getSurName() + " " + this.getMember().getFirstName() + " has booked "
				+ this.getFacility().getName() + " from " + this.getStartDate().format(formatter) + " to "
				+ this.getEndDate().format(formatter);
	}

	public void show() {
		System.out.println(toString());
	}
}