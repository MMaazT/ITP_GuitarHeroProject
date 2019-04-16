// Name: Muhammed Maaz Tariq | ERP ID: 12407
/*********************************************/
public class GuitarString {
 
  private RingBuffer ringbuffer;
  private int N;
  private int countTic;
 
  // creates a guitar string of the specified frequency,
  // using sampling rate of 44,100
  public GuitarString(double frequency) {
    N= (int)(Math.round (44100/frequency));
    ringbuffer= new RingBuffer(N);
    for(int i =0; i<N; i++) ringbuffer.enqueue(0);
  }
  
  // creates a guitar string whose size and initial values are given by
  // the specified array
  public GuitarString(double[] init) {
    N= init.length;
    ringbuffer= new RingBuffer(N);
    for(int i =0; i<N; i++) ringbuffer.enqueue(init[i]); 
  }
  
// plucks the guitar string (by replacing the buffer with white noise)
  public void pluck() {                   
    for (int i=0; i<N; i++) {         
    ringbuffer.dequeue(); 
    }
    for (int i=0; i<N; i++) { 
      ringbuffer.enqueue( Math.random()-0.5);
                     
    }
  }
  
// advances the Karplus-String simulation one time step
  public void tic() {
    countTic++;
    double t= ringbuffer.dequeue();
    double v= ringbuffer.peek();
    
    ringbuffer.enqueue(((t+v)/2 )* 0.994); // Note: The answers for the test client below on checklist/guitar are for 
                                           //the decay factor of 0.996 instead of 0.994. Therefore, there is a  
                                           //slight discrepancy in the answers for i>9.
  }
   
// returns the current sample
  public double sample() {
    return  ringbuffer.peek();
  }
// returns the number of time tic() was called    
  public int time() {
    return countTic;
  }
  
// unit tests this class
  public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
      GuitarString testString = new GuitarString(samples);
      for (int i = 0; i < N; i++) {
          int t = testString.time();
          double sample = testString.sample();
          System.out.printf("%6d %8.4f\n", t, sample);
          testString.tic();
      }
  }
  
}  
  
     
    
  
  

                      
                      
                      
                      
                      
                      
                      
  
      