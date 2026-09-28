package tickets;

/*
 * State rules:
 * - A new ticket is ACTIVE (not canceled, not admitted).
 * - Only an ACTIVE ticket can be admitted or canceled.
 * - Admitting or canceling a ticket that is already admitted or canceled is rejected: the method returns false and the state does not change.
 * These rules guarantee a ticket is never both canceled and admitted.
 */
public class Ticket {

	private final int id;
	private final String studentName;
	private final TicketType ticketType;
	private final Event event;
	private boolean canceled;
	private boolean admitted;


	public Ticket(int id, String studentName, TicketType ticketType, Event event) {
		if(id <= 0){
			throw new IllegalArgumentException("Ticket id must be positive");
		}
		if(studentName == null || studentName.isBlank()){
			throw new IllegalArgumentException("Student name cannot be null or blank");
		}
		if(ticketType == null){
			throw new IllegalArgumentException("Ticket type cannot be null");
		}
		if(event == null){
			throw new IllegalArgumentException("Event cannot be null");
		}

		this.id = id;
		this.studentName = studentName;
		this.ticketType = ticketType;
		this.event = event;
		this.canceled = false;
		this.admitted = false;
	}
	public boolean isCanceled(){
		return canceled;
	}
	public boolean isAdmitted() {
		return admitted;
	}
	public boolean isActive(){
		if(isCanceled()||isAdmitted()){
			return false;
		} else {
			return true;
		}
	}
	public boolean admit(){
		if(isActive()){
			admitted = true;
			return true;
		} else {
			return false;
		}
	}
	public boolean cancel(){
		if(isActive()){
			canceled = true;
			return true;
		} else {
			return false;
		}
	}
	public int getId() {
		return id;
	}
	// Compares by reference (==), not equals(). Each event is created once in Main, so all tickets for that event share the same Event object. Two separate Event objects with the same name and location count as different.
	public boolean isForEvent(Event other) {
		return this.event == other;
	}
	@Override
	public String toString(){
		if(isActive()){
			return "Ticket #" + id + " for " + studentName + " to " + event.toString() + " (" + ticketType.toString() + ") - ACTIVE";
		} else if(isCanceled()){
			return "Ticket #" + id + " for " + studentName + " to " + event.toString() + " (" + ticketType.toString() + ") - CANCELED";
		} else {
			return "Ticket #" + id + " for " + studentName + " to " + event.toString() + " (" + ticketType.toString() + ") - ADMITTED";
		}
	}



}
