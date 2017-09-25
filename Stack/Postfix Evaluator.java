/*Given a postfix expression, the task is to evaluate the expression and print the final value.
Input:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an postfix expression.

Output:
For each test case, evaluate the postfix expression and print the value.

Constraints:
1 <= T <= 100
1 <= length of expression <= 100
Example:
Input:
2
231*+9-
123+*8-
Output:
-4
-3

Algorithm:
1) Create a stack to store operands (or values).
2) Scan the given expression and do following for every scanned element.
…..a) If the element is a number, push it into the stack
…..b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and push the result back to the stack
3) When the expression is ended, the number in the stack is the final answer
Example:
Let the given expression be “2 10   + 96 -/“. We scan all elements one by one.

1) Scan ‘2’, it’s a number, so push it to stack. Stack contains ‘2’

2) Scan ‘10’, again a number, push it to stack, stack now contains ‘2 10’ (from bottom to top)
3) Scan ‘+’, it’s an operator, pop two operands from stack, apply the + operator on operands, we get 2*10 which results in 12. We push the result ‘12’ to stack. Stack now becomes ‘12’.
4) Scan ‘9’, it’s a number, we push it to the stack. Stack now becomes ‘12 9’.
5) Scan ‘6’, it’s a number, we push it to the stack. Stack now becomes ‘12 9 6’
6) Scan ‘-‘, it’s an operator, pop two operands from stack, apply the – operator on operands, we get 9-6 which results in 3. We push the result ‘3’ to stack. Stack now becomes ‘12 3’.
7) Scan ‘/‘, it’s an operator, pop two operands from stack, apply the / operator on operands, we get 12/3 which results in 4. We push the result ‘3’ to stack. Stack now becomes ‘4’.

8) There are no more elements to scan, we return the top element from stack (which is the only element left in stack).*/

//CODE:
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
 
    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();
         
        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
             
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
            stack.push(c - '0');
             
            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop(); 
    }
     
    // Driver program to test above functions
    public static void main(String[] args) 
    {   Scanner sc = new Scanner (System.in);
        int m = sc.nextInt();
        for(int mi=0;mi<m;mi++){
        String exp=sc.next();
        System.out.println(evaluatePostfix(exp));
        }
    }
}

//Execution Time: 0.08 secs