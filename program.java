import java.util.*;

/**
 * Anja Samsom HW 9 Programming
 * CS 224
 */
public class program
{  
   public static ArrayList<ArrayList<Integer>> M = new ArrayList<ArrayList<Integer>>();
   public static ArrayList<Integer> listW = new ArrayList<Integer>();
   public static ArrayList<Integer> listV = new ArrayList<Integer>();


   public static void main(String[]args)
   {
      // list of weights
      listW.add(0);
      listW.add(1);
      listW.add(2);
      listW.add(5);
      listW.add(6);
      listW.add(7);

      // list of values
      listV.add(0);
      listV.add(1);
      listV.add(6);
      listV.add(18);
      listV.add(22);
      listV.add(28); 


      // change this value to 10
      int W = 11;
      System.out.println("W = " + W);
      System.out.println("Value is " + knapsack(W, listW, listV));
      System.out.print("The set of items is ");
      traceback(5, W);
   }

   public static void run_methods(int W)
   {}

   public static int knapsack(int W, ArrayList<Integer> listW, ArrayList<Integer> listV)
   {
      
      int w;
      int n = listW.size();


      for(int m = 0; m < n; m++)
      {
         M.add(new ArrayList<Integer>(W));
         for (w = 0; w<=W; w++)
         {
            M.get(m).add(0);
         }
      } 

      /// declaring a lot of variables to fill later so it is easier
      int vi;
      int wi;
      int a;
      int b;
      int max;

      // loop through i
      for(int i = 1; i<n; i++)
      {

         // loop through w
         for(w=0; w<=W; w++)
         {
            if(listW.get(i)>w)
            {
               M.get(i).set(w, M.get(i-1).get(w));
            }
            else
            {
               vi = listV.get(i);
               wi = listW.get(i);

               // find maximum of these two terms
               a = (M.get(i-1).get(w));
               b = (vi + M.get(i-1).get(w-wi));

               if(a>b)
                  max = a;
               else
                  max = b;

               M.get(i).set(w, max);
            }

         }
         System.out.println("memoization table:");
         for(ArrayList<Integer> my_list : M)
         {
            System.out.println(my_list);
         }
         System.out.println();

      }
      System.out.println();


      return M.get(n-1).get(W);

   }
    
   public static int traceback(int i, int w)
   {
      int wi = listW.get(i);
      int vi = listV.get(i);

      if(i == 0)
      {
         System.out.println();
         return 0;
      }


      if(wi > w)
         return traceback(i-1, w);

      else if(vi + M.get(i-1).get(w-wi) > M.get(i-1).get(w))
      {
         System.out.print(i + " " );
         return traceback(i-1, w-wi);
      }

      else
         return traceback(i-1, w);
         
   }

}