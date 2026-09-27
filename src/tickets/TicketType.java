package tickets;

public class TicketType {

    private final String name;
    private final double price;


    public TicketType(String name, double price) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if(price < 0){
            throw new IllegalArgumentException("price cannot be negative");
        }

        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
