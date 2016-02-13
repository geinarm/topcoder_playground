//// BEGIN CUT HERE
//// PROBLEM STATEMENT
//// You took a test consisting of N questions, each of which has a distinct point 
//value between 1 and N, inclusive, and you have finally received the results.  
//Along with your final score, you are told which questions you answered correctly.  
//However, you are not given the point values that were assigned to the questions.  
//For each correct answer, you received the full point value of the question, and for 
//each wrong answer, you received 0 points.  You must determine the minimum possible 
//error of a valid point assignment that would result in the final score that you received.  
//The error of a valid assignment of points is defined as follows: For each question i 
//(where i is a 1-based index), let e(i) = the absolute value of (i minus the point value 
//of the question).  The error of the point assignment is the maximum value of e(i).
//
//Given a String questions and an int score, return an int representing the 
//minimum possible error of a valid point assignment.  The ith character 
//(where i is a 1-based index) of questions is either 'C', meaning that you answered 
//question i correctly, or 'W', meaning that you answered it wrong.  
//If there is no valid point assignment, return -1.
//
//DEFINITION
//Class:ScoreRecomposition
//Method:minError
//Parameters:String, int
//Returns:int
//Method signature:int minError(String questions, int score)
//
//
//CONSTRAINTS
//-questions will contain exactly N elements, where N is between 1 and 10, inclusive.
//-Each character of questions will be either 'C' or 'W'.
//-score will be between 0 and N*(N+1)/2, inclusive.
//
//
//EXAMPLES
//
//0)
//"CCC"
//5
//
//Returns: -1
//
//Contact the contest director immediately! Since you answered every question correctly, your score should be 6.
//
//1)
//"WCWW"
//4
//
//Returns: 2
//
//Obviously, you answered only the 4-point question correctly.
//
//2)
//"CWW"
//1
//
//Returns: 0
//
//The minimum error occurs when each question i is assigned a point value of i.
//
//3)
//"CWCC"
//6
//
//Returns: 2
//
//One valid point assignment with the lowest possible error is 1, 4, 2, 3.
//
//4)
//"WWCC"
//3
//
//Returns: 2
//
//5)
//"CWCCWWCWCC"
//55
//
//Returns: -1
//
//6)
//"CWWCWCCWWC"
//37
//
//Returns: 3

// END CUT HERE
import java.util.*;
public class ScoreRecomposition {
    public int minError(String questions, int score) {
        int res = 0;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ScoreRecomposition()).minError("CCC", 5),-1);
            eq(1,(new ScoreRecomposition()).minError("WCWW", 4),2);
            eq(2,(new ScoreRecomposition()).minError("CWW", 1),0);
            eq(3,(new ScoreRecomposition()).minError("CWCC", 6),2);
            eq(4,(new ScoreRecomposition()).minError("WWCC", 3),2);
            eq(5,(new ScoreRecomposition()).minError("CWCCWWCWCC", 55),-1);
            eq(6,(new ScoreRecomposition()).minError("CWWCWCCWWC", 37),3);
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
