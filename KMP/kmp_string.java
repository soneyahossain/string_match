
package KMP;

import java.util.Scanner;

public class kmp_string {
    

    
    
   String input;
   String pattern;
   int n,m;
   Scanner in = new Scanner(System.in);
   int q;
   private int[] pai;
   
   kmp_string()
   {
       
   }
    
   
   void KMP_matcher()
   {
       precomputing();
       q=0;
       for (int i=0;i<n;i++)
       {
           while(q>0 && (pattern.charAt(q)!=input.charAt(i)))
           {
               q=pai[q];
           }
           if(pattern.charAt(q)==input.charAt(i))
           {
               q=q+1;
           }
           if(q==m)
           {
               System.out.println("pattern occurs with shift  :  "+((i-m)+1));
               q=pai[q-1];
           }
       }
       
   }
   
   
    void precomputing()
    {
       pai[0]=0;
       int k=0;
       for(int q=1;q<m;q++)
       {
           while(k>0 && (pattern.charAt(k)!=pattern.charAt(q)))
           {
               k=pai[k];
           }
           if(pattern.charAt(k)==pattern.charAt(q))
           {
               k=k+1;
           }
           pai[q]=k;
       }
       for (int i=0; i<pai.length; i++) {
             System.out.println(pai[i]);
        }
       System.out.println();
    }
    
    
    public static void main(String[] args) {
        System.out.println("Enter text string\n");

        kmp_string instance= new kmp_string();
        instance.input = instance.in.nextLine();
        System.out.println("Enter pattern string\n");
        instance.pattern = instance.in.nextLine();
        instance.n= instance.input.length();
        instance.m= instance.pattern.length();
        instance.pai=new int[instance.m];
        instance.KMP_matcher();
      
    }
    
}
