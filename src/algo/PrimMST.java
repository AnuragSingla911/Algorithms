package algo;
// A Java program for Prim's Minimum Spanning Tree (MST) algorithm. 

public class PrimMST {

	public static void main(String[] args) {

		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

		PrimMST mst = new PrimMST();
		int[] result = mst.MST(graph);
		mst.printMST(result, 0, graph);
	}

	public int[] MST(int[][] graph) {

		int[] parent = new int[graph.length];
		int[] keys = new int[graph.length];
		boolean[] visited = new boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			keys[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		keys[0] = 0;
		parent[0] = -1;

		while (true) {

			int index = minKey(keys, visited);

			if (index == -1) {
				break;
			}

			visited[index] = true;

			for (int i = 0; i < graph.length; i++) {

				if (graph[index][i] != 0 && !visited[i] && keys[i] > graph[index][i]) {
					keys[i] = graph[index][i];
					parent[i] = index;
				}
			}

		}

		return parent;
	}

	public int minKey(int[] keys, boolean[] visited) {
		int min = Integer.MAX_VALUE;

		int index = -1;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] < min && !visited[i]) {
				min = keys[i];
				index = i;
			}
		}
		return index;
	}

	// A utility function to print the constructed MST stored in
	// parent[]
	void printMST(int parent[], int n, int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < parent.length; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

}
// This code is contributed by Aakash Hasija
