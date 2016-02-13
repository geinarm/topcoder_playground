// BEGIN CUT HERE
// PROBLEM STATEMENT
import java.lang.reflect.Array;
// A busy businessman has a number of equally important tasks which he must accomplish.  
/*
To decide which of the tasks to perform first, he performs the following operation.

He writes down all his tasks in the form of a circular list, so the first task is adjacent to the last task. 
He then thinks of a positive number. This number is the random seed, which he calls n. Starting with the first task, 
he moves clockwise (from element 1 in the list to element 2 in the list and so on), counting from 1 to n. 
When his count reaches n, he removes that task from the list and starts counting from the next available task. 
He repeats this procedure until one task remains. It is this last task that he chooses to execute.

Given a String[] list representing the tasks and an int n, return the task which the businessman chooses to execute.



DEFINITION
Class:BusinessTasks
Method:getTask
Parameters:String[], int
Returns:String
Method signature:String getTask(String[] list, int n)


CONSTRAINTS
-list will contain between 2 and 50 elements inclusive.
-Each element in list will contain between 1 and 50 characters inclusive.
-Each element in list will contain only characters 'a'-'z'.
-n will be between 1 and 10000000 inclusive.


EXAMPLES

0)
{"a","b","c","d"}
2

Returns: "a"

We start counting from a. So a is 1, b is 2. We remove b, so list is now {a,c,d}. We continue from c. So c is 1, d is 2. We remove d, so list is now {a,c}. We continue from a. So a is 1, c is 2. We remove c, and now we are left with the last task a.

1)
{"a","b","c","d","e"}
3

Returns: "d"

We start counting from a. So a is 1, b is 2, c is 3. We remove c, now list = {a,b,d,e}. We continue from d. So d is 1, e is 2, a is 3. We remove a, now list = {b,d,e}. We continue from b. So b is 1, d is 2, e is 3. We remove e, now list = {b,d}. We continue from b. So b is 1, d is 2 and finally b is 3. We remove b, and now we are left with just one task d.

2)
{"alpha","beta","gamma","delta","epsilon"}
1

Returns: "epsilon"

3)
{"a","b"}
1000

Returns: "a"

4)
{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
"u","v","w","x","y","z"}
17

Returns: "n"

5)
{"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
"olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
"qgcxjbfx","my","mlhy","bt","bo","q"}
9000000

Returns: "fxjqzznvg"
*/
// END CUT HERE

import java.util.*;
public class BusinessTasks {
    public String getTask(String[] list, int n) {
        String res = "";
        
        int index = 0;
        while(list.length > 1) {
        	index += n;
        	index = (index-1) % list.length;
        	list = removeIndex(list, index);
        }
        
        return list[0];
    }
    
    public String[] removeIndex(String[] arr, int index) {
    	String[] newArr = new String[arr.length -1];
    	
    	int k = 0;
    	for(int i=0; i < arr.length; i++) {
    		if(i != index) {
    			newArr[k] = arr[i];
    			k++;
    		}
    	}
    	
    	return newArr;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BusinessTasks()).getTask(new String[] {"a","b","c","d"}, 2),"a");
            eq(1,(new BusinessTasks()).getTask(new String[] {"a","b","c","d","e"}, 3),"d");
            eq(2,(new BusinessTasks()).getTask(new String[] {"alpha","beta","gamma","delta","epsilon"}, 1),"epsilon");
            eq(3,(new BusinessTasks()).getTask(new String[] {"a","b"}, 1000),"a");
            eq(4,(new BusinessTasks()).getTask(new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
               "u","v","w","x","y","z"}, 17),"n");
            eq(5,(new BusinessTasks()).getTask(new String[] {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
               "olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
               "qgcxjbfx","my","mlhy","bt","bo","q"}, 9000000),"fxjqzznvg");
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
