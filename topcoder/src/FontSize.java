// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// Graphical user interfaces rely on text routines to properly display words on 
 * various GUI components. Being able to determine the width in pixels of a line 
 * of text is useful for centering the text in a window. You will be given a sentence 
 * of letters and spaces. You will also be given the letter widths for both uppercase 
 * and lowercase letters of a particular font. You must return the width of the sentence.


Both uppercase and lowercase contain 26 elements. The first element of uppercase is 
the width of 'A' and the last is the width of 'Z'. The first element of lowercase is the 
width of 'a' and the last is the width of 'z'. The width of the space character is always 
3 pixels. When a line of text is rendered, there is a gap of 1 pixel between each pair of adjacent characters.


DEFINITION
Class:FontSize
Method:getPixelWidth
Parameters:String, int[], int[]
Returns:int
Method signature:int getPixelWidth(String sentence, int[] uppercase, int[] lowercase)


CONSTRAINTS
-sentence will contain between 1 and 50 characters, inclusive.
-sentence will only contain uppercase letters ('A'-'Z'), lowercase letters ('a'-'z'), and spaces.
-uppercase will contain exactly 26 elements.
-lowercase will contain exactly 26 elements.
-Each value in uppercase and lowercase will be between 1 and 36, inclusive.


EXAMPLES

0)
"Dead Beef"
{6,6,6,7,7,7,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}
{5,5,5,4,4,4,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}

Returns: 49


D   e   a   d  (space)  B   e   e   f
7+1+4+1+5+1+4+1 + 3 + 1+6+1+4+1+4+1+4 = 49



1)
"Hello World"
{7,8,8,8,7,8,8,8,7,8,8,8,8,8,7,8,8,8,8,8,7,8,8,8,8,8}
{5,6,6,6,5,6,6,6,5,6,6,6,6,6,5,6,6,6,6,6,5,6,6,6,6,6}

Returns: 74

2)
"Hello World"
{7,7,7,7,7,7,7,8,7,7,7,7,7,7,7,7,7,7,7,7,7,7,9,7,7,7}
{5,5,5,6,6,5,5,5,5,5,5,1,5,5,6,5,5,6,5,5,5,5,5,5,5,5}

Returns: 63

3)
"ThE qUiCk BrOwN fOx JuMpEd OvEr ThE lAzY dOg"
{36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11}
{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26}

Returns: 778

4)
"two  spaces"
{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}
{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}

Returns: 43

*/
// END CUT HERE
import java.util.*;
public class FontSize {
    public int getPixelWidth(String sentence, int[] uppercase, int[] lowercase) {
        int res = 0;
        
        for(int i=0; i < sentence.length(); i++) {
        	char c = sentence.charAt(i);
        	int cVal = (int)c;
        	if(c == ' ') {
        		res += 3;
        	} else if(cVal > 96) {
        		res += lowercase[cVal-97];
        	} else {
        		res += uppercase[cVal-65];
        	}
        	
        	if(i < sentence.length()-1) {
        		res += 1;
        	}
        }
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FontSize()).getPixelWidth("Dead Beef", new int[] {6,6,6,7,7,7,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}, new int[] {5,5,5,4,4,4,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}),49);
            eq(1,(new FontSize()).getPixelWidth("Hello World", new int[] {7,8,8,8,7,8,8,8,7,8,8,8,8,8,7,8,8,8,8,8,7,8,8,8,8,8}, new int[] {5,6,6,6,5,6,6,6,5,6,6,6,6,6,5,6,6,6,6,6,5,6,6,6,6,6}),74);
            eq(2,(new FontSize()).getPixelWidth("Hello World", new int[] {7,7,7,7,7,7,7,8,7,7,7,7,7,7,7,7,7,7,7,7,7,7,9,7,7,7}, new int[] {5,5,5,6,6,5,5,5,5,5,5,1,5,5,6,5,5,6,5,5,5,5,5,5,5,5}),63);
            eq(3,(new FontSize()).getPixelWidth("ThE qUiCk BrOwN fOx JuMpEd OvEr ThE lAzY dOg", new int[] {36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11}, new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26}),778);
            eq(4,(new FontSize()).getPixelWidth("two  spaces", new int[] {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}, new int[] {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}),43);
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
