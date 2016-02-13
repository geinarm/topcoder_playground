// BEGIN CUT HERE
// PROBLEM STATEMENT
// You might remember the old computer arcade games. Here is one about Manao.
/*

The game level is an NxM grid of equal cells. The bottom of some cells has a platform at which Manao can stand. 
All the cells in the bottommost row contain a platform, thus covering the whole ground of the level. 
The rows of the grid are numbered from 1 to N starting from the top and the columns are numbered from 1 to M 
starting from the left. Exactly one cell contains a coin and Manao needs to obtain it.

Initially, Manao is standing on the ground, i.e., in the bottommost row. He can move between two 
horizontally adjacent cells if both contain a platform. Also, Manao has a ladder which he can use to climb. 
He can use the ladder to climb both up and down. If the ladder is L units long, Manao can climb between two 
cells (i1, j) and (i2, j) if both contain a platform and |i1-i2| <= L. Note that Manao carries the ladder along, 
so he can use it multiple times. You need to determine the minimum ladder length L which is sufficient to 
acquire the coin.

Take a look at the following picture. On this level, Manao will manage to get the coin with a ladder of length 2.



You are given a int[] level containing N elements. 
The j-th character in the i-th row of level is 'X' if cell (i+1, j+1) contains a platform and '.' otherwise. 
You are also given ints coinRow and coinColumn. The coin which Manao seeks is located in cell (coinRow, coinColumn) 
and it is guaranteed that this cell contains a platform.

Return the minimum L such that ladder of length L is enough to get the coin. 
If Manao can perform the task without using the ladder, return 0.

DEFINITION
Class:ArcadeManao
Method:shortestLadder
Parameters:String[], int, int
Returns:int
Method signature:int shortestLadder(String[] level, int coinRow, int coinColumn)


NOTES
-Manao is not allowed to fall. The only way in which he may change his vertical coordinate is by using the ladder.


CONSTRAINTS
-level will contain N elements, where N is between 1 and 50, inclusive.
-Each element of level will be M characters long, where M is between 1 and 50, inclusive.
-Each element of level will consist of '.' and 'X' characters only.
-The last element of level will be entirely filled with 'X'.
-coinRow will be between 1 and N, inclusive.
-coinColumn will be between 1 and M, inclusive.
-level[coinRow - 1][coinColumn - 1] will be 'X'.


EXAMPLES

0)
{"XXXX....",
 "...X.XXX",
 "XXX..X..",
 "......X.",
 "XXXXXXXX"}
2
4

Returns: 2

The example from the problem statement.

1)
{"XXXX",
 "...X",
 "XXXX"}
1
1

Returns: 1

Manao can use the ladder to climb from the ground to cell (2, 4), then to cell (1, 4) and then he can walk right to the coin.

2)
{"..X..",
 ".X.X.",
 "X...X",
 ".X.X.",
 "..X..",
 "XXXXX"}
1
3

Returns: 4

With a ladder of length 4, Manao can first climb to cell (5, 3) and then right to (1, 3).

3)
{"X"}
1
1

Returns: 0

Manao begins in the same cell as the coin.

4)
{"XXXXXXXXXX",
 "...X......",
 "XXX.......",
 "X.....XXXX",
 "..XXXXX..X",
 ".........X",
 ".........X",
 "XXXXXXXXXX"}
1
1

Returns: 2



*/
// END CUT HERE
import java.util.*;

public class ArcadeManao {
	
	PriorityQueue<Node> frontier = new PriorityQueue<Node>();
	
    public int shortestLadder(String[] level, int coinRow, int coinColumn) {

        State start = new State(coinRow, coinColumn);
        Node endNode = search(level, start);
        
        if(endNode == null) {
        	return -1;
        }
        endNode.printPath();
        //return endNode.maxCost(0);
        
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return endNode.maxCost();
    }
    
    private Node search(String[] level, State start) {
    	
    	Node first = new Node(0, ".", start, null);
    	frontier.add(first);
    	while(!frontier.isEmpty()) {
    		//System.out.println("Frontier: " + frontier.size());
    		Node node = frontier.poll();
    		
    		System.out.println("Action: " + node.action + " - " + node.cost + " - " + node.maxCost() + " - (" + node.state.row + "," + node.state.col + ")");
    		
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		if(isFinalState(node, level)) {
    			return node;
    		}
    		
    		List<Node> childNodes = expandNode(node, level);
    		for(Node n : childNodes) {
    			//if(!frontier.contains(n)) {
    				if(!node.isStateInPath(n.state)) {
    					frontier.add(n);
    				}
    			//}
    		}
    	}
    	
    	return null;
    }
    
    private boolean isFinalState(Node n, String[] level) {
    	return n.state.row == level.length;
    }
    
    private char getTile(String[] level, int row, int col) {
    	if(row > 0 && row <= level.length) {
    		String r = level[row-1];
    		
    		if(col > 0 && col <= r.length()) {
    			return r.charAt(col-1);
    		}
    	}
    	
    	return '\0';
    }
    
    private List<Node> expandNode(Node n, String[] level) {
    	//System.out.println("Expand");
    	List<Node> childNodes = new ArrayList<Node>();
    	
    	//Search down
    	int downCount = 1;
    	int row = n.state.row+1;
    	char tileDown = getTile(level, row, n.state.col);
    	while (tileDown != 'X' && tileDown != '\0') {
    		downCount ++;
    		row ++;
    		tileDown = getTile(level, row, n.state.col);
    	}
    	
    	if(tileDown == 'X') {
    		childNodes.add(new Node(downCount, "D("+downCount+")", new State(row, n.state.col), n));
    	}
    	
    	//Search up
    	int upCount = 1;
    	row = n.state.row-1;
    	char tileUp = getTile(level, row, n.state.col);
    	while (tileUp != 'X' && tileUp != '\0') {
    		upCount ++;
    		row ++;
    		tileUp = getTile(level, row, n.state.col);
    	}
    	
    	if(tileUp == 'X') {
    		childNodes.add(new Node(upCount, "U("+upCount+")", new State(row, n.state.col), n));
    	}

    	//Look right
    	char tileRight = getTile(level, n.state.row, n.state.col+1);
    	if(tileRight == 'X') {
    		childNodes.add(new Node(0, "R", new State(n.state.row, n.state.col+1), n));
    	}
    	
    	//Look left
    	char tileLeft = getTile(level, n.state.row, n.state.col-1);
	    if(tileLeft == 'X') {
	    	childNodes.add(new Node(0, "L", new State(n.state.row, n.state.col-1), n));
	    }
    	
    	return childNodes;
    }
    
    private class Node implements Comparable<Node>{
    	public int cost;
    	public String action;
    	public State state;
    	public Node parentNode;
    	
    	public Node(int c, String a, State s, Node p) {
    		this.cost = c;
    		this.action = a;
    		this.state = s;
    		this.parentNode = p;
    	}
    	
    	public int maxCost() {
    		if(this.parentNode == null) {
    			return 0;
    		}
    		return Math.max(this.parentNode.maxCost(), this.cost);
    	}
    	
    	public void printPath() {
    		if(parentNode == null) {
    			System.out.print("X\n");
    		} else {
    			System.out.print(this.action + " - ");
    			parentNode.printPath();
    		}
    	}
    	
    	public boolean isStateInPath(State s) {
    		if(this.state.equals(s)) {
    			return true;
    		}
    		if(this.parentNode == null) {
    			return false;
    		}
    		return parentNode.isStateInPath(s);
    	}
    	
        @Override
        public boolean equals(Object obj) {
           if (!(obj instanceof Node))
                return false;
            if (obj == this)
                return true;

            Node n = (Node) obj;
            return n.state.equals(this.state);
        }

		@Override
		public int compareTo(Node n) {
			return this.maxCost() - n.maxCost();
		}
    }
    
    private class State {
    	public int row;
    	public int col;
    	
    	public State(int r, int c) {
    		this.row = r;
    		this.col = c;
    	}

        @Override
        public boolean equals(Object obj) {
           if (!(obj instanceof State))
                return false;
            if (obj == this)
                return true;

            State s = (State) obj;
            return s.col == this.col && s.row == this.row;
        }
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ArcadeManao()).shortestLadder(new String[] {
            	"XXXX....",
                "...X.XXX",
                "XXX..X..",
                "......X.",
                "XXXXXXXX"}, 2, 4),2);
            eq(1,(new ArcadeManao()).shortestLadder(new String[] {
            	"XXXX",
                "...X",
                "XXXX"}, 1, 1),1);
            eq(2,(new ArcadeManao()).shortestLadder(new String[] {
            	"..X..",
                ".X.X.",
                "X...X",
                ".X.X.",
                "..X..",
                "XXXXX"}, 1, 3),4);
            eq(3,(new ArcadeManao()).shortestLadder(new String[] {"X"}, 1, 1),0);
            eq(4,(new ArcadeManao()).shortestLadder(new String[] {
            	"XXXXXXXXXX",
                "...X......",
                "XXX.......",
                "X.....XXXX",
                "..XXXXX..X",
                ".........X",
                ".........X",
                "XXXXXXXXXX"}, 1, 1),2);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, double a, double b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
