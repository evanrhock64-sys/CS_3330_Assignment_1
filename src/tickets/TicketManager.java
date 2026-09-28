package tickets;

public class TicketManager {

	private final TicketBook book;
	private int nextId;

	public TicketManager(int capacity) {
		this.book = new TicketBook(capacity);
		this.nextId = 1;
	}

	public int createTicket(Event event, TicketType type, String studentName) {
		int id = nextId;
		book.createTicket(id, event, type, studentName);
		nextId++;
		return id;
	}

	public boolean cancelTicket(int id) {
		Ticket ticket = requireTicket(id);
		return ticket.cancel();
	}
	public boolean admitTicket(int id) {
		Ticket ticket = requireTicket(id);
		return ticket.admit();
	}
	public void printAll() {
		book.printAll();
	}
	public void printForEvent(Event event) {
		book.printForEvent(event);
	}
	private Ticket requireTicket(int id) {
		Ticket ticket = book.findById(id);
		if (ticket == null) {
			throw new IllegalArgumentException("No ticket with id " + id);
		}
		return ticket;
	}
}
