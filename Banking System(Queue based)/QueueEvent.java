/**
 * @author Eunseop Shim (Group 12B)
 * @version CS2030S AY23/24 Semester 2
 */

public class QueueEvent extends Event {
  private Customer customer;
  private Bank bank;
  private boolean isbankQueue;
  private int nth;

  public QueueEvent(Customer customer, Bank bank, int nth, boolean isbankQueue) {
    super(customer.getArrivalTime());
    this.customer = customer;
    this.bank = bank;
    this.nth = nth;
    this.isbankQueue = isbankQueue;
  }

  @Override
  public String toString() {
    return super.toString() +
      String.format(": C%d joined %s queue ", customer.getCustomerId(),
      (isbankQueue ? "bank" : "counter")) + 
      (isbankQueue ? bank.getQueue().toString() 
                   : String.format("(at S%d $%d %s)", nth,
                     bank.getCounterList().get(nth).getMoney(),
                     bank.getCounterList().get(nth).getCounterQueue().toString()));
  }
    
  @Override
  public Event[] simulate() {
    if (isbankQueue) {
      bank.getQueue().enq(customer);
    } else {
      bank.getCounterList().get(nth).getCounterQueue().enq(customer);
    }
    return new Event[] {};
  }
}

