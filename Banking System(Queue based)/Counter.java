/**
    * @author Eunseop Shim (Group 12B)
    * @version CS2030S AY23/24 Semester 2
    */
public class Counter implements Comparable<Counter> {
  
  private int counterId;
  private boolean available;
  private Queue counterQueue;
  private int money;
  
  Counter(int counterId, boolean available, int l) {
    this.counterId = counterId;
    this.available = available;
    counterQueue = new Queue(l);
    this.money = 100;
  }
  
  public int getMoney() {
    return money;
  }

  public int getCounterId() {
    return counterId;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public void setMoney(int money) {
    this.money = money;
  }
  
  public Queue getCounterQueue() {
    return counterQueue;
  }

  public int compareTo(Counter other) {
    Queue otherQueue = other.getCounterQueue();
    return counterQueue.length() == otherQueue.length() 
        ? (counterId < other.getCounterId()
              ? -1 : 1)
        : counterQueue.length() < otherQueue.length() 
        ? -1
        : 1;
  }
}

