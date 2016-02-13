// BEGIN CUT HERE
// PROBLEM STATEMENT
/*
You have a rectangular chocolate bar that consists of width x height square tiles. 
You can split it into two rectangular pieces by creating a single vertical or horizontal 
break along tile edges.  For example, a 2 x 2 chocolate bar can be divided into two 2 x 1 pieces,
 but it cannot be divided into two pieces, where one of them is 1 x 1.  You can repeat the split 
 operation as many times as you want, each time splitting a single rectangular piece into two rectangular 
 pieces.  Your goal is to create a piece consisting of exactly nTiles tiles.  Return the minimal number 
 of split operations necessary to reach this goal.  If it is impossible, return -1.


DEFINITION
Class:Chocolate
Method:minSplitNumber
Parameters:int, int, int
Returns:int
Method signature:int minSplitNumber(int width, int height, int nTiles)


CONSTRAINTS
-width will be between 1 and 10^9, inclusive.
-height will be between 1 and 10^9, inclusive.
-nTiles will be between 1 and 10^9, inclusive.


EXAMPLES

0)
5
4
12

Returns: 1

You can split the chocolate bar into two rectangular pieces 3 x 4 and 2 x 4 by creating a single vertical break. Only one break is necessary.

1)
12
10
120

Returns: 0

The chocolate bar consists of exactly 120 tiles.

2)
2
2
1

Returns: 2



3)
17
19
111

Returns: -1


*/
// END CUT HERE
import java.util.*;
public class Chocolate {
    public int minSplitNumber(int width, int height, int nTiles) {
        
        if(nTiles > width*height) {
        	return -1;
        }
        if(nTiles == width*height) {
        	return 0;
        }
        if(nTiles % 2 != 0) {
        	if(nTiles > width && nTiles > height) {
        		return -1;
        	}
        }
        if(nTiles % width == 0 && nTiles / width < height) {
        	return 1;
        }
        if(nTiles % height == 0 && nTiles / height < width) {
        	return 1;
        }
        
        return 2;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new Chocolate()).minSplitNumber(5, 4, 12),1);
            eq(1,(new Chocolate()).minSplitNumber(12, 10, 120),0);
            eq(2,(new Chocolate()).minSplitNumber(2, 2, 1),2);
            eq(3,(new Chocolate()).minSplitNumber(17, 19, 111),-1);
            
            eq(4,(new Chocolate()).minSplitNumber(5, 5, 4),2);
            eq(5,(new Chocolate()).minSplitNumber(5, 4, 8),1);
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
