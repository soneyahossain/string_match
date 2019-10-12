
package distinct_substring_naive;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class naive_appraoch {
    
    
   String input;
   String pattern;
   int n;
   int hash[][];
   Set<String> SUB_SET=new HashSet<>();;
   
   Scanner in = new Scanner(System.in);
    
   void naive_approach()
   {
       n=input.length();
   }
    private void  distinct_sub_list(int length) 
    {
       
        for(int i=0; i<input.length()-length + 1; i++)
        {
            String sub_string = input.substring(i,length+i);
            SUB_SET.add(sub_string);
        } 
   } 
    
    void print_subset()
    {
        for (String string : SUB_SET) 
        {
            System.out.println(string);
        }
        System.out.println("size of substring: "+SUB_SET.size());
    }
    public static void main(String[] args) {
        
      System.out.println("Enter string");
      naive_appraoch instance= new naive_appraoch();
      instance.input = instance.in.nextLine();
      for(int i=1;i<=instance.input.length();i++) {
            instance.distinct_sub_list(i);
        }
      instance.print_subset();
    }
}
