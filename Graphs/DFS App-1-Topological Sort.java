/* Given a directed graph you need to complete the function topoSort which returns an array having the topologically sorted elements of the array and takes two arguments . The first argument is the Graphgraph represented as adjacency list and the second is the number of vertices N .
Company: OYO Rooms, Moonfrog Labs, Microsoft, Flipkart, Amazon,Accolite
Note : There can be multiple topological sorts of a Graph.  The driver program that calls your function doesn't match your output element by element, but checks whether the output produced by your function is a valid topological sort or not.

Input:
The first line of input takes the no of test cases then T test cases follow . Each test case contains two lines . The first  line of each test case  contains two integers E and N representing no of edges and the no of vertices . Then in the next line are E  pairs of integers u v representing an edge from u to v in the graph.

Output:
For each test case output will be 1 if the topological sort is done correctly else it will be 0 .

Constraints:
1<=T<=50
1<=E,N<=50
0<=u,v
Example:
Input
1
6 6 
5 0 5 2 2 3 4 0 4 1 1 3

Output
1

The output 1 denotes that the order is valid.  So if you have implemented your function correctly, then output would be 1 for all test cases.*/

//CODE:

class Solution
{
         static void dfs(int v,ArrayList<Integer>[] graph,boolean[] visited,Stack<Integer> s){
        visited[v]=true;
        Iterator<Integer> i=graph[v].listIterator();
        while(i.hasNext()){
            int ele=i.next();
            if(visited[ele]==false)
                dfs(ele,graph,visited,s);
        }
        //System.out.println(v);
        s.push(v);
    }
         public static int[] topoSort(ArrayList<Integer> graph[],int N)
         {
         //add code here.
         boolean[] vis=new boolean[N];
         int[] a=new int[N];
         Stack<Integer> s=new Stack<Integer>();
         for(int i=0;i<N;i++){
             if(vis[i]==false)
                dfs(i,graph,vis,s);
            }
            int i=0;
            while(!s.isEmpty()){
                a[i]=s.pop();
                //System.out.println(a[i]);
                i++;
            }
            return a;
         }
}

//EXECUTION TIME: 0.19s