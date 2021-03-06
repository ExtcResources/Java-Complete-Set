/*Company: Yatra.com, Walmart Labs, Snapdeal, Oracle, Amazon

Question: 
Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases. 
Each test case consist of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if pair of parenthesis are balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 100

Example:
Input:
3
{([])}
()
()[]
Output:
balanced
balanced
balanced
*/

//CODE:

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
 public static void main (String[] args) {
 Scanner sc = new Scanner (System.in);
 int m = sc.nextInt();
 for(int mi=0;mi<m;mi++){
     String s= sc.next();
     char []c = s.toCharArray();
     if(find(c)){System.out.println("balanced");}
     else{System.out.println("not balanced");}
     
 }
 }
 public static boolean find(char[] c){
     Stack <Character> s= new Stack<>();
     for(int i=0;i<c.length;i++){
         if (c[i] == '{' || c[i] == '(' || c[i] == '['){s.push(c[i]);}
         if (c[i] == '}' || c[i] == ')' || c[i] == ']'){
             if(s.empty()){return false;}
             else if ( !isMatchingPair(s.pop(), c[i]) )
               {return false;}
         }
     }
     if(s.empty()){return true;}
     else{return false;}
 }
 public static boolean isMatchingPair(char character1, char character2)
    {
       if (character1 == '(' && character2 == ')')
         return true;
       else if (character1 == '{' && character2 == '}')
         return true;
       else if (character1 == '[' && character2 == ']')
         return true;
       else
         return false;
    }
}

//EXECUTION TIME: 0.09s 