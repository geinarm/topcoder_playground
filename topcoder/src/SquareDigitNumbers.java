
/* 
 * You enjoy working with numbers that contain only square digits (namely, 0, 1, 4 and 9).  
 * The sequence containing only these digits is 0, 1, 4, 9, 10, 11, 14...   
 * Return the n-th term (indexed from 0) in this sequence.

DEFINITION
Class:SquareDigitNumbers
Method:getNumber
Parameters:int
Returns:int
Method signature:int getNumber(int n)


CONSTRAINTS
-n will be between 0 and 1000, inclusive.


EXAMPLES

0)
0

Returns: 0

The first square digit number is 0.

1)
5

Returns: 11



2)
16

Returns: 100



3)
121

Returns: 1941



4)
123

Returns: 1949



// END CUT HERE
 */
import java.util.*;
public class SquareDigitNumbers {
	private static List<Character> digits;
	static {
		digits = new ArrayList<Character>();
		digits.add('0');
		digits.add('1');
		digits.add('4');
		digits.add('9');
	}
	
    public int getNumber(int n) {
        
        int i = 0;
        int testD = 0;
        while(i != n) {
        	testD ++;
        	if(onlySquare(testD)) {
        		i ++;
        	}
        }
        
        return testD;
    }
    
    private boolean onlySquare(int d) {
    	String str = Integer.toString(d);
    	
    	for(int i=0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		if(!digits.contains(c)) {
    			return false;
    		}
    	}
    	return true;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SquareDigitNumbers()).getNumber(0),0);
            eq(1,(new SquareDigitNumbers()).getNumber(5),11);
            eq(2,(new SquareDigitNumbers()).getNumber(16),100);
            eq(3,(new SquareDigitNumbers()).getNumber(121),1941);
            eq(4,(new SquareDigitNumbers()).getNumber(123),1949);
            eq(5,(new SquareDigitNumbers()).getNumber(1),1);
            eq(6,(new SquareDigitNumbers()).getNumber(2),4);
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
