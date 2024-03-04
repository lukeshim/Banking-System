/**
    * @author Eunseop Shim (Group 12B)
    * @version CS2030S AY23/24 Semester 2
    */
public class Customer {
  private int customerId;
  private double arrivalTime;
  private double serviceTime;
  private double endTime;
  private Task task;
  private int amount;

  public Customer(int customerId, double arrivalTime,  
      double serviceTime, Task task, int amount) {
    this.customerId = customerId;
    this.arrivalTime = arrivalTime;
    this.serviceTime = serviceTime;
    this.endTime = arrivalTime + serviceTime;
    this.task = task;
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  public int getCustomerId() {
    return customerId;
  }

  public Task getTask() {
    return task;
  }

  public double getArrivalTime() {
    return arrivalTime;
  }

  public double getServiceTime() {
    return serviceTime;
  }

  public double getEndTime() {
    return endTime;
  }

  public void setArrivalTime(double arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String toString() {
    return String.format("C%d", customerId);
  }
}

