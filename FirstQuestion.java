package saurabhhebbalkar_assignment1;
/**
 *
 * @author Saurabh
 */
public class FirstQuestion 
{        
    int[] array;
        
    public void sort(int[] array) 
        { // array length must be a power of 2
            this.array = array;
            sort(0, array.length);
            
	}
		
    private void sort(int low, int n) 
        {
		if (n > 1) 
                {
                    int mid = n >> 1;
                    sort(low, mid);
                    sort(low + mid, mid);
                    combine(low, n, 1);
                }
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
     
    public static void main(String[] args)
        {
            System.out.println("First Question of the Assignment:");
            
            int[] intArray = new int[] {4,8,6,7,9,10,20,2,100,21,23,36,234,54,91,1};
            
            System.out.println("\n"+"Before Sorting:");
            
            for (int i = 0; i < intArray.length; i++)
                {
                    System.out.print(intArray[i] +",");           
                } 
            System.out.println(); 
            
            //Creating Object of the Class
            FirstQuestion firstQ =new FirstQuestion();
            firstQ.sort(intArray);
            System.out.println("\n"+"After Sorting:");
            
            for (int i = 0; i < intArray.length; i++)
                {
                    System.out.print(intArray[i]+",");           
                } 
            System.out.println("\n"); 
        }             
  }