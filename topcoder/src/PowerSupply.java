// BEGIN CUT HERE
// PROBLEM STATEMENT
import java.lang.reflect.Array;
// 
/*
You have discovered a region in need of power, and as an enterprising business person, 
you have decided to build a power line there.  The region is a cartesian plane, and consumers 
are represented as points on the plane. Your power line will be a single straight line that is 
horizontal, vertical, or parallel to any of two diagonals. Each potential consumer will purchase 
power from your line if and only if the distance between him and your line is less than or equal to D.  
This distance is measured as the Euclidean distance (the length of the shortest line segment between 
the point and the line).  You would like to maximize your profit by maximizing the number of consumers 
using your power line.


You are given int[]s x and y containing the coordinates of the consumers.  The ith elements of x and y 
represent the x and y coordinates of the ith consumer.  Your are also given an int D, the value described above.  
Build your power line to maximize the number of consumers that will use it, and return this maximum number.



DEFINITION
Class:PowerSupply
Method:maxProfit
Parameters:int[], int[], int
Returns:int
Method signature:int maxProfit(int[] x, int[] y, int D)


NOTES
-More than one consumer may be located at the same point.
-The power line may cross consumer points, in which case those consumers are at a distance of zero from the power line (see example 1).


CONSTRAINTS
-x and y will contain between 0 and 50 elements, inclusive.
-x and y will contain the same number of elements.
-Each element of x and y will be between -1000000 and 1000000, inclusive.
-D will be between 0 and 1000000, inclusive.


EXAMPLES

0)
{0,3,0,0,0}
{1,2,6,-4,1}
1

Returns: 4

1)
{-1000000,13,1000000}
{0,0,0}
0

Returns: 3

All points are crossed by the line, so all three consumers can connect to the power line even with D equal to 0.

2)
{-5,-2,2,8,-1}
{1,2,1,2,8}
1

Returns: 4

3)
{-5,-5,-2,-2,3}
{-2,-3,4,6,9}
2

Returns: 4

4)
{511590, -60297, 337900, -322958, -806739, 358447, 685932, 663609, 276080, -213586}
{-500859, -840607, -792296, -379621, -890856, 362559, -98535, 617148, -128203, 802475}
31194

Returns: 4
*/
// END CUT HERE
import java.util.*;
public class PowerSupply {
    public int maxProfit(int[] x, int[] y, int D) {
        int horizontal = maxHorizontal(x, y, D);
        int vertical = maxVertical(x, y, D);
        int diagonal1 = 0;
        int diagonal2 = 0;
        
        return Math.max(horizontal, Math.max(vertical, Math.max(diagonal1, diagonal2)));
    }
    
    private int maxHorizontal(int[] x, int[] y, int D) {
    	int[] sortedY = Arrays.copyOf(y, y.length);
    	Arrays.sort(sortedY);
    	
    	int range = range(sortedY);
    	while(range > D) {
    		int bottom = range(Arrays.copyOfRange(sortedY, 0, sortedY.length-1));
    		int top = range(Arrays.copyOfRange(sortedY, 1, sortedY.length));
    		if(bottom > top) {
    			sortedY = Arrays.copyOfRange(sortedY, 1, sortedY.length);
    			range = top;
    		} else {
    			sortedY = Arrays.copyOfRange(sortedY, 0, sortedY.length-1);
    			range = bottom;
    		}
    	}
    	
    	return sortedY.length;
    }
    private int maxVertical(int[] x, int[] y, int D) {
    	int[] sortedX = Arrays.copyOf(x, x.length);
    	Arrays.sort(sortedX);
    	
    	int range = range(sortedX);
    	while(range > D) {
    		
    		int bottom = range(Arrays.copyOfRange(sortedX, 0, sortedX.length-1));
    		int top = range(Arrays.copyOfRange(sortedX, 1, sortedX.length));
    		if(bottom > top) {
    			sortedX = Arrays.copyOfRange(sortedX, 1, sortedX.length);
    			range = top;
    		} else {
    			sortedX = Arrays.copyOfRange(sortedX, 0, sortedX.length-1);
    			range = bottom;
    		}
    	}
    	
    	return sortedX.length;
    }
    private int range(int[] ordered) {
    	if(ordered.length == 0) {
    		return 0;
    	}
    	int max = ordered[ordered.length-1];
    	int min = ordered[0];
    	
    	return max - min;
    }
    private int rangeDiagonal(int[] x, int[] y) {
    	return 0;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PowerSupply()).maxProfit(new int[] {0,3,0,0,0}, new int[] {1,2,6,-4,1}, 1),4);
            eq(1,(new PowerSupply()).maxProfit(new int[] {-1000000,13,1000000}, new int[] {0,0,0}, 0),3);
            eq(2,(new PowerSupply()).maxProfit(new int[] {-5,-2,2,8,-1}, new int[] {1,2,1,2,8}, 1),4);
            eq(3,(new PowerSupply()).maxProfit(new int[] {-5,-5,-2,-2,3}, new int[] {-2,-3,4,6,9}, 2),4);
            eq(4,(new PowerSupply()).maxProfit(new int[] {511590, -60297, 337900, -322958, -806739, 358447, 685932, 663609, 276080, -213586}, new int[] {-500859, -840607, -792296, -379621, -890856, 362559, -98535, 617148, -128203, 802475}, 31194),4);
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
