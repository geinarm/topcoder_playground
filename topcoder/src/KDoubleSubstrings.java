// BEGIN CUT HERE
// PROBLEM STATEMENT
// 
/*
A k-double string is a non-empty string consisting of two equal length halves, 
where the first half differs from the second half at no more than k positions. 
For example, "contestcontest", "oopoop" and "aa" are 0-double strings. "contestkontest" is a 
1-double string, and "poorpork", "artbat", and "yesyep" are 2-double strings. Obviously, 
all 0-double strings are also 1-double strings, all 1-double strings are also 2-double strings, etc.


You will be given a String[] str and an int k. Concatenate the elements of str to form one long 
string, and return the number of k-double substrings contained in that string.


If the same string exists in several different positions, count it as many times as it exists.
Also, k-double substrings can overlap. See the examples for more details.


DEFINITION
Class:KDoubleSubstrings
Method:howMuch
Parameters:String[], int
Returns:int
Method signature:int howMuch(String[] str, int k)


CONSTRAINTS
-str will contain between 1 and 5 elements, inclusive.
-Each element of str will contain between 1 and 50 characters, inclusive.
-Each element of str will contain only lowercase letters ('a'-'z').
-k will be between 0 and 100, inclusive.


EXAMPLES

0)
{"aa"}
0

Returns: 1

"aa" is the only 0-double substring.

1)
{"aaaa"}
0

Returns: 4

There are four substrings of even length and all of them are 0-double strings.

2)
{"contest", "kontest"}
1

Returns: 14

Each pair of consecutive letters form a 1-double substring and the whole string form one more 1-double substring.

3)
{"abacaba", "d", "abacaba"}
1

Returns: 34



4)
{"areyouready"}
2

Returns: 18


*/
// END CUT HERE
import java.util.*;
public class KDoubleSubstrings {
    public int howMuch(String[] str, int k) {
        
        String concat = "";
        for(String s : str) {
        	concat += s;
        }
        System.out.println("\nStr: " + concat + " k: " + k);
        
        int count = 0;
        for(int i=0; i < concat.length(); i++) {
        	for(int n=2; n <= concat.length() - i; n++) {
        		String subStr = concat.substring(i, i+n);
        		System.out.println(subStr);
        		
        		if(subStr.length() % 2 != 0) {
        			//System.out.println("Skip");
        			continue;
        		}
        		
        		int diff = 0;
        		for(int m=0; m < subStr.length()/2; m++) {
        			//System.out.println("M: " + m + " - " + (subStr.length() -m -1));
        			if(subStr.charAt(m) != subStr.charAt(subStr.length()/2 +m)) {
        				diff ++;
        			}
        		}
        		//System.out.println("Diff: " + diff);
        		if(diff <= k) {
        			count++;
        		}
        	}
        }
        System.out.println("Return: " + count);
        return count;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new KDoubleSubstrings()).howMuch(new String[] {"aa"}, 0),1);
            eq(1,(new KDoubleSubstrings()).howMuch(new String[] {"aaaa"}, 0),4);
            eq(2,(new KDoubleSubstrings()).howMuch(new String[] {"contest", "kontest"}, 1),14);
            eq(3,(new KDoubleSubstrings()).howMuch(new String[] {"abacaba", "d", "abacaba"}, 1),34);
            eq(4,(new KDoubleSubstrings()).howMuch(new String[] {"areyouready"}, 2),18);
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
