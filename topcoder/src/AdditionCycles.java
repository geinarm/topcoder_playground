/*
// BEGIN CUT HERE
// PROBLEM STATEMENT
// Start with any integer between 00 and 99, inclusive, written as two digits (use a leading zero if the 
 * number is less than 10).  Add the two digits together.  Now concatenate the rightmost digit of the first 
 * number with the rightmost digit of the sum to get a new number.  If you repeat this process enough times, 
 * you'll end up back at the original number.  For example:

			    Combine Second Digits of
Start With    Add Digits    the Original and the Sum
------------------------------------------------------
    26     :   2+6 = 08   :   "6" and "8" = 68 
    68     :   6+8 = 14   :   "8" and "4" = 84
    84     :   8+4 = 12   :   "4" and "2" = 42
    42     :   4+2 = 06   :   "2" and "6" = 26

In this case, it took us 4 steps to get back to where we started, so we would return 4.  
Starting with n, return the number of steps it takes to get back to n.

DEFINITION
Class:AdditionCycles
Method:cycleLength
Parameters:int
Returns:int
Method signature:int cycleLength(int n)


CONSTRAINTS
-n will be between 0 and 99, inclusive.


EXAMPLES

0)
26

Returns: 4

The example from the problem statement.  It goes 26->68->84->42->26, so there's 4 steps for the cycle.

1)
55

Returns: 3

The cycle is 55->50->05->55.  Remember to treat numbers under 10 as though there was a leading zero.

2)
0

Returns: 1

Zero comes back to zero at every step - so the length of the cycle is one (00->00)

3)
71

Returns: 12



// END CUT HERE
*/
import java.util.*;
public class AdditionCycles {
    public int cycleLength(int n) {
        int res = 0;
        num2 number = new num2(n);
        
        do {
        	num2 sum = number.sum();
        	number = new num2(number.d2, sum.d2);
        	res ++;
        } while (number.value() != n);
        
        return res;
    }
    
    private class num2 {
    	public int d1;
    	public int d2;
    	public num2(int val) {
    		if(val < 10) {
    			d1 = 0;
    			d2 = val;
    		} else {
    			d1 = (int)(val / 10);
    			d2 = val % 10;
    		}
    	}
    	public num2(int d1, int d2) {
    		this.d1 = d1;
    		this.d2 = d2;
    	}
    	
    	public int value() {
    		return d1*10 + d2;
    	}
    	
    	public num2 add(num2 n) {
    		int newValue = this.value() + n.value();
    		return new num2(newValue);
    	}
    	
    	public num2 sum() {
    		return new num2( d1 + d2);
    	}
    }

// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0,(new AdditionCycles()).cycleLength(26),4);
            eq(1,(new AdditionCycles()).cycleLength(55),3);
            eq(2,(new AdditionCycles()).cycleLength(0),1);
            eq(3,(new AdditionCycles()).cycleLength(71),12);
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
