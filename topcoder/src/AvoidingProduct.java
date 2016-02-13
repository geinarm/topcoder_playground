// BEGIN CUT HERE
// PROBLEM STATEMENT
// 
/*
You are given a set A of integers and a positive integer n. 
You must find positive integers x, y and z such that their product is as close to n as possible 
(minimize |n - x * y * z|), and none of them belongs to A. If there are several such triples, 
find the one with the smallest x. If there are still several such triples, minimize y. 
If there is still a tie, minimize z.


You are given the elements of A as a int[] a. Return a int[] with exactly three elements: x, y and z, 
in this order.


DEFINITION
Class:AvoidingProduct
Method:getTriple
Parameters:int[], int
Returns:int[]
Method signature:int[] getTriple(int[] a, int n)


CONSTRAINTS
-a will contain between 0 and 50 elements, inclusive.
-Each element of a will be between 1 and 1000, inclusive.
-All elements of a will be distinct.
-n will be between 1 and 1000, inclusive.


EXAMPLES

0)
{2,4}
4

Returns: {1, 1, 3 }

You can get 3=1*1*3 and 5=1*1*5. 3 is better.

1)
{1}
10

Returns: {2, 2, 2 }



2)
{1,2}
10

Returns: {3, 3, 3 }



3)
{1,3}
12

Returns: {2, 2, 2 }



4)
{1,3}
13

Returns: {2, 2, 4 }



5)
{1,15}
90

Returns: {2, 5, 9 }


*/
// END CUT HERE
import java.util.*;
public class AvoidingProduct {
    public int[] getTriple(int[] a, int n) {
        int[] res = new int[1];
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new AvoidingProduct()).getTriple(new int[] {2,4}, 4),new int[] {1, 1, 3 });
            eq(1,(new AvoidingProduct()).getTriple(new int[] {1}, 10),new int[] {2, 2, 2 });
            eq(2,(new AvoidingProduct()).getTriple(new int[] {1,2}, 10),new int[] {3, 3, 3 });
            eq(3,(new AvoidingProduct()).getTriple(new int[] {1,3}, 12),new int[] {2, 2, 2 });
            eq(4,(new AvoidingProduct()).getTriple(new int[] {1,3}, 13),new int[] {2, 2, 4 });
            eq(5,(new AvoidingProduct()).getTriple(new int[] {1,15}, 90),new int[] {2, 5, 9 });
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
