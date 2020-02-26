package saurabhhebbalkar_assignment1;


import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Saurabh
 */
public class ThirdQuestion { 
        
    Object array[];
               
    public void sort(Object[] array, Comparator comp) 
        { // array length must be a power of 2
            this.array=array;
            sort(0, array.length, comp);
            
	}
		
    private void sort(int low, int n, Comparator comp) 
        {
		if (n > 1) 
                {
                    int mid = n >> 1;
                    sort(low, mid, comp);
                    sort(low + mid, mid, comp);
                    combine(low, n, 1, comp);
                }
	}
		
    private void combine(int low, int n, int st, Comparator comp) 
        {
            int m = st << 1;
            if (m < n)
            {
		combine(low, n, m, comp);
		combine(low + st, n, m, comp);
		for (int i = low + st; i + st < low + n; i += m)
		compareAndSwap(i, i + st, comp);
            } 
            else
                compareAndSwap(low, low + st, comp);
	}
    		
    public void compareAndSwap(int i, int j, Comparator comp) 
        {
           int varnum = comp.compare(array[i], array[j]);
           if (varnum > 0)
             swap(i, j);     
        }
		
    private void swap(int i, int j)
        {
            Object h = array[i];
            array[i] = array[j];
            array[j] = h;     
        }
   
    //Main Method
    public static void main(String[] args)
        {
            
            String[] names= {"Saurabh", "John", "Dave", "Conor", "Jake", "Rahul", "Martin",
                             "Jacob", "Andrew", "Bane", "Catherine" , "Gabriela", "Julia", 
                             "Ronan", "Sherlock", "Mason"};
            
            Double[] marks = {10.20, 20.12, 5.02, 9.90, 8.45, 2.02, 44.67, 29.20, 30.23, 
                                  5.46, 1.32, 4.99, 6.49, 56.49, 23.23, 78.90};
            
            System.out.println("Third Question of the Assignment:");
            //Before sorting the data
            System.out.println("\n"+"Before Sorting:");
            System.out.println(Arrays.toString(names));
            System.out.println(Arrays.toString(marks));
           
            //Use of Lambda Expression
            //Anonymous class of comparator type String using lambda
            Comparator <String> CompStringObj = (o1,o2) -> o1.compareToIgnoreCase(o2);
            
            //Anonymous class of comparator type Double using lambda
            Comparator <Double> CompDoubleObj = (o1, o2) -> o1.compareTo(o2); 
           
            //Creating object of the Class to call functions
            SecondQuestion sq = new SecondQuestion();
            
            System.out.println("\n"+"After Sorting:");
            sq.sort(names,CompStringObj);
            System.out.println(Arrays.toString(names));
            sq.sort(marks,CompDoubleObj);
            System.out.println(Arrays.toString(marks));
              
        }
                
  }