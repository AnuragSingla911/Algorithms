package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

import algo.Utilities;

public class connectingislands {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> list = Utilities.toList(new Integer[][] {
			{1,2,10},{2,3,5},{1,3,9}
		});
		System.out.println(new connectingislands().solve(3, list));

	}
	
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		
		set[] set = new set[A+1];
		
		for(int i =0; i< set.length ; i++) {
			set s = new set();
			s.rank = 0;
			s.parent = (i);
			set[i]=s;
		}
		Collections.sort(B, new Comparator<ArrayList<Integer>>() {
			
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(2).compareTo(o2.get(2));
			}
		});
		
		int sum =0;
		
		
		for(int i = 0; i < B.size() ; i++) {
			if(find(set,B.get(i).get(0)) == find(set,B.get(i).get(1))) {
				continue;
			}
			
		
			union(set, B.get(i).get(0), B.get(i).get(1));
			sum+= B.get(i).get(2);
			//System.out.println(sum);
			
		}
		
		return sum;
	}
	
	private void union(set[] set, int m, int n) {
		int x = find(set,m);
		int y = find(set,n);
		if(set[x].rank < set[y].rank) {
			set[x].parent = y;
		}else if(set[x].rank > set[y].rank) {
			set[y].parent = x;
		}else {
			set[y].parent = x;
			set[x].rank++;
		}
	}
	
	private int find(set[] set, int node) {
		if(set[node].parent != node) {
			set[node].parent = find(set, set[node].parent);
		}
		//System.out.println("find : "+ set[node].parent + " node + "+node);
		return set[node].parent;
	}
	
	class set{
		int rank;
		int parent;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return rank + " "+ parent;
		}
	}
	
	private int getRoot(Integer no, HashMap<Integer,Integer> parent) {
		
		if(parent.get(no) == Integer.MAX_VALUE) {
			return no;
		}
		
		return getRoot(parent.get(no), parent);
	}
	
	

	public int solve0(int A, ArrayList<ArrayList<Integer>> B) {



        LinkedHashMap<Integer, ArrayList<Edge>> graph = new LinkedHashMap<>();
        
        PriorityQueue<Edge> queue= new PriorityQueue<>();

        for(ArrayList<Integer> item : B) {
            Edge e = new Edge();
            e.startnode = item.get(0);
            e.endnode = item.get(1);
            e.weight = item.get(2);

            ArrayList<Edge> list = graph.get(item.get(0));

            if(list == null) {
                graph.put(item.get(0), new ArrayList<Edge>());
            }
            queue.add(e);
            graph.get(item.get(0)).add(e);
            
            Edge e1 = new Edge();
            e1.startnode = item.get(1);
            e1.endnode = item.get(0);
            e1.weight = item.get(2);

            ArrayList<Edge> list1 = graph.get(item.get(1));

            if(list1 == null) {
                graph.put(item.get(1), new ArrayList<Edge>());
            }

            graph.get(item.get(1)).add(e1);
            
            queue.add(e1);

        }
        
       
        HashMap<Integer, Boolean> visitedVertex = new HashMap<>();
        
        visitedVertex.put(1, true);
        
      
        
        int cost = 0;	
        
        while(visitedVertex.size() < A) {
            
            Edge min = null;
           int vertez = -1;
            
            for(Integer integer : visitedVertex.keySet()) {
                ArrayList<Edge> list = graph.get(integer);
                if(list != null) {
                    for(Edge edge : list) {
                        if(min == null || min.weight > edge.weight) {
                            if(!visitedVertex.containsKey(edge.endnode)) {
                                min = edge;
                                vertez = integer;
                            }
                        }
                    }
                }
            }
            if(vertez > -1) {
                graph.get(vertez).remove(min);
                System.out.println(min.weight);
                visitedVertex.put(min.endnode, true);
                cost+= min.weight;
            }
           
            
            
            
        }
        
        return cost;
        
        
    }

	class Edge {
		int weight;
		int startnode;
		int endnode;
	}
}
