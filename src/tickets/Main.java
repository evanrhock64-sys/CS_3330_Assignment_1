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

}





}
