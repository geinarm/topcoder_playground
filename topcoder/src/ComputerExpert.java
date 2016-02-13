// BEGIN CUT HERE
// PROBLEM STATEMENT
/*
// A human expert uses his prior knowledge to analyze a set of observations that are presented to him. 
 days, companies are starting to explore the benefits of computerized expert systems. 
 Expert systems attempt to model the way human experts think and arrive at conclusions. 
 Knowledge obtained in this way is more reliable, cheaper and reproducible.

facts contains all the observations presented to the expert. rules is a set of rules that the expert 
can use to arrive at new conclusions. 
rules will be formatted as (<FACT>/.../<FACT>),...,(<FACT>/.../<FACT>) -> <FACT>. In the input, '/' 
represents the OR operator and ',' represents the AND operator.  Hence, the above input represents a boolean 
expression like (<FACT> OR ... OR <FACT>) AND ... AND (<FACT> OR ... OR <FACT>) -> <FACT>.  Each <FACT> 
represents a sequence of uppercase characters and the character '_'. Note: brackets and parentheses are only 
used for clarity and are not part of the input.

A rule composed solely of AND will fire only if all the facts listed in the rule are known. Similarly, 
a rule composed solely of OR will fire if any of the facts listed in the rule are known. 
Once a rule has fired, its outcome fact can be added to the knowledge of the expert (if not already known).

Given a String[] of facts and a String[] of rules return a String[] of all outcome facts, 
sorted in ascending alphabetical order. If there are no outcome facts then return an empty String[].

DEFINITION
Class:ComputerExpert
Method:operate
Parameters:String[], String[]
Returns:String[]
Method signature:String[] operate(String[] facts, String[] rules)


CONSTRAINTS
-facts will contain between 1 and 50 elements inclusive.
-Each element of facts will contain between 1 and 50 characters inclusive.
-Elements of facts will only contain characters 'A'-'Z' and the character '_'.
-rules will contain between 1 and 50 elements inclusive.
-Each element of rules will contain between 6 and 50 characters inclusive.
-Each element in rules will be formatted as (<FACT>/.../<FACT>),...,(<FACT>/.../<FACT>) -> <FACT>. In the input, '/' represents the OR operator and ',' represents the AND operator. Each <FACT> must be a sequence of uppercase characters 'A'-'Z' and the character '_'. Note: brackets and parentheses are only used for clarity and are not part of the input.


EXAMPLES

0)
{"SKY_IS_CLOUDY","HAVE_MONEY"}
{"HAVE_MONEY,BAD_WEATHER -> WATCH_MOVIE","SKY_IS_CLOUDY -> BAD_WEATHER",
"GOOD_WEATHER -> PLAY_SOCCER"}

Returns: {"BAD_WEATHER", "WATCH_MOVIE" }

In this simplistic example we want to decide whether to watch a movie or play soccer. We observe that SKY_IS_CLOUDY and that we HAVE_MONEY. The second rule tells us that if SKY_IS_CLOUDY then we have BAD_WEATHER. So we conclude that the weather is bad. Knowing this fact, we can now use the first rule that tells us that if we HAVE_MONEY and BAD_WEATHER then we WATCH_MOVIE. So we choose to watch a movie. The third rule never gets fired.

1)
{"NEEDLE_LEAF","KEEPS_LEAVES"}
{"KEEPS_LEAVES -> EVERGREEN","NEEDLE_LEAF -> GYMNOSPERM",
"EVERGREEN,GYMNOSPERM -> PINE_TREE"}

Returns: {"EVERGREEN", "GYMNOSPERM", "PINE_TREE" }

In this example we try to classify a plant. Since it has a NEEDLE_LEAF we know its a GYMNOSPERM. Since it KEEPS_LEAVES we know its an EVERGREEN. An EVERGREEN and a GYMNOSPERM must be a PINE_TREE.

2)
{"I"}
{"I -> I","P -> CONSONANT", "Z -> CONSONANT", "A/E/I/O/U -> VOWEL"}

Returns: {"VOWEL" }

I is a VOWEL. Note that there is no point firing the first rule, because we already know the outcome fact I.

3)
{"Y","W","L","T","H","J","G","T","F","P","T","P","P","N"}
{"C/V,J,F/T,N,W,L -> M","N/L,F,B/N/E,Y -> C",
"M,G,G,S/F/Q,G,S/G,H/Z,W,F,C,Q/F,M -> E"}

Returns: {"C", "E", "M" }

4)
{"G","H"}
{"A/B/C/D/E/F,G/Z -> Y", "H,H,H,H,H,H,H,H -> Z"}

Returns: {"Z" }

5)
{"A","B","_X", "X_"}
{"A/B,C -> D","A,B,C -> D","X -> Y","_X_ -> Y"}

Returns: { }

Here there are no rules fired. Note that "_X" and "X_" are not the same as "X" or "_X_".
*/
// END CUT HERE
import java.util.*;
public class ComputerExpert {
	
	List<String> factList;
	List<String> ruleList;
	
    public String[] operate(String[] facts, String[] rules) {
        String[] res = new String[0];
        
        factList = new ArrayList<String>();
        for(String s : facts) {
        	factList.add(s);
        }
        
        ruleList = new ArrayList<String>();
        for(String s : rules) {
        	ruleList.add(s);
        }
        
        ruleList.add("A");
        ruleList.add("B");
        boolean test = eval("A/B");
        System.out.println(test);
        
        return res;
        
    }
    
    private String fireRule(String rule) {
    	String[] ruleSplit = rule.split(" -> ");
    	
    	String conditions = ruleSplit[0];
    	String outcome = ruleSplit[1];
    	
    	return outcome;
    }
    
    private boolean eval(String ruleContitions) {
    	boolean b = true;
    	boolean first = true;
    	int index = 0;
    	String fact = "";
    	
    	while(index <= ruleContitions.length()) {
    		char c = ruleContitions.charAt(index);
    		
    		if(c == ',') { //AND
    			if(first) {
    				b = isKnown(fact);
    				first = false;
    				System.out.println(fact);
    			} else {
    				b = b & isKnown(fact);
    				System.out.println("AND " + fact);
    			}
    			fact = "";
    			
    		} else if(c == '/') { //OR
    			if(first) {
    				b = isKnown(fact);
    				first = false;
    				System.out.println(fact);
    			} else {
    				b = b | isKnown(fact);
    				System.out.println("OR " + fact);
    			}
    			fact = "";
    		} else {
    			fact += c;
    		}
    		index ++;
    	}
    	
    	return false;
    }
    
    private boolean isKnown(String fact) {
    	return factList.contains(fact);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
    	
    	
    	
        try {
            eq(0,(new ComputerExpert()).operate(new String[] {"SKY_IS_CLOUDY","HAVE_MONEY"}, new String[] {"HAVE_MONEY,BAD_WEATHER -> WATCH_MOVIE","SKY_IS_CLOUDY -> BAD_WEATHER",
               "GOOD_WEATHER -> PLAY_SOCCER"}),new String[] {"BAD_WEATHER", "WATCH_MOVIE" });
            eq(1,(new ComputerExpert()).operate(new String[] {"NEEDLE_LEAF","KEEPS_LEAVES"}, new String[] {"KEEPS_LEAVES -> EVERGREEN","NEEDLE_LEAF -> GYMNOSPERM",
               "EVERGREEN,GYMNOSPERM -> PINE_TREE"}),new String[] {"EVERGREEN", "GYMNOSPERM", "PINE_TREE" });
            eq(2,(new ComputerExpert()).operate(new String[] {"I"}, new String[] {"I -> I","P -> CONSONANT", "Z -> CONSONANT", "A/E/I/O/U -> VOWEL"}),new String[] {"VOWEL" });
            eq(3,(new ComputerExpert()).operate(new String[] {"Y","W","L","T","H","J","G","T","F","P","T","P","P","N"}, new String[] {"C/V,J,F/T,N,W,L -> M","N/L,F,B/N/E,Y -> C",
               "M,G,G,S/F/Q,G,S/G,H/Z,W,F,C,Q/F,M -> E"}),new String[] {"C", "E", "M" });
            eq(4,(new ComputerExpert()).operate(new String[] {"G","H"}, new String[] {"A/B/C/D/E/F,G/Z -> Y", "H,H,H,H,H,H,H,H -> Z"}),new String[] {"Z" });
            eq(5,(new ComputerExpert()).operate(new String[] {"A","B","_X", "X_"}, new String[] {"A/B,C -> D","A,B,C -> D","X -> Y","_X_ -> Y"}),new String[] { });
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
