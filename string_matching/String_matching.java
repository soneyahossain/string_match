package string_matching;

import java.util.Scanner;


public class String_matching {

   String input;
   String pattern;
   int n,m;
   
   Scanner in = new Scanner(System.in);
 
  void find_matching()
  {

      for (int s=0;s<n-m+1;s++)
      {
               if(pattern.equals(input.subSequence(s+0,s+m)))
               {
                   System.out.println("pattern occurs at index "+s);
               }
      }
  }
    public static void main(String[] args) {
      System.out.println("Enter string");
      
      String_matching instance= new String_matching();
      instance.input = instance.in.nextLine();
      
      instance.pattern = instance.in.nextLine();
      instance.n= instance.input.length();
       instance.m= instance.pattern.length();
       instance.find_matching();
       
    }
}

