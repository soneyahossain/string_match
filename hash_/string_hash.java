
package hash_;

import java.util.Scanner;





public class string_hash {
    
    
   String input;
   String pattern;
   int n,m;
   int hash[][];
   
    Scanner in = new Scanner(System.in);
    
    void calculate_hash_value()
    {
        
        for(int index=0;index<n-m+1;index++)
        {
            
       
            hash[index][0]=calculate_hash(0,0)%13;
            System.out.print(hash[index][0]+" ");
            hash[index][1]=calculate_hash(index,0)%27;
            System.out.println(hash[index][1]);
            
            
        }
    }
    
    
    int calculate_hash(int index,int flag) {
        
        int p=0;
        
        for (int i=0;i<m;i++)          
        {
         
            if(flag==0)p=p+input.charAt(index++);
            else p=p+pattern.charAt(index++);
        }
        
        return p;
        
    }
    
    void rabin_karp_matcher()
    {
        
        int p= calculate_hash(0,1)%13;
        int q= calculate_hash(0,1)%27;
        
        for(int index=0;index<n-m+1;index++)
        {
              if((p==hash[index][0])&& (q==hash[index][1]))
              {
                  System.out.println("match found at index: "+index);
              }
        }
        
        
    }
    
    
    public static void main(String[] args) {
      System.out.println("Enter string");
      
      string_hash instance= new string_hash();
      instance.input = instance.in.nextLine();
      
      instance.pattern = instance.in.nextLine();
      instance.n= instance.input.length();
      instance.m= instance.pattern.length();
      instance.hash=new int[ instance.n- instance.m+1][2];
      instance.calculate_hash_value();
      instance.rabin_karp_matcher();
    }

   
    
}
