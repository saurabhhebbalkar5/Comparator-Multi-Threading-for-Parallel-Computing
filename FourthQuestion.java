package saurabhhebbalkar_assignment1;

/**
 *
 * @author Saurabh
 */
public class FourthQuestion extends Thread
{        
       static int[] array;
        
        public void sort(int[] array) 
        { // array length must be a power of 2
            this.array = array;
            sort(0, array.length);    
	}
       
        //Constructor of class to initialize int valiabes to be used in run()
        int num1, num2;
        public FourthQuestion(int num1, int num2){
            this.num1=num1;
            this.num2=num2;
        }
		
        private void sort(int low, int n) 
        {
		if (n > 1) 
                {
                    int mid = n >> 1;
                    //Initializing Thread object
                    Thread t1 = new Thread(new FourthQuestion(low, mid));
                    t1.start();
                    try {
                        t1.join();
                    }
                    catch (InterruptedException e){}
                    
                    Thread t2 = new Thread(new FourthQuestion(low + mid,mid));
                    t2.start();
                    try {
                        t2.join();
                    }
                    catch (InterruptedException e){}
                    combine(low, n, 1);
                }
	}
        
        //Overriding the Run method from Thread
        @Override
        public void run() {
        //Printing the thread and its ID
        System.out.println("Thread Start ID:"+Thread.currentThread().getId());
        try {
            
            //Calling the sort method
            sort(num1,num2);
            
        } catch (Exception e) {
        }
        System.out.println("Thread End ID: "+Thread.currentThread().getId());
    }
        
    private void combine(int low, int n, int st) 
        {
            int m = st << 1;
            if (m < n)
            {
		combine(low, n, m);
		combine(low + st, n, m);
		for (int i = low + st; i + st < low + n; i += m)
		compareAndSwap(i, i + st);
            } 
            else
                compareAndSwap(low, low + st);
	}
    
    private void compareAndSwap(int i, int j) 
        {
            if (array[i] > array[j])
            swap(i, j);
	}
		
    private void swap(int i, int j)
        {
            int h = array[i];
            array[i] = array[j];
            array[j] = h;
        }
        
    //Empty Constructor of the class
    public FourthQuestion(){
        };
    
    public static void main(String[] args)
        {
          System.out.println("Fourth Question of the Assignment:");
             
            array = new int[] {4,8,6,7,9,10,20,2,100,21,23,36,234,54,91,1};
            
            System.out.println("\n"+"Before Sorting:");
            
            for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] +",");           
            } 
            System.out.println("\n"); 
            
            FourthQuestion fourthQ =new FourthQuestion();
            fourthQ.sort(array);
            System.out.println("\n"+"After Sorting:");
            
            for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i]+",");           
            } 
            System.out.println("\n"); 
        }
                
  }