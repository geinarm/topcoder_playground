// BEGIN CUT HERE
// PROBLEM STATEMENT
// 
John and Brus have become very famous people all over the world, especially in Bolivia.
A man in Bolivia decided to write a story about them.
To make the story more truthful, he set up an interview with John.
He prepared a list of distinct simple "Yes" or "No" questions and he enlisted the help of two friends to transcribe the interview.
Each time he asked a question, one friend wrote down the question while the other friend wrote down the answer.
He was very nervous when conducting the interview, so he might have asked some of the questions multiple times.
However, John's answers always remained the same for the same questions.



Unfortunately, the friend who was writing down the questions lost his list.
In a desperate attempt to remember the order in which he asked the questions, the Bolivian has decided to write down all the possible ways that he might have asked them.
He knows for sure that he asked every question from his list at least once.
You are given an int questions, which is the number of questions that were in his list, and a String[] answers, the i-th element of which is the answer to the i-th question he asked.
Return the total number of ways in which he might have asked the questions.



DEFINITION
Class:TheQuestionsAndAnswersDivOne
Method:find
Parameters:int, String[]
Returns:int
Method signature:int find(int questions, String[] answers)


CONSTRAINTS
-questions will be between 2 and 9, inclusive.
-answers will contain between questions and 9 elements, inclusive.
-Each element of answers will be either "Yes" or "No".


EXAMPLES

0)
2
{"No", "Yes"}

Returns: 2

The two possible ways are: the first question followed by the second question, or vice versa.

1)
2
{"No", "No", "No"}

Returns: 6

2)
3
{"Yes", "No", "No", "Yes"}

Returns: 12



3)
3
{"Yes", "Yes", "Yes", "No"}

Returns: 18

// END CUT HERE
import java.util.*;
public class TheQuestionsAndAnswersDivOne {
    public int find(int questions, String[] answers) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TheQuestionsAndAnswersDivOne()).find(2, new String[] {"No", "Yes"}),2);
            eq(1,(new TheQuestionsAndAnswersDivOne()).find(2, new String[] {"No", "No", "No"}),6);
            eq(2,(new TheQuestionsAndAnswersDivOne()).find(3, new String[] {"Yes", "No", "No", "Yes"}),12);
            eq(3,(new TheQuestionsAndAnswersDivOne()).find(3, new String[] {"Yes", "Yes", "Yes", "No"}),18);
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
