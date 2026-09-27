package tickets;

public class TicketBook {
	private final Ticket[] tickets;
	private int count;
	
	public TicketBook(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive");
		}
		this.tickets = new Ticket[capacity];
		this.count = 0;
	}
	
	public Ticket createTicket(int id, Event event, TicketType type, String studentName) {
		if (count >= tickets.length) {
			throw new IllegalStateException("Ticket book is full (capacity " +tickets.length +")");
		}
		if (findById(id) != null) {
			throw new IllegalArgumentException("Ticket id " + id + " already exists");
		}
		Ticket ticket = new Ticket(id, studentName, type, event);
		tickets[count] = ticket;
		count++;
		return ticket;
	}
	
	public Ticket findById(int id) {
		for (int i = 0; i < count; i++) {
			if (tickets[i].getId() == id) {
				return tickets[i];
			}
		}
		return null;
	}
	public void printAll() {
		if (count == 0) {
			System.out.println("No Tickets.");
			return;
		}
		for (int i = 0; i < count; i++) {
			System.out.println(tickets[i]);
		}
	}
	
	public void printForEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException("Event cannot be null");
		}
		boolean found = false;
		for (int i = 0; i < count; i++) {
			if (tickets[i].isForEvent(event)) {
				System.out.println(tickets[i]);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No tickets for " + event);
		}
	}
}
