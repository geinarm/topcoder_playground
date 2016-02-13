//// BEGIN CUT HERE
//// PROBLEM STATEMENT
//// You are the coordinator of a contest, and you have been presented with the final scores 
//of all the contestants. It is now your job to determine the quality of the contest. 
//To do this, you will compute the average score after eliminating the k highest 
//scoring contestants and the k lowest scoring contestants. k is a non-negative 
//integer (it can be 0), and you will choose a value for k that yields the maximum 
//average score. Return a double representing this maximum average score. 
//You are not allowed to eliminate all the scores.
//
//
//DEFINITION
//Class:ContestCoordinator
//Method:bestAverage
//Parameters:int[]
//Returns:double
//Method signature:double bestAverage(int[] scores)
//
//
//NOTES
//-The returned value must be accurate to 1e-9 relative or absolute.
//
//
//CONSTRAINTS
//-scores will contain between 1 and 50 elements, inclusive.
//-Each element of scores will be between 1 and 1000, inclusive.
//
//
//EXAMPLES
//
//0)
//{1}
//
//Returns: 1.0
//
//There's nothing to remove here.
//
//1)
//{1,2,3,4}
//
//Returns: 2.5
//
//Eliminating the first and the last score yields an average score of 2.5
//
//2)
//{1,1,999,999,1000,1000}
//
//Returns: 999.0
//
//Keep only the scores equal to 999.
//
//3)
//{1,13,8,6,7,9}
//
//Returns: 7.5
//
//4)
//{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
//
//Returns: 1.0

// END CUT HERE
import java.util.*;
public class ContestCoordinator {
    public double bestAverage(int[] scores) {
        //double res = 0.0;
        
    	ArrayList<Integer> arr = new ArrayList<>();
    	Collections.sort(arr);
    	
        int[] orderedScores = new int[scores.length];
        for(int i=0; i < scores.length; i++) {
        	int minIndex = 0;
        	int minValue = Integer.MAX_VALUE;
        	for(int j=0; j < scores.length; j++) {
            	if(scores[j] < minValue) {
            		minValue = scores[j];
            		minIndex = j;
            	}
        	}
        	orderedScores[i] = minValue;
        	scores[minIndex] = Integer.MAX_VALUE;
        }
        
        int maxK = (orderedScores.length/2) +1;
        if(maxK < 0) maxK = 0;
        
        double bestAverage = 0.0;
        int bestK = 0;
        int k = 0;
        do {
	        int sum = 0;
	        int count = orderedScores.length;
	        
	        System.out.print("\n");
	        for(int i=k; i < count-k; i++) {
	        	sum += orderedScores[i];
	        	System.out.print(orderedScores[i] + ", ");
	        }
	        System.out.print("\n");
	        
	        double average = (double)sum / (count-2*k);
	        //System.out.println(average);
	        if(average > bestAverage) {
	        	bestAverage = average;
	        	bestK = k;
	        }
	        k++;
        } while(k*2 < orderedScores.length);

        return bestAverage;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            //eq(0,(new ContestCoordinator()).bestAverage(new int[] {1}),1.0);
            //eq(1,(new ContestCoordinator()).bestAverage(new int[] {1,2,3,4}),2.5);
            //eq(2,(new ContestCoordinator()).bestAverage(new int[] {1,1,999,999,1000,1000}),999.0);
            //eq(3,(new ContestCoordinator()).bestAverage(new int[] {1,13,8,6,7,9}),7.5);
            //eq(4,(new ContestCoordinator()).bestAverage(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}),1.0);
            eq(5,(new ContestCoordinator()).bestAverage(new int[] {9, 5, 1, 7, 7, 7, 1, 5, 3, 10, 1, 5, 5, 3, 8, 10, 5, 7, 1, 6, 5, 9, 7, 7, 8, 10, 6, 9, 9, 1, 4, 5, 10, 6, 4, 2, 8, 5, 8, 7, 10, 4, 3, 2, 3, 10, 3, 9, 4, 3}),6.0);
            

        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
//    private static void eq( int n, int a, int b ) {
//        if ( a==b )
//            System.err.println("Case "+n+" passed.");
//        else
//            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
//    }
    private static void eq( int n, double a, double b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
//    private static void eq( int n, char a, char b ) {
//        if ( a==b )
//            System.err.println("Case "+n+" passed.");
//        else
//            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
//    }
//    private static void eq( int n, long a, long b ) {
//        if ( a==b )
//            System.err.println("Case "+n+" passed.");
//        else
//            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
//    }
//    private static void eq( int n, boolean a, boolean b ) {
//        if ( a==b )
//            System.err.println("Case "+n+" passed.");
//        else
//            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
//    }
//    private static void eq( int n, String a, String b ) {
//        if ( a != null && a.equals(b) )
//            System.err.println("Case "+n+" passed.");
//        else
//            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
//    }
//    private static void eq( int n, int[] a, int[] b ) {
//        if ( a.length != b.length ) {
//            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
//            return;
//        }
//        for ( int i= 0; i < a.length; i++)
//            if ( a[i] != b[i] ) {
//                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
//                print( b );
//                print( a );
//                return;
//            }
//        System.err.println("Case "+n+" passed.");
//    }
//    private static void eq( int n, long[] a, long[] b ) {
//        if ( a.length != b.length ) {
//            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
//            return;
//        }
//        for ( int i= 0; i < a.length; i++ )
//            if ( a[i] != b[i] ) {
//                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
//                print( b );
//                print( a );
//                return;
//            }
//        System.err.println("Case "+n+" passed.");
//    }
//    private static void eq( int n, String[] a, String[] b ) {
//        if ( a.length != b.length) {
//            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
//            return;
//        }
//        for ( int i= 0; i < a.length; i++ )
//            if( !a[i].equals( b[i])) {
//                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
//                print( b );
//                print( a );
//                return;
//            }
//        System.err.println("Case "+n+" passed.");
//    }
//    private static void print( int a ) {
//        System.err.print(a+" ");
//    }
//    private static void print( long a ) {
//        System.err.print(a+"L ");
//    }
//    private static void print( String s ) {
//        System.err.print("\""+s+"\" ");
//    }
//    private static void print( int[] rs ) {
//        if ( rs == null) return;
//        System.err.print('{');
//        for ( int i= 0; i < rs.length; i++ ) {
//            System.err.print(rs[i]);
//            if ( i != rs.length-1 )
//                System.err.print(", ");
//        }
//        System.err.println('}');
//    }
//    private static void print( long[] rs) {
//        if ( rs == null ) return;
//        System.err.print('{');
//        for ( int i= 0; i < rs.length; i++ ) {
//            System.err.print(rs[i]);
//            if ( i != rs.length-1 )
//                System.err.print(", ");
//        }
//        System.err.println('}');
//    }
//    private static void print( String[] rs ) {
//        if ( rs == null ) return;
//        System.err.print('{');
//        for ( int i= 0; i < rs.length; i++ ) {
//            System.err.print( "\""+rs[i]+"\"" );
//            if( i != rs.length-1)
//                System.err.print(", ");
//        }
//        System.err.println('}');
//    }
//    private static void nl() {
//        System.err.println();
//    }
// END CUT HERE
}
