/*
// BEGIN CUT HERE

// PROBLEM STATEMENT
// You have a sentence written entirely in a single row.  
 * You would like to split it into several rows by replacing some of the 
 * spaces with "new row" indicators.  Your goal is to minimize the 
 * width of the longest row in the resulting text 
 * ("new row" indicators do not count towards the width of a row).  
 * You may replace at most K spaces.

You will be given a String sentence and an int K. 
Split the sentence using the procedure described above and return the width of the longest row.


DEFINITION
Class:SentenceSplitting
Method:split
Parameters:String, int
Returns:int
Method signature:int split(String sentence, int K)


CONSTRAINTS
-sentence will contain between 1 and 50 characters, inclusive.
-sentence will consist of only letters ('a'-'z', 'A'-'Z') and spaces (' ').
-Each space character in sentence will be between two letters.
-K will be between 1 and 50, inclusive.


EXAMPLES

0)
"This is a test sentence"
1

Returns: 13

You should split the sentence between the words "a" and "test".

1)
"TheOnlyWord"
37

Returns: 11

2)
"One veeeeeeeeeeeeeeeeeeery long word"
2

Returns: 22

3)
"Each tournament round is an elimination round"
3

Returns: 15

// END CUT HERE

 */
import java.util.*;
public class SentenceSplitting {
    public int split(String sentence, int K) {
        int len = sentence.length();
        if(K == 0) {
        	return len;
        }
        
        String[] words = sentence.split(" ");
        for(int k=0; k<K; k++) {
        	for(int j=0; j<words.length-1; j++){
        		
        	}
        }
        
        double avg = (double)len/K;
        int c = (int) Math.ceil(avg);
        
        int maxCount = 0;
        int count = 0;
        int lastSpace = 0;
        int lastSpaceCount = 0;
        for(int i=0; i < len; i++) {
        	count ++;
        	
        	if(sentence.charAt(i) == ' ') {
        		lastSpace = i;
        		lastSpaceCount = count;
        	}
        	
        	if(count > c) {
        		if(lastSpaceCount > maxCount) {
        			maxCount = lastSpaceCount;
        		}
        		count = i - lastSpace;
        	}
        }
        
        return maxCount;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SentenceSplitting()).split("This is a test sentence", 1),13);
            eq(1,(new SentenceSplitting()).split("TheOnlyWord", 37),11);
            eq(2,(new SentenceSplitting()).split("One veeeeeeeeeeeeeeeeeeery long word", 2),22);
            eq(3,(new SentenceSplitting()).split("Each tournament round is an elimination round", 3),15);
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
