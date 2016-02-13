// BEGIN CUT HERE
// PROBLEM STATEMENT
/*
// Massive numbers can be represented using the exponent notation. For example, 3^100 is 3 raised to the power of 100.
3 is the base and 100 is the exponent.

Suppose we want to compare two massive numbers. Instead of computing the exact value of each number we 
can rely on a useful mathematical trick. Suppose m = a^b and n = c^d are two massive numbers. 
Let R be a relationship operator: less, equal or greater. Then we have the following:

If b*Log(a) R d*Log(c) then it is also the case that m R n,
where a, b, c, d, m and n are defined above.

So which is greater: 3^100 or 2^150? Let's do the math. 100*Log(3) = 47.7..., 150*Log(2) = 45.2.... 
Since 47.7 > 45.2, our rule tells us that 3^100 > 2^150.

Given two numbers numberA and numberB return the larger number formatted exactly the same as the input.
 numberA and numberB will be formatted as <base>^<exponent>. Constraints will ensure that numberA and numberB 
 are not equal.

DEFINITION
Class:MassiveNumbers
Method:getLargest
Parameters:String, String
Returns:String
Method signature:String getLargest(String numberA, String numberB)


NOTES
-In Java, the log of a number can be found with Math.log().
-In C++, the log of a number can be found with log().
-In C# and VB, the log of a number can be found with Math.Log().


CONSTRAINTS
-numberA and numberB will contain between 3 and 9 characters inclusive.
-numberA and numberB will be formatted as <base>^<exponent>, where <base> and <exponent> are integers between 1 and 1000 inclusive. <base> and <exponent> cannot have leading zeroes.
-The relative difference between b*Log(a) and d*Log(c) (where a, b, c and d are defined in the problem statement) will be at least 1e-6.


EXAMPLES

0)
"3^100"
"2^150"

Returns: "3^100"

Above example.

1)
"1^1000"
"2^1"

Returns: "2^1"

numberA is equal to 1, while numberB is equal to 2.

2)
"893^605"
"396^906"

Returns: "396^906"

3)
"999^1000"
"1000^999"

Returns: "999^1000"

*/
// END CUT HERE
import java.util.*;
public class MassiveNumbers {
    public String getLargest(String numberA, String numberB) {
        String[] aComp = numberA.split("\\^");
        String[] bComp = numberB.split("\\^");
        
        int aBase = Integer.parseInt(aComp[0]);
        int aExp = Integer.parseInt(aComp[1]);
        int bBase = Integer.parseInt(bComp[0]);
        int bExp = Integer.parseInt(bComp[1]);
        
        double aVal = aExp * Math.log(aBase);
        double bVal = bExp * Math.log(bBase);
        
        if(aVal > bVal) {
        	return numberA;
        } else {
        	return numberB;
        }
        
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new MassiveNumbers()).getLargest("3^100", "2^150"),"3^100");
            eq(1,(new MassiveNumbers()).getLargest("1^1000", "2^1"),"2^1");
            eq(2,(new MassiveNumbers()).getLargest("893^605", "396^906"),"396^906");
            eq(3,(new MassiveNumbers()).getLargest("999^1000", "1000^999"),"999^1000");
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
