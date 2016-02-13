
/*
// BEGIN CUT HERE
// PROBLEM STATEMENT
// Given a positive integer number, concatenate one or more copies of number to create an integer 
 * that is divisible by k.  Do not add any leading zeroes.  Return the least number of copies needed, 
 * or -1 if it is impossible.

DEFINITION
Class:ConcatenateNumber
Method:getSmallest
Parameters:int, int
Returns:int
Method signature:int getSmallest(int number, int k)


CONSTRAINTS
-number will be between 1 and 1,000,000,000, inclusive.
-k will be between 1 and 100,000, inclusive.


EXAMPLES

0)
2
9

Returns: 9

At least 9 copies are needed, since 222222222 is divisible by 9.

1)
121
11

Returns: 1

121 is divisible by 11.

2)
1
2

Returns: -1

You can never get an even number by concatenating only 1's.

3)
35
98765

Returns: 9876

The resulting integer could be really big.

4)
1000000000
3

Returns: 3


*/
// END CUT HERE
import java.util.*;
public class ConcatenateNumber {
    public int getSmallest(int number, int k) {
        int res;
        
        long val = number;
        int i = 1;
        int pow = 0;
        int digits = numDigits(number);
        //System.out.println("Number: " + number);
        while(val%k != 0) {
        	//System.out.println("10^" + pow + " = " + Math.pow(10, pow));
        	pow = i*digits;
        	i++;
        	long add = (long) (number * Math.pow(10, pow));
        	val += add;
        	System.out.println("add: " + add);
        	System.out.println("Val: " + val);
        	if(val > Long.MAX_VALUE) {
        		return -1;
        	}
        }
        
        return pow+1;
    }
    
    public int numDigits(int number) {
    	int digits = 1;
    	while(number > 9) {
    		number = number/10;
    		digits++;
    	}
    	return digits;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            //eq(0,(new ConcatenateNumber()).getSmallest(2, 9),9);
            //eq(1,(new ConcatenateNumber()).getSmallest(121, 11),1);
            //eq(2,(new ConcatenateNumber()).getSmallest(1, 2),-1);
            eq(3,(new ConcatenateNumber()).getSmallest(35, 98765),9876);
            //eq(4,(new ConcatenateNumber()).getSmallest(1000000000, 3),3);
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
