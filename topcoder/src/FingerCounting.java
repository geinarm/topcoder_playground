// BEGIN CUT HERE
import java.math.BigInteger;
// PROBLEM STATEMENT
// Your little son is counting numbers with his left hand.  
/*
Starting with his thumb and going toward his pinky, he counts each finger in order.  
After counting his pinky, he reverses direction and goes back toward his thumb.  
He repeats this process until he reaches his target number.  He never skips a finger.  
For example, to count to ten, he would count: thumb, index, middle, ring, pinky, ring, middle, index, thumb, index.

Sadly, one of his fingers hurts and he can only count on it a limited number of times.  
His fingers are numbered 1 through 5 from thumb to pinky.  You are given an int weakFinger, 
the finger that hurts, and an int maxCount, the maximum number of times he can use that finger.  
Return the largest number he can count to.  If he cannot even begin counting, return 0.

DEFINITION
Class:FingerCounting
Method:maxNumber
Parameters:int, int
Returns:int
Method signature:int maxNumber(int weakFinger, int maxCount)


CONSTRAINTS
-weakFinger will be between 1 and 5, inclusive.
-maxCount will be between 0 and 100000, inclusive.


EXAMPLES

0)
2
3

Returns: 15

The first 15 numbers are counted with fingers 1,2,3,4,5,4,3,2,1,2,3,4,5,4,3. He would then have to use finger 2 for the next number, but since he has already used it 3 times, he has to stop.

1)
1
0

Returns: 0

He needs to use his thumb when counting the first number, 1, but it's too weak to be used even once.

2)
5
0

Returns: 4

Even though his pinky cannot be used at all, he can count 1,2,3,4 with the other fingers.

3)
2
48

Returns: 193



4)
5
973

Returns: 7788



5)
3
99999

Returns: 399998


*/
// END CUT HERE
import java.util.*;
public class FingerCounting {
    public int maxNumber(int weakFinger, int maxCount) {

        int count = 0;
        int i = maxCount;   
        int index = 0;
        int dir = 1;
        while(true) {
        	index += dir;
        	count ++;
        	
        	if(index == 5) {
        		dir = -1;
        	}
        	if(index == 1) {
        		dir = 1;
        	}
        	if(index == weakFinger) {
        		if(i == 0) {
        			count --;
        			break;
        		}
        		i --;
        	}
        }
        
        return count;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FingerCounting()).maxNumber(2, 3),15);
            eq(1,(new FingerCounting()).maxNumber(1, 0),0);
            eq(2,(new FingerCounting()).maxNumber(5, 0),4);
            eq(3,(new FingerCounting()).maxNumber(2, 48),193);
            eq(4,(new FingerCounting()).maxNumber(5, 973),7788);
            eq(5,(new FingerCounting()).maxNumber(3, 99999),399998);
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
