
/*
You are walking home from school through the city.  
The city is infinite in size, with vertical streets located at every integer X value and horizontal 
streets located at every Y value.  You are currently located at (0,0) and are trying to get to your home, 
located at (X, Y).  You have two methods of travel available to you:  you can walk along the street to 
proceed to a horizontally or vertically adjacent intersection (which takes walkTime seconds), or you can 
sneak across the block diagonally to the opposite corner (taking sneakTime seconds).  You can walk or sneak 
in any of the eight directions shown in the image (see example 2).



Return the least amount of time that it will take you to return home.  See the examples for clarification.


DEFINITION
Class:StreetWalking
Method:minTime
Parameters:int, int, int, int
Returns:long
Method signature:long minTime(int X, int Y, int walkTime, int sneakTime)


CONSTRAINTS
-X will be between 0 and 1,000,000,000, inclusive.
-Y will be between 0 and 1,000,000,000, inclusive.
-walkTime will be between 1 and 10000, inclusive.
-sneakTime will be between 1 and 10000, inclusive.

// END CUT HERE
*/

import java.util.*;
public class StreetWalking {
    public long minTime(int X, int Y, int walkTime, int sneakTime) {
    	long min = Math.min(X, Y);
    	long max = Math.max(X, Y);
    	long left = max - min;
        
        if(sneakTime >= walkTime*2) {
        	return (long)(X+Y)*walkTime;
        }
        else if(sneakTime < walkTime) {
        	boolean xod = X % 2 != 0;
        	boolean yod = Y % 2 != 0;
        	if(xod != yod) {
        		return ((max-1) * sneakTime) + walkTime;
        	} else {
        		return (max * sneakTime);
        	}
        }
        else{
        	
        	return (min*sneakTime + left*walkTime);
        }
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new StreetWalking()).minTime(4, 2, 3, 10),18L);
            eq(1,(new StreetWalking()).minTime(4, 2, 3, 5),16L);
            eq(2,(new StreetWalking()).minTime(2, 0, 12, 10),20L);
            eq(3,(new StreetWalking()).minTime(25, 18, 7, 11),247L);
            eq(4,(new StreetWalking()).minTime(24, 16, 12, 10),240L);
            eq(5,(new StreetWalking()).minTime(10000000, 50000000, 800, 901),41010000000L);
            eq(6,(new StreetWalking()).minTime(135, 122, 43, 29),3929L);
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
