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
      int W = 10;
      ArrayList<Integer> listW = new ArrayList<Integer>();
      listW.add(1);
      listW.add(2);
      listW.add(5);
      listW.add(6);
      listW.add(7);



      ArrayList<Integer> listV = new ArrayList<Integer>();
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
      System.out.println(listW);
      System.out.println(listV);
      System.out.println(W);


      ArrayList<Integer> list1 = new ArrayList<Integer>(n);
      for(int i = 0; i<n; i++)
      {
         list1.add(0);
      }
      ArrayList<Integer> list2 = new ArrayList<Integer>(W);
      for(int i = 0; i<W; i++)
      {
         list2.add(0);
      }

      M.add(list1);
      M.add(list2);



      for (w = 0; w<W; w++)
      {
         System.out.println(w);

         
         M.get(1).set(w, 0);

      }


      for(int i = 1; i<n; i++)
      {

         for(w=0; w<W; w++)
         {
            // maybe an issue with listW and listV starting at 1 not 0?
            // problem for later
            if(listW.get(i) > w)
            {
               M.get(i).set(w, (M.get(i-1).get(w)));
            }
            else
            {
               int a = (M.get(i-1).get(w));
               int b = (listV.get(i) + M.get(i-1).get(w-(listW.get(i))));
               M.get(i).set(w, (Math.max(a,b)));
            }
         }
      }
      return M.get(n).get(W);

   }  
}