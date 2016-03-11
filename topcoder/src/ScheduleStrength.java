// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// A common way to rank athletic teams is based on each team's winning percentage. 
 * However, when two teams have similar percentages, the team that played against better opponents will be 
 * ranked above the team that had easier opponents. The measure of how difficult a team's opponents are, 
 * is known as the team's strength of schedule. A team that has faced tough opponents is said to have a 
 * strong schedule, and a team with poor opponents is said to have a weak schedule.


We will use the cumulative winning percentage of Team X's opponents (the teams that Team X played against) 
as a measure of Team X's strength of schedule. This percentage is the number of wins recorded by Team X's 
opponents divided by the total games they played, excluding games that were played against Team X.



Given a String[] of teams that contains the name of each team and a String[] results that indicates the 
outcome of games played during the season, return a String[] containing the names of the teams, 
ordered from strongest schedule to weakest. Teams with equivalent schedule strengths should appear in 
increasing alphabetical order.



Element i of results corresponds to team i whose name is found in teams at index i. 
Character j of element i of results will be one of 'W', 'L' or '-' respectively indicating whether 
team i won, lost, or did not play a game against team j.


DEFINITION
Class:ScheduleStrength
Method:calculate
Parameters:String[], String[]
Returns:String[]
Method signature:String[] calculate(String[] teams, String[] results)


CONSTRAINTS
-teams will contain between 3 and 50 elements, inclusive.
-teams and results will contain the same number of elements.
-Each element of teams will contain between 1 and 50 characters, inclusive.
-Each element of teams will only contain uppercase letters ('A'-'Z').
-Each element of teams will be distinct.
-Each element of results will contain N characters, where N is the number of elements in teams.
-Each element of results will only contain 'W', 'L' and '-'.
-The ith character of the ith element of results will be '-'.
-If the jth character of the ith element of results is 'W' then the ith character of the jth element of results will be 'L', and vice versa.
-Every team will play at least two games.


EXAMPLES

0)
{"BEARS",
 "GIANTS",
 "COWBOYS",
 "BRONCOS",
 "DOLPHINS",
 "LIONS"}
{"-WLWW-",
 "L-WL-W",
 "WL---W",
 "LW--L-",
 "L--W--",
 "-LL---"}

Returns: {"BEARS", "DOLPHINS", "BRONCOS", "COWBOYS", "GIANTS", "LIONS" }

This season's results gives us the following win/loss records:


        wins - losses
BEARS      3 - 1
GIANTS     2 - 2  (1 loss to the BEARS)
COWBOYS    2 - 1  (1 win against the BEARS)
BRONCOS    1 - 2  (1 loss to the BEARS)
DOLPHINS   1 - 1  (1 loss to the BEARS)
LIONS      0 - 2  (did not play the BEARS)



The BEARS's opponents are the GIANTS, COWBOYS, BRONCOS and DOLPHINS. 
Their combined win/loss record is 6-6 (6 wins, 6 losses), but when we exclude games 
played against the BEARS, this record becomes 5-3. So, the BEARS have a schedule strength of 5/8 = .625


Here are the cumulative records and winning percentages calculated for each team:

           Record    Winning %
BEARS      5 - 3    5/8 = .625
GIANTS     4 - 4    4/8 = .5
COWBOYS    4 - 3    4/7 = .5714
BRONCOS    4 - 3    4/7 = .5714
DOLPHINS   3 - 2    3/5 = .6
LIONS      2 - 3    2/5 = .4



1)
{"BEARS",
 "COWBOYS",
 "GIANTS",
 "PACKERS"}

{"-LLW",
 "W-WW",
 "WL--",
 "LL--"}

Returns: {"GIANTS", "BEARS", "COWBOYS", "PACKERS" }

2)
{"AZTECS",
 "COUGARS",
 "COWBOYS",
 "FALCONS",
 "HORNEDFROGS",
 "LOBOS",
 "RAMS",
 "REBELS",
 "UTES"}

{"---L-L--W",
 "--LL-LWL-",
 "-W--WWLLW",
 "WW---L--W",
 "--L--W-L-",
 "WWLWL-LW-",
 "-LW--W-L-",
 "-WW-WLW--",
 "L-LL-----"}


Returns: {"HORNEDFROGS", "COUGARS", "RAMS", "LOBOS", "REBELS", "UTES", "COWBOYS", "AZTECS", "FALCONS" }

3)
{"E", "D", "C", "B", "Z"}
{
"--LLL",
"---LL",
"W---L",
"WW---",
"WWW--"
}

Returns: {"D", "E", "C", "Z", "B" }
*/
// END CUT HERE
import java.util.*;
public class ScheduleStrength {
    public String[] calculate(String[] teams, String[] results) {
        String[] res;
        List<Team> ordered = new ArrayList<Team>();
        
        for(int i=0; i < teams.length; i++) {
            double wins = 0;
            double losses = 0;
            for(int k=0; k < teams.length; k++) {
            	if(k == i) {
            		continue;
            	}
            	if(results[k].charAt(i) == '-'){
            		continue;
            	}
            	String games = results[k];
	        	for(int j=0; j < teams.length; j++) {
	            	if(i == j) {
	            		continue;
	            	}
	            	char c = games.charAt(j);
	            	if(c == 'W') {
	            		wins ++;
	            	}
	            	if(c == 'L') {
	            		losses ++;
	            	}
	            }
            }
        	
        	Team t = new Team(teams[i], wins/(wins+losses));
        	ordered.add(t);
        	
        }
        Collections.sort(ordered);
        res = new String[teams.length];
        for(int i=0; i < teams.length; i++) {
        	res[i] = ordered.get(i).name;
        }
        
        return res;
    }
    
    public class Team implements Comparable<Team> {
    	String name;
    	double scheduleStrength;
    	
    	public Team(String name, double ss) {
    		this.name = name;
    		this.scheduleStrength = ss;
    	}

		@Override
		public int compareTo(Team o) {
			if(this.scheduleStrength > o.scheduleStrength) {
				return -1;
			} else if(this.scheduleStrength < o.scheduleStrength) {
				return 1;
			} else {
				return this.name.compareTo(o.name);
			}
		}
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ScheduleStrength()).calculate(new String[] {"BEARS",
                "GIANTS",
                "COWBOYS",
                "BRONCOS",
                "DOLPHINS",
                "LIONS"}, new String[] {
            	"-WLWW-",
                "L-WL-W",
                "WL---W",
                "LW--L-",
                "L--W--",
                "-LL---"}),new String[] {"BEARS", "DOLPHINS", "BRONCOS", "COWBOYS", "GIANTS", "LIONS" });
            eq(1,(new ScheduleStrength()).calculate(new String[] {"BEARS",
                "COWBOYS",
                "GIANTS",
                "PACKERS"}
               , new String[] {"-LLW",
                "W-WW",
                "WL--",
                "LL--"}),new String[] {"GIANTS", "BEARS", "COWBOYS", "PACKERS" });
            eq(2,(new ScheduleStrength()).calculate(new String[] {"AZTECS",
                "COUGARS",
                "COWBOYS",
                "FALCONS",
                "HORNEDFROGS",
                "LOBOS",
                "RAMS",
                "REBELS",
                "UTES"}
               , new String[] {"---L-L--W",
                "--LL-LWL-",
                "-W--WWLLW",
                "WW---L--W",
                "--L--W-L-",
                "WWLWL-LW-",
                "-LW--W-L-",
                "-WW-WLW--",
                "L-LL-----"}
               ),new String[] {"HORNEDFROGS", "COUGARS", "RAMS", "LOBOS", "REBELS", "UTES", "COWBOYS", "AZTECS", "FALCONS" });
            eq(3,(new ScheduleStrength()).calculate(new String[] {"E", "D", "C", "B", "Z"}, new String[] {
               "--LLL",
               "---LL",
               "W---L",
               "WW---",
               "WWW--"
               }),new String[] {"D", "E", "C", "Z", "B" });
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
