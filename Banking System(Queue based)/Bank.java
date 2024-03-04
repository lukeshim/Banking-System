/**
 * @author Eunseop Shim (Group 12B)
 * @version CS2030S AY23/24 Semester 2
 */
public class Bank {
  private Seq<Counter> counterList;
  private Queue queue;
  
  public Bank() {
  }

  public Bank(Seq<Counter> counterList, Queue queue) {
    this.counterList = counterList;
    this.queue = queue;
  }
  
  public Queue getQueue() {
    return queue;
  }
  
  public void setQueue(Queue queue) {
    this.queue = queue;
  }

  public Seq<Counter> getCounterList() {
    return counterList;
  }

  public void setCounterList(Seq<Counter> counterList) {
    this.counterList = counterList;
  }
}
