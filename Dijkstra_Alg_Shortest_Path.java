public class Assign4{

	public static void main(String[] args) {	
		D_alg.printGraph();
		D_alg.shortestPath('A');
	}
}

public class D_alg {
private static final int max = Integer.MAX_VALUE;  

	private static int[][] cost_matrix = {
		{ 0, 2, 5, 1, max, max}, // A
		{ 2, 0, 3, 2, max, max}, // B
		{ 5, 3, 0, 3, 1, 5}, // C
		{ 1, 2, 3, 0, 1, max}, // D
		{max, max, 1, 1, 0, 2}, // E
		{max, max, 5, max, 2, 0} // F
	};

	public static void printGraph() {
		int i = 0;
		System.out.println("X|| A B C D E F");
		System.out.println("===============");
		for(int[] distVector : cost_matrix ) {
		System.out.print((char)(65+i)+"|| ");

		for(int dist : distVector) {
			if(dist == max){
			System.out.print("- ");
			} else {
			System.out.print(dist+" "); }		
			}
		System.out.println();
		i++;
		}
	}

	public static void shortestPath(char startNode) {
	
	int nodes = cost_matrix.length; 
	boolean[] set = new boolean[nodes];
	int start = startNode-'A'; 
	int[] dist;
	
	dist = Arrays.copyOf(cost_matrix[start], nodes);
	Arrays.fill(set, false);

	dist[start] = 0;
	set[start] = true;

		for(int count = 0; count < nodes-1;count++) {
			int minNodes = -1; 
			int minDist = max; 

			for(int n = 0; n < nodes; n++) {
				if(set[n] == false && D[n] <= minDist) {
				minNodes = n;
				minDist = dist[n];
				}
			}

		set[minNodes] = true;

			for(int j = 0; j < N; j++) {
				if(minNodes != j && j != start && set[j] == false) { 
				dist[j] = Math.min(dist[j], dist[minNodes]+cost_matrix[minNodes][j]);
				}
			}
		}

		System.out.println("\nShortest paths from "+startNode+" to the other vertices are: ");

		for(int i = 0; i < dist.length; i++) {
			if(start != i){
			System.out.println(startNode+" to "+(char)(i+65)+" is "+dist[i]+" units"); 
			}
		}
	}
}
