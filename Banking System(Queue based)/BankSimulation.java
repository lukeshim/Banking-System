import java.util.Scanner;
/**
 * @author Eunseop Shim (Group 12B)
 * @version CS2030S AY23/24 Semester 2
 */

class BankSimulation extends Simulation {
  
  private Bank bank;
  private Event[] initEvents;
  
  /**
     * Constructor for a bank simulation.
     *
     * @param sc A scanner to read the parameters from.  The first
     *           integer scanned is the number of customers; followed
     *           by the number of service counters.  Next is a
     *           sequence of (arrival time, service time) pair, each
     *           pair represents a customer.
     */
  
  public BankSimulation(Scanner sc) {
    initEvents = new Event[sc.nextInt()];
    bank = new Bank();
    int numOfCounters = sc.nextInt();
    int l = sc.nextInt();
    bank.setCounterList(new Seq<Counter>(numOfCounters));
    for (int i = 0; i < numOfCounters; i++) {
      bank.getCounterList().set(i, new Counter(i, true, l));
    }
    int maxQueue = sc.nextInt();
    bank.setQueue(new Queue(maxQueue));

    int id = 0;
    
    while (sc.hasNextDouble()) {
      Customer customer = new Customer(id, sc.nextDouble(), sc.nextDouble(), 
          (sc.nextInt() == 0 ? Task.DEPOSIT : Task.WITHDRAWAL),
          sc.nextInt());

      initEvents[id] = new Arrival(customer, bank);
      id += 1;
    }
  }

  /**
  * Retrieve an array of events to populate the
  * simulator with.
  *
  * @return An array of events for the simulator.
  */
  
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}

