import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> value_stack = new Stack<>();
    Stack<String> in_stack = new Stack<>();
    Stack<String> pre_stack = new Stack<>();

    for(int i=0; i < exp.length(); i++)
    {
        char ch = exp.charAt(i);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
        {
          int v2 = value_stack.pop();
          int v1 = value_stack.pop();

          int vfinal = operations(v1,v2,ch);
          value_stack.push(vfinal);


          String infixVal2 = in_stack.pop();
          String infixVal1 = in_stack.pop();


          String infixfinal = '(' + infixVal1 + ch + infixVal2 + ')';
          in_stack.push(infixfinal);



          String prefixVal2 = pre_stack.pop();
          String prefixVal1 = pre_stack.pop();
          String prefixfinal = ch + prefixVal1 + prefixVal2;
          pre_stack.push(prefixfinal);
        }
        else
        {
            value_stack.push(ch-'0');
            in_stack.push(ch+"");
            pre_stack.push(ch+"");
        }
    }
    System.out.println(value_stack.pop());
    System.out.println(in_stack.pop());
    System.out.println(pre_stack.pop());
   
 }
 public static int operations(int val1, int val2,char operation)
    {
        if(operation=='+')
        {
            return val1+val2;
        }
        else if(operation=='-')
        {
            return val1-val2;
        }
        else if(operation=='*')
        {
            return val1*val2;
        }
        else
        {
            return val1/val2;
        }
    }
}
