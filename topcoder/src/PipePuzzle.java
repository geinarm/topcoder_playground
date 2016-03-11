// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// The pipe game is played on a grid with three kinds of pipes. The straight pipe '-' allows water to flow 
 * straight. The elbow pipe 'L' diverts water either to the left or to the right. The cross pipe '+' has the 
 * same effect as a straight pipe. Unlike the other two pipes, the cross pipe allows water to flow through it 
 * a second time in a direction perpendicular to the first pass. The water source is represented by one 
 * of: 'N', 'S', 'W' or 'E' indicating whether the water will begin flowing north, south, west or east 
 * respectively. You are allowed to rotate each pipe in the grid by 90 degree increments with the objective 
 * of maximizing the number of pipes connected to the water source.


Given a String[] pipes that represents the game grid, determine the length of the longest possible flow 
of water. Each pipe that the water flows through adds one to the total length. A cross pipe through which 
water passes twice contributes two to the overall length. The starting water source is not a pipe, does 
not count towards the length, and may not be rotated.




{"LL-L-",
 "L+L+L",
 "--NL-",
 "L+--L",
 "LL+L-"}





This is a graphical representation of the puzzle above.



DEFINITION
Class:PipePuzzle
Method:longest
Parameters:String[]
Returns:int
Method signature:int longest(String[] pipes)


NOTES
-In each grid, south is the direction of increasing index within pipes, 
and north that of decreasing index. East is the direction of increasing index within an 
element of pipes, and west that of decreasing index.


CONSTRAINTS
-pipes will have between 1 and 20 elements, inclusive.
-Each element of pipes will have length between 1 and 20, inclusive.
-Every element of pipes will have the same length.
-pipes will only contain the characters ('-', 'L', '+', 'N', 'S', 'E', 'W').
-pipes will have exactly one water source.
-pipes will contain between 0 and 20 elbow 'L' pipes, inclusive.


EXAMPLES

0)
{"LL-L-",
 "L+L+L",
 "--NL-",
 "L+--L",
 "LL+L-"}

Returns: 19




1)
{"ELLL",
 "LLLL",
 "LLLL",
 "LLLL"}


Returns: 13




2)
{"ELLLLL+",
 "++++++L",
 "L+++++L",
 "L+++++L",
 "L+++++L",
 "L+++++L",
 "+LLLLLL"}

Returns: 71

3)
{"-+-+-+-+-+-+-+-+-+-W"}

Returns: 19

4)
{"N"}

Returns: 0

*/
// END CUT HERE
import java.util.*;
public class PipePuzzle {
    public int longest(String[] pipes) {
        int res = 0;
        
        Stack<Node> frontier = new Stack<Node>();
        Node first = findFirst(pipes);
        
        if(first != null) {
        	System.out.println("First " + first.pipe + " " + first.dirIn);
        }
        
        frontier.push(first);
        
        while(!frontier.isEmpty()) {
        	Node n = frontier.pop(); //DFS
        	
        	System.out.println(frontier.size() + " - (" + n.row + "," + n.col + ")");
        	
        	int length = n.pathLength(); 
        	if(length > res) {
        		res = length;
        	}
        	
        	List<Node> children = expandNode(n, pipes);
        	for(Node c : children) {
        		if(!n.inPath(c)) {
        			frontier.push(c);
        		}
        	}
        }
        
        return res;
    }

    private Node findFirst(String[] level) {
    	for(int row = 0; row < level.length; row++) {
        	for(int col = 0; col < level.length; col++) {
        		char c = getPipeAt(row, col, level);
        		if(c=='N') {
        			char p = getPipeAt(row-1, col, level);
        			if(p != 'X') {
        				return new Node(null, p, 'N', row, col);
        			}
        		}
        		if(c=='S') {
        			char p = getPipeAt(row+1, col, level);
        			if(p != 'X') {
        				return new Node(null, p, 'S', row, col);
        			}
        		}        		
        	}    		
    	}
    	
    	return null;
    }
    
    private char getPipeAt(int row, int col, String[] level) {
    	if(row >= level.length) {
    		return 'X';
    	} else if(row < 0) {
    		return 'X';
    	}
    	
    	if(col >= level[0].length()) {
    		return 'X';
    	} else if (col < 0) {
    		return 'X';
    	}
    	
    	char c = level[row].charAt(col);
    	if(c=='N'||c=='S'||c=='E'||c=='W') {
    		return 'X';
    	}
    	return c;
    }
    
    private List<Node> expandNode(Node n, String[] level) {
    	List<Node> nodes = new ArrayList<Node>();
    	
    	if(n.pipe == 'L' && (n.dirIn == 'N' || n.dirIn == 'S')) {
    		char east = getPipeAt(n.row, n.col+1, level);
    		if(east != 'X') {
    			nodes.add(new Node(n, east, 'E', n.row, n.col+1));
    		}
    		char west = getPipeAt(n.row, n.col-1, level);
    		if(west != 'X') {
    			nodes.add(new Node(n, west, 'W', n.row, n.col-1));
    		}    		
    	} else if(n.pipe == 'L' && (n.dirIn == 'E' || n.dirIn == 'W')) {
    		char north = getPipeAt(n.row-1, n.col, level);
    		if(north != 'X') {
    			nodes.add(new Node(n, north, 'N', n.row-1, n.col));
    		}
    		char south = getPipeAt(n.row, n.col-1, level);
    		if(south != 'X') {
    			nodes.add(new Node(n, south, 'S', n.row+1, n.col));
    		}    		
    	}    	
    	if(n.pipe == '-' || n.pipe == '+') {
    		if(n.dirIn == 'N') {
    			char north = getPipeAt(n.row-1, n.col, level);
    			if(north != 'X') {
    				nodes.add(new Node(n, north, 'N', n.row-1, n.col));
    			}
    		} else if(n.dirIn == 'S') {
    			char south = getPipeAt(n.row+1, n.col, level);
    			if(south != 'X') {
    				nodes.add(new Node(n, south, 'S', n.row+1, n.col));
    			}
    		}else if(n.dirIn == 'E') {
    			char east = getPipeAt(n.row, n.col+1, level);
    			if(east != 'X') {
    				nodes.add(new Node(n, east, 'E', n.row, n.col+1));
    			}
    		}else if(n.dirIn == 'W') {
    			char west = getPipeAt(n.row, n.col-1, level);
    			if(west != 'X') {
    				nodes.add(new Node(n, west, 'W', n.row, n.col-1));
    			}
    		}    		
    	}
    	
    	return nodes;
    }
    
    private class Node {
    	Node parent;
    	char pipe, dirIn;
    	int row, col;
    	
    	public Node(Node p, char pipe, char in, int row, int col) {
    		this.parent = p;
    		this.pipe = pipe;
    		this.dirIn = in;
    		this.row = row;
    		this.col = col;
    	}
    	
    	public int pathLength() {
    		if(parent == null) {
    			return 0;
    		}
    		return 1 + parent.pathLength();
    	}
    	
    	public boolean inPath(Node n) {
    		if(parent == null) {
    			return this.equals(n);
    		}
    		return this.equals(n) || parent.inPath(n);
    	}
    	
    	@Override
    	public boolean equals(Object other) {
    		if(!(other instanceof Node)) {
    			return false;
    		}
    		Node n = (Node)other;
    		if(this.row == n.row && this.col == n.col) {
    			if(n.pipe == '+' && n.dirIn != this.dirIn) {
    				return false;
    			}
    			return true;
    		}
    		
    		return false;
    	}
    }
    
// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PipePuzzle()).longest(new String[] {"LL-L-",
                "L+L+L",
                "--NL-",
                "L+--L",
                "LL+L-"}),19);
            eq(1,(new PipePuzzle()).longest(new String[] {"ELLL",
                "LLLL",
                "LLLL",
                "LLLL"}
               ),13);
            eq(2,(new PipePuzzle()).longest(new String[] {
            	"ELLLLL+",
                "++++++L",
                "L+++++L",
                "L+++++L",
                "L+++++L",
                "L+++++L",
                "+LLLLLL"}),71);
            eq(3,(new PipePuzzle()).longest(new String[] {"-+-+-+-+-+-+-+-+-+-W"}),19);
            eq(4,(new PipePuzzle()).longest(new String[] {"N"}),0);
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
