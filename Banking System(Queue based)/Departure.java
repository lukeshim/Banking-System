/**
    * @author Eunseop Shim (Group 12B)
    * @version CS2030S AY23/24 Semester 2
    */
public class Departure extends Event {
  private Customer customer;

  public Departure(Customer customer, boolean instantDeparture) {
    super(instantDeparture  
        ? customer.getArrivalTime() 
        : customer.getEndTime());
    this.customer = customer;
  }

  @Override
  public String toString() {
    return super.toString() +
      String.format(": C%d departed", customer.getCustomerId());
    
  }
  
  @Override
  public Event[] simulate() {
    return new Event[] {};
  }
}

