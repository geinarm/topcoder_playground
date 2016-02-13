/*
// BEGIN CUT HERE
// PROBLEM STATEMENT
// We have some baskets containing apples, and we would like to perform the following 
 * procedure in a way that maximizes the number of remaining apples.  
 * First, we discard some (or none) of the baskets completely.  
 * Then, if the remaining baskets do not all contain the same number of apples, 
 * we remove excess apples from the baskets until they do.
You will be given a int[] apples where the i-th element of apples is the number 
of apples in the i-th basket. Return the number of apples 
remaining after the procedure described above is performed.


DEFINITION
Class:BasketsWithApples
Method:removeExcess
Parameters:int[]
Returns:int
Method signature:int removeExcess(int[] apples)


CONSTRAINTS
-apples will contain between 1 and 50 elements, inclusive.
-Each element in apples will be between 0 and 1000, inclusive.


EXAMPLES

0)
{1, 2, 3}

Returns: 4

We should remove the first basket and leave two apples in each of the two remaining baskets.

1)
{5, 0, 30, 14}

Returns: 30

We should leave only the third basket.

2)
{51, 8, 38, 49}

Returns: 114

3)
{24, 92, 38, 0, 79, 45}

Returns: 158

// END CUT HERE
*/
import java.util.*;
public class BasketsWithApples {
    public int removeExcess(int[] apples) {
        int res = 0;
        //int baskets = apples.length;
        int cuttof = 0;
        int maxBaskets = 0;
        int maxApples = 0;
        for(int i =0; i < apples.length; i++) {
        	int sum = 0;
        	int baskets = 0;
        	for(int k=0; k < apples.length; k++) {
        		if(apples[k] >= apples[i]) {
        			sum += apples[i];
        			baskets ++;
        		}
        	}
        	
        	if(sum > maxApples) {
        		maxApples = sum;
        		maxBaskets = baskets;
        		cuttof = apples[i];
        	}
        }
        
        
        return maxBaskets * cuttof;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BasketsWithApples()).removeExcess(new int[] {1, 2, 3}),4);
            eq(1,(new BasketsWithApples()).removeExcess(new int[] {5, 0, 30, 14}),30);
            eq(2,(new BasketsWithApples()).removeExcess(new int[] {51, 8, 38, 49}),114);
            eq(3,(new BasketsWithApples()).removeExcess(new int[] {24, 92, 38, 0, 79, 45}),158);
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
