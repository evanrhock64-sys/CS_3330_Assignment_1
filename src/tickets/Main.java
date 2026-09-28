
//Github Repository Link:!!
//https://github.com/evanrhock64-sys/CS_3330_Assignment_1

package tickets;

public class Main {


	public static void main(String[] args) {

		Event lecture = new Event("Engineering Lab Lecture", "Engineering Building");
		Event workshop = new Event("Resume Workshop", "Student Center");


		TicketType student = new TicketType("Student", 0.0);
		TicketType general = new TicketType("General", 10.0);
		TicketType vip = new TicketType("Vip", 25.0);

		System.out.println("=== Events ===");
		System.out.println(lecture);
		System.out.println(workshop);

		System.out.println("\n=== Ticket Types ===");
		System.out.println(student);
		System.out.println(general);
		System.out.println(vip);


		System.out.println("\n=== Invalid Input Tests ===");
		try {
			new Event("", "Student Center");
		} catch (IllegalArgumentException e) {
			System.out.println("Caught: " + e.getMessage());
		}

		try {
			new TicketType("VIP", -5.0);
		} catch (IllegalArgumentException e) {
			System.out.println("Caught: " + e.getMessage());
		}

		TicketManager manager = new TicketManager(10);

		System.out.println("\n=== Creating Tickets ===");
		int t1 = manager.createTicket(lecture, student, "Evan");
		int t2 = manager.createTicket(lecture, general, "Holdyn");
		int t3 = manager.createTicket(workshop, vip, "Bob");
		int t4 = manager.createTicket(workshop, student, "Phil");
		int t5 = manager.createTicket(lecture, vip, "Bob2");
		System.out.println("Created ticket ids: "+ t1 +", "+ t2 +", "+ t3 +", "+ t4 +", "+ t5);

		try {
			manager.createTicket(lecture, student, "   ");
		} catch (IllegalArgumentException e) {
			System.out.println("Caught: "+ e.getMessage());
		}

		System.out.println("\n=== Admit and Cancel ===");
		report("Admit ticket " + t1, manager.admitTicket(t1));
		report("Cancel ticket " + t3, manager.cancelTicket(t3));

		System.out.println("\n=== Invalid Operations ===");
		report("Admit canceled ticket " + t3, manager.admitTicket(t3));
		report("Admit ticket " + t1 + " a second time", manager.admitTicket(t1));
		report("Cancel admitted ticket " + t1, manager.cancelTicket(t1));
		report("Cancel ticket " + t3 + " a second time", manager.cancelTicket(t3));

		try { 
			manager.admitTicket(99);
		}catch (IllegalArgumentException e) {
			System.out.println("Caught: "+ e.getMessage());
		}

		System.out.println("\n=== All Tickets ===");
		manager.printAll();

		System.out.println("\n=== Tickets for "+ lecture + " ===");
		manager.printForEvent(lecture);
	}
	private static void report(String action, boolean succeeded) {
		System.out.println(action + ": "+ (succeeded ? "Success" : "Rejected"));

	}
}
