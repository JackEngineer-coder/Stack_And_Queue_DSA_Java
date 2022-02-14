import java.io.*;

import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new
                                           InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // nge begin
    int[] nge = new int[arr.length];
    Stack< Integer> st = new Stack<>();
    st.push(arr.length - 1);
    nge[arr.length - 1] = arr.length;

    for (int i = arr.length - 2; i >= 0; i--) {
      while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        nge[i] = arr.length;
      } else {
        nge[i] = st.peek();
      }

      st.push(i);
    }

    // nge end
    int i = 0;
    for (int w = 0; w <= arr.length - k; w++) {
      if (i < w) {
        i = w;
      }

      while (nge[i] < w + k) {
        i = nge[i];
      }
      System.out.println(arr[i]);
    }
  }
}
