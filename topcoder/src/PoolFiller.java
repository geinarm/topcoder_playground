/*
// BEGIN CUT HERE
// PROBLEM STATEMENT
// You have built an above-ground pool and you want to know how much water it will hold.  
 * The pool structure is built out of stacks of cubes aligned on a grid.  layout gives an overhead 
 * view showing the height of the cubes in each position of the grid.  Here is an example pool:


    16661
    61116
    16661


This pool can hold a total of 15 units of water: 5 units on each of the 3 middle grid locations.  
After that, any water added to the middle would flow out over the walls (the grid locations of height 6), 
and any water added to the walls or corners would flow out onto the surrounding ground.  
When it can, water will always flow to areas of lower height, and no water will "stand" on surfaces such 
as the pool walls shown here.  Water cannot flow through diagonals, so it won't leak out of the middle 
via the corners.  The ground surrounding the pool is at height 0 and can absorb an infinite amount of water.  
Return the total number of water units that can be held by the pool.

DEFINITION
Class:PoolFiller
Method:getCapacity
Parameters:String[]
Returns:int
Method signature:int getCapacity(String[] layout)


CONSTRAINTS
-layout will contain between 1 and 50 elements, inclusive.
-Each element of layout will contain between 1 and 50 characters, inclusive.
-Each element of layout will be the same length.
-Each character in each element of layout will be a digit between '1' and '9', inclusive.


EXAMPLES

0)
{
"16661",
"61116",
"16661"
}

Returns: 15

The example from the problem statement.

1)
{
"999999",
"955119",
"955119",
"999999"
}

Returns: 48

This pool has high walls, with a shallow end on the left and a deeper end on the right.  
The shallow end has a capacity of 4*4=16, and the deep end has a capacity of 8*4=32.

2)
{
"111111111",
"115111611",
"131516161",
"115111611",
"111111111"
}

Returns: 7

In this case, we have two separate mini-pools.  The one on the right holds 5 units, 
and the one on the left holds 2 (any more than 2 would leak out of the left side).  

3)
{
"1111111111111",
"1555555555551",
"1511111111151",
"1511199911151",
"1511192911151",
"1511199911151",
"1511111111151",
"1555555555551",
"1111111111111"
}



Returns: 151

Now we have a small, tall pool in the middle of a larger pool.  The main pool holds 36*4=144 units.  
The pool in the middle holds 9-2=7 units.

// END CUT HERE
 */
import java.util.*;
public class PoolFiller {
    public int getCapacity(String[] layout) {
        int res = 0;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PoolFiller()).getCapacity(new String[] {
               "16661",
               "61116",
               "16661"
               }),15);
            eq(1,(new PoolFiller()).getCapacity(new String[] {
               "999999",
               "955119",
               "955119",
               "999999"
               }),48);
            eq(2,(new PoolFiller()).getCapacity(new String[] {
               "111111111",
               "115111611",
               "131516161",
               "115111611",
               "111111111"
               }),7);
            eq(3,(new PoolFiller()).getCapacity(new String[] {
               "1111111111111",
               "1555555555551",
               "1511111111151",
               "1511199911151",
               "1511192911151",
               "1511199911151",
               "1511111111151",
               "1555555555551",
               "1111111111111"
               }
               
               ),151);
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
