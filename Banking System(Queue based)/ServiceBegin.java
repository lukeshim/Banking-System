/**
    * @author Eunseop Shim (Group 12B)
    * @version CS2030S AY23/24 Semester 2
    */
public class ServiceBegin extends Event {
  private Customer customer;
  private Bank bank;
  private int nth;
  
  public ServiceBegin(Customer customer, Bank bank, int nth) {
    super(customer.getArrivalTime());
    this.customer = customer;
    this.bank = bank;
    this.nth = nth;
  }
  
  @Override
  public Event[] simulate() {
    bank.getCounterList().get(nth).setAvailable(false);
    return new Event[] {
      new ServiceEnd(customer, bank, nth)
    };
  }


  @Override
  public String toString() {
    return super.toString() +
      String.format(": C%d %s $%d begin (by S%d $%d %s)",
          customer.getCustomerId(),
          customer.getTask() == Task.DEPOSIT ? "deposit" : "withdrawal",
          customer.getAmount(),
          bank.getCounterList().get(nth).getCounterId(), 
          bank.getCounterList().get(nth).getMoney(), 
          bank.getCounterList().get(nth).getCounterQueue().toString());
  }
}

