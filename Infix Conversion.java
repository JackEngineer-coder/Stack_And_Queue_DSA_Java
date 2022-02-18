import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    
    Stack<String> postfix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    Stack<Character> operations = new Stack<>();

    for(int i =0; i<exp.length();i++)
    {
        char ch = exp.charAt(i);
        if(ch =='(')
        {
           operations.push(ch);
        }
        else if((ch>='0' && ch<='9') || (ch >= 'a' &&ch <= 'z') || (ch >='A' && ch<='Z'))
        {
           postfix.push(ch+"");
           prefix.push(ch+"");
        }
        else if(ch==')')
        {
          while(operations.peek() != '(')
          {
             char op = operations.pop();

             String postv2 = postfix.pop();
             String postv1 = postfix.pop();

             String postv =   postv1 + postv2 + op;
             postfix.push(postv);

             String prev2 = prefix.pop();
             String prev1 = prefix.pop();
             String prev = op + prev1 + prev2;
             prefix.push(prev);


          }

          operations.pop();
        }
        else if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
        {
           while(operations.size()>0 && operations.peek() != '(' && precedence(ch) <= precedence(operations.peek()))
           {
            char op = operations.pop();

             String postv2 = postfix.pop();
             String postv1 = postfix.pop();

             String postv =   postv1 + postv2 + op;
             postfix.push(postv);

             String prev2 = prefix.pop();
             String prev1 = prefix.pop();
             String prev = op + prev1 + prev2;
             prefix.push(prev);

           }
           operations.push(ch);
        }
    }
    while(operations.size()>0)
    {
            char op = operations.pop();

             String postv2 = postfix.pop();
             String postv1 = postfix.pop();

             String postv =   postv1 + postv2 + op;
             postfix.push(postv);

             String prev2 = prefix.pop();
             String prev1 = prefix.pop();
             String prev = op + prev1 + prev2;
             prefix.push(prev);
    }
    System.out.println(postfix.pop());
    System.out.println(prefix.pop());


}

    public static int precedence(char op) {
        if(op =='+' || op =='-')
        {
            return 1;
        }
        else if(op =='*' || op =='/')
        {
            return 2;
        }
        else
        {
            return 0;
        }
        
    }

}
 
