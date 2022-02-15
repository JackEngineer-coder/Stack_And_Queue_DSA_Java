import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> operands = new Stack<>(); // data stack
    Stack<Character> operators = new Stack<>(); // operator stack
    
    
    for(int i=0; i < exp.length();i++)
    {
        char ch = exp.charAt(i);
        if(ch == '(')
        {
           operators.push(ch);
        }
         else if(Character.isDigit(ch))
        {
            operands.push(ch-'0');
        }
        else if(ch == ')')
        {
            while(operators.peek() !='(')
            {
                char operator = operators.pop();
                int v2 = operands.pop();
                int v1  = operands.pop();

                int operation_result = operation(v1,v2,operator);
                operands.push(operation_result);
            }
            operators.pop();
        }

        else if(ch =='+' || ch =='-' || ch=='*' || ch == '/')

            {
                while(operators.size() > 0 && precedence(ch) <= precedence(operators.peek()) &&  operators.peek() != '(')
                {

                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int operation_result = operation(v1,v2,operator);
                    operands.push(operation_result);
                }
                operators.push(ch);
            }
    }
    
    while(operators.size() != 0)
    {
        char operator = operators.pop();
        int v2 = operands.pop();
        int v1  = operands.pop();

        int operation_result = operation(v1,v2,operator);
        operands.push(operation_result);
    }
    System.out.println(operands.peek());
}

    // This function will give priority to the operator for example divide and multiply have the high priority than addition and subtraction
    public static int precedence(char operator)
    {
        if(operator == '+')
        {
            return 1;
        }
        else if(operator == '-')
        {
            return 1;
        }
        else if(operator == '*')
        {
            return 2;
        }
        else
        {
            return 2;
        }
   
    }


    // This function will give value after operation
    public static int operation(int v1, int v2, char operator)
    {  
        if(operator == '+')
        {
            return v1+v2;
        }

       
        else if(operator == '-')
        {
            return v1-v2;
        }
        else if(operator == '*')
        {
            return v1*v2;
        }
        else 
        {
            return v1/v2;
        }
        
    }
}
