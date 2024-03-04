/**
    * @author Eunseop Shim (Group 12B)
    * @version CS2030S AY23/24 Semester 2
    */
public class ServiceEnd extends Event {
  private Customer customer;
  private Bank bank;
  private int nth;
  private boolean success;

  public ServiceEnd(Customer customer, Bank bank, int nth) {
    super(customer.getEndTime());
    this.customer = customer;
    this.bank = bank;
    this.nth = nth;
    int counterMoney = bank.getCounterList().get(nth).getMoney();
    if (customer.getTask().equals(Task.WITHDRAWAL) && 
        customer.getAmount() > counterMoney) {
      this.success = false;
    } else {
      this.success = true;
      bank.getCounterList().get(nth).setMoney(counterMoney + customer.getAmount() * 
          (customer.getTask().equals(Task.WITHDRAWAL) ? -1 : 1));
    }

  }
  
  @Override
  public Event[] simulate() {
    Seq<Counter> counterList = bank.getCounterList();
    counterList.get(nth).setAvailable(true);
    if (!counterList.get(nth).getCounterQueue().isEmpty()) {
      
      Customer customerAtCounterQueue = (Customer) counterList.get(nth).getCounterQueue().deq();
      customerAtCounterQueue = new Customer(customerAtCounterQueue.getCustomerId(),
          customer.getEndTime(),
          customerAtCounterQueue.getServiceTime(),
          customerAtCounterQueue.getTask(),
          customerAtCounterQueue.getAmount());
      if (!bank.getQueue().isEmpty()) {
        Customer customerAtBankQueue = (Customer) bank.getQueue().deq();
        return new Event[] {
          new Departure(customer, false),
          new QueueEvent(new Customer(customerAtBankQueue.getCustomerId(),
                                      customer.getEndTime() + 0.01,
                                      customerAtBankQueue.getServiceTime(),
                                      customerAtBankQueue.getTask(),
                                      customerAtBankQueue.getAmount()),
              bank, nth, false),
          new ServiceBegin(customerAtCounterQueue, bank, nth),
        };
      }
      return new Event[] {
        new Departure(customer, false),
        new ServiceBegin(customerAtCounterQueue, bank, nth),
      };
      
    }
    
    if (!bank.getQueue().isEmpty()) {
      Customer customerAtQueue = (Customer) bank.getQueue().deq();
      
      customerAtQueue = new Customer(customerAtQueue.getCustomerId(),
          customer.getEndTime(),
          customerAtQueue.getServiceTime(),
          customerAtQueue.getTask(),
          customerAtQueue.getAmount());
      
      return new Event[] {
        new Departure(customer, false),
        new ServiceBegin(customerAtQueue, bank, nth),
      };
    }

    return new Event[] {
      new Departure(customer, false),
    };
  }


  @Override
  public String toString() {
    return super.toString() +
      String.format(": C%d %s $%d done (by S%d $%d %s) %s",
          customer.getCustomerId(),
          customer.getTask().equals(Task.DEPOSIT) ? "deposit" : "withdrawal",
          customer.getAmount(),
          bank.getCounterList().get(nth).getCounterId(),
          bank.getCounterList().get(nth).getMoney(),
          bank.getCounterList().get(nth).getCounterQueue().toString(),
          this.success == true ? "success" : "fail");
  }
}

