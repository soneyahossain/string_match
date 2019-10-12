
package suffix_tree_lcp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class suffix_t_lcp {
    public static void main(String[] args) {
      
       Scanner in = new Scanner(System.in);
       System.out.println("Enter string");
       String Text = in.nextLine();
       String_matching instance= new String_matching(Text);
 //.......................................................
       instance.setP();
       instance.setL();
       
       instance.suffixcreater(); 
       System.out.println(instance.lcp(5,3));
       instance.find_distinct_substring();
    }
}


//................................................................................

class String_matching {

  String input;
  String pattern;
  int n,m;
  String dis;
   
  int p[][]; 
  int N ; 
  int i;
  int stp;
  int cnt;
  entry []L ;
   
  Scanner in = new Scanner(System.in);

    public String_matching(String dist) {
        dis = dist;
       
        L = new entry[dis.length()];
        
    }
    
    void setL()
    {
        for(int i=0; i<dis.length(); i++)
        {
            L[i] = new entry();
        }
    }
 
    void setP()
    {
       p = new int[65536][17];
    }
 
//.....................................................................................................................    
    
  void find_distinct_substring()
  {
     int answer=dis.length()-L[0].p;
     for(int i=0;i<dis.length()-1;i++)
     {
         answer=answer+(dis.length()-L[i+1].p)-lcp(L[i].p,L[i+1].p);
     }
      System.out.println(answer);
  }
  
  
  //...................................................................................................................
  void suffixcreater()
  {
        for( N =dis.length(),i=0; i<N; i++ )
        {
            p[0][i] = dis.charAt(i) - 'a';
           
        }


        for(stp= 1,cnt = 1; cnt >> 1 < N;stp ++,cnt<<= 1)
        { 
            for (i =0;i < N; i++) 
            { 
                L[i].nr[0]=p[stp - 1][i]; 
                L[i].nr[1]=i +cnt <N? p[stp -1][i + cnt]:-1; 
                L[i].p = i;
            }
            Arrays.sort(L, new comperator());
            for(int i =0; i< N; i++)
            {
                p[stp][L[i].p] =i > 0&&L[i].nr[0]== L[i- 1].nr[0] && L[i].nr[1] == L[i - 1].nr[1] ?
                p[stp][L[i-1].p] : i;
            }
        }
        
        for(int i=0; i<dis.length(); i++)
        {
            System.out.print(L[i].p);
        }
        System.out.println();
  
  }
  
  int lcp(int x, int y) 
    { 
        int k,ret =0; 
        if (x == y) {
            return N- x;
        }
        for(k=stp- 1; k >= 0&&x < N &&y < N; k --) {
            if(p[k][x]==p[k][y]) 
            {
                x +=1 << k;
                y +=1<<k; 
                ret +=1<<k; 
            }
        }
        return ret; 
    }
  
}

















class entry implements Comparable<entry>
{
    int p; 
    int []nr; 

    public entry() {
        nr = new int[2];
    }

    @Override
    public int compareTo(entry o) {
        if(this.nr[0] == o.nr[0])
        {
            if(this.nr[1] > o.nr[1])
                return 1;
            else if(this.nr[1] < o.nr[1])
                return -1;
            else
                return 0;
        }
        
        else
        {
            if(this.nr[0] > o.nr[0])
                return 1;
            else if(this.nr[0] < o.nr[0])
                return -1;
            else
                return 0;
        }
    }
}

class comperator implements Comparator<entry>
{
    @Override
    public int compare(entry a, entry b) {
       
        if(a.nr[0] == b.nr[0])
        {
            if(a.nr[1] > b.nr[1])
                return 1;
                //return a.nr[1] - b.nr[1];
            else if(a.nr[1] < b.nr[1])
                return -1;
                //return b.nr[1] - a.nr[1];
            else
                return 0;
            //return a.nr[1] - b.nr[1];
        }
        else
        {
            if(a.nr[0] > b.nr[0] )
                return 1;
            else if(a.nr[0] < b.nr[0])
                return -1;
            else 
                return 0;
        }
        
    }
}



