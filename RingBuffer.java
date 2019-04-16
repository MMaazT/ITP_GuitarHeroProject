// Name: Muhammed Maaz Tariq | ERP ID: 12407
/*********************************************/
public class RingBuffer {
 private int first;
 private int last;
 private double [] buffer;
 private int count;

 // creates an empty ring buffer with the specified capacity
 public RingBuffer(int capacity) {  
    buffer= new double[capacity];
  }
 
 public int size() {
      return count;
 }
 // is this ring buffer empty (size equals zero)?
 public boolean isEmpty() {
   if (this.size()==0) return true;
   return false;
 }
 // is this ring buffer full (size equals capacity)?
 public boolean isFull() {
  if (this.size()==buffer.length) 
    return true;
  return false;
}
 // adds item x to the end of this ring buffer
 public void enqueue (double x) {
  count++;
  if (count>buffer.length)
     throw new ArrayIndexOutOfBoundsException("Attempting to enqueue into a full buffer");
  buffer[last]= x;
  if (last==buffer.length-1) 
    last=0;
  else last++;
  }
 // deletes and returns the item at the front of this ring buffer
 public double dequeue(){
   count--; 
    if(count<0) 
     throw new ArrayIndexOutOfBoundsException("Attempting to dequeue from an empty buffer");
   double c= buffer[first];
      buffer[first]=0;
    if (first==buffer.length-1) 
      first=0;
    else first++;
        
   return c;
 }
 // returns the item at the front of this ring buffer
 public double peek() {
   return buffer[first];
 }
 
 // unit tests this class
 
 public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      RingBuffer buffer = new RingBuffer(N);  
      for (int i = 1; i <= N; i++) {
          buffer.enqueue(i);
      }
      System.out.println(buffer.isFull()); // buffer should be full at this instant. The check should return true.
      
      double t = buffer.dequeue();
      
      System.out.println(buffer.isFull()); // buffer should be one element less than full this instant. The check should return false.
      
      buffer.enqueue(t);
      
      System.out.println(buffer.isFull()); // buffer should be full again at this instant. The check should return true.
      
      System.out.println("Size after wrap-around is " + buffer.size());
      
      while (buffer.size() >= 2) {
          double x = buffer.dequeue();
          double y = buffer.dequeue();
          buffer.enqueue(x + y);
      }
      System.out.println(buffer.peek());
      
      System.out.println("The size of the buffer after above operations is: " +buffer.size()); // The buffer would 
                                                                           // contain one element at this instant.
      double o = buffer.dequeue(); // The buffer is now empty.
      System.out.println(buffer.isEmpty()); // The check should return true. Further dequeueing would result in 
      

  }

  
   
 }


   
   
  