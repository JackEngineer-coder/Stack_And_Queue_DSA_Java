import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   int [] ans = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   st.push(0);
   for(int i=0; i<arr.length;i++)
   {
     while(st.size() > 0 && arr[i] > arr[st.peek()])
     {
       int pidx =  st.pop();
       
       ans[pidx] = arr[i];
     }
      st.push(i);
   }
   while(st.size() > 0)
   {
     int pidx = st.pop();
     ans[pidx] = -1;
   }
   return ans;
 }

}
