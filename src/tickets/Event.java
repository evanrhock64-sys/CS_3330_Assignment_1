package tickets;

public class Event {
    private final String name;
    private final String location;


    public Event(String name, String location){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Event name cannot be null or blank");
        }
        if(location == null || location.isBlank()){
            throw new IllegalArgumentException("Event location cannot be null or blank");
        }

        this.name = name;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public String toString(){
        return name + " @ " + location;
    }


}
