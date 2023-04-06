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


      for(int m = 0; m <= n; m++)
      {
         M.add(new ArrayList<Integer>(W));
         for (w = 0; w<=W; w++)
         {
            M.get(m).add(0);
         }

      } 



      for(ArrayList<Integer> my_list : M)
      {
         System.out.println(my_list);
      }
         


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
               
            }


         }

      }

      for(ArrayList<Integer> my_list : M)
      {
         System.out.println(my_list);
      }

      return 1000;


/* 

      for(int i = 0; i<n; i++)
      {
         M.add(new ArrayList<Integer>(W));

      }

      System.out.println(M.get(0).size());


      for (w = 0; w<W; w++)
      {        
         System.out.println("w: " + w);
         M.get(0).set(w, 0);

      }


      for(int i = 1; i<n; i++)
      {
         System.out.println("i: " + i);

         for(w=0; w<W; w++)
         {
            // maybe an issue with listW and listV starting at 1 not 0?
            // problem for later
            //System.out.println("wi: " + listW.get(i));
            //System.out.println("w: " +w);

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
      } */
      //return M.get(n).get(W);

   }  
}