/**
 * The Seq<T> class for CS2030S 
 *
 * @author 
 * @version CS2030S AY23/24 Semester 2
 */
class Seq<T extends Comparable<T>> { // TODO: Change to bounded type parameter
  private T[] seq;
  int maxSize;
  
  @SuppressWarnings("rawtypes")
  Seq(int size) {
    @SuppressWarnings("unchecked")
    T[] a = (T[]) new Comparable[size];
    this.seq = a;
    this.maxSize = size;
  }

  public void set(int index, T item) {
    this.seq[index] = item;
  }

  public T get(int index) {
    return this.seq[index];
  }
  
  public int getLength() {
    return maxSize;
  }

  public T min() {
    T minimum = seq[0];
    for (int i = 1; i < seq.length; i++) {
      if (seq[i].compareTo(minimum) == -1) {
        minimum = seq[i];
      }  
    }
    return minimum;
  }

  public int indexOf(T el) {
    for (int i = 0; i < seq.length; i++) {
      if (el.equals(seq[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < this.seq.length; i++) {
      s.append(i + ":" + this.seq[i]);
      if (i != this.seq.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
