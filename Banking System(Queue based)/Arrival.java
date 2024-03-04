/**
 *
    * @author Eunseop Shim (Group 12B)
    * @version CS2030S AY23/24 Semester 2
    `*/
public class Arrival extends Event {
  private Customer customer;
  private Bank bank;

  public Arrival(Customer customer, Bank bank) {
    super(customer.getArrivalTime());
    this.customer = customer;
    this.bank = bank;
  }

  public Event[] simulate() {
    Seq<Counter> counterList = bank.getCounterList();
    for (int i = 0; i < counterList.getLength(); i += 1) {
      if (counterList.get(i).isAvailable()) {
        return new Event[]{
          new ServiceBegin(customer, bank, i)
        };
      }
    }
    if (!counterList.min().getCounterQueue().isFull()) {
      return new Event[] {
        new QueueEvent(customer, bank,
            counterList.indexOf(counterList.min()), false)
      };
    }

    if (!bank.getQueue().isFull()) { 
      return new Event[] {
        new QueueEvent(customer, bank, -1, true)
      };
    } else {
      return new Event[] {
        new Departure(customer, true)
      };
    }
  }


  @Override
  public String toString() {
    return super.toString() +
      String.format(": C%d arrived ", customer.getCustomerId()) + 
        bank.getQueue().toString();
  }
}


