import java.util.*;

/**
 * Anja Samsom HW 9 Programming
 * CS 224
 */
public class program
{  
   public static ArrayList<ArrayList<Integer>> M = new ArrayList<ArrayList<Integer>>();
   

   public static void main(String[]args)
   {
      int W = 11;
      ArrayList<Integer> listW = new ArrayList<Integer>();
      listW.add(0);
      listW.add(1);
      listW.add(2);
      listW.add(5);
      listW.add(6);
      listW.add(7);



      ArrayList<Integer> listV = new ArrayList<Integer>();
      listV.add(0);
      listV.add(1);
      listV.add(6);
      listV.add(18);
      listV.add(22);
      listV.add(28);

      System.out.println(knapsack(W, listW, listV));
   }

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

      int vi;
      int wi;
      int a;
      int b;
      int max;
      for(int i = 1; i<n; i++)
      {

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

               a = (M.get(i-1).get(w));
               b = (vi + M.get(i-1).get(w-wi));

               if(a>b)
                  max = a;
               else
                  max = b;

               
               M.get(i).set(w, max);
            }



         }
         System.out.println("new table:");
         for(ArrayList<Integer> my_list : M)
         {
            System.out.println(my_list);
         }
         System.out.println();

      }


      return M.get(n-1).get(W);

   }  
}