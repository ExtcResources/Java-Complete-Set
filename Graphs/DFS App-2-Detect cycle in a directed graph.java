class GfG
{
    public boolean hasCycle(int v,LinkedList<Integer>[] alist,boolean[] visited,boolean[] explored) 
     {
    if(visited[v]==false){     
       explored[v]=true;
       visited[v]=true;
       Iterator<Integer> i = alist[v].listIterator();
       while(i.hasNext()){
           int ele=i.next();
           if(visited[ele]==false && hasCycle(ele,alist,visited,explored)){
                return true;
           }
                else if (explored[ele]){
                    return true;
                }
       }
       explored[v]=false;
    }
    return false;
       
     }
}