import java.util.*;
import java.util.function.*;

class HockeyPlayer{
	private String lastName;
	private String position;
	private String birthplace;
	private boolean isGoalie;
	private boolean isDefense;
	private boolean isForward;
	private boolean isLeftShot;
	private boolean isRightShot;
	
	public HockeyPlayer(String lastName, String position, String birthplace, boolean goalie, boolean defense, boolean forward, boolean leftShot, boolean rightShot){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
		isGoalie = goalie;
		isDefense = defense;
		isForward = forward;
		isLeftShot = leftShot;
		isRightShot = rightShot;
	}

	public boolean isGoalie(){
		return isGoalie;
	}
	
	public boolean isDefense(){
		return isDefense;
	}
	
	public boolean isForward(){
		return isForward;	
	}

	public boolean isLeftShot(){
		return isLeftShot;	
	}
	
	public boolean isRightShot(){
		return isRightShot;	
	}
	
	public String toString(){
		return lastName;
	}
	
	public String rosterOutput(){
		return "POSITION: " + position+ "\tNAME: " + lastName;	
	}
	
	public boolean isBornHere(String country){
		if(birthplace.equals(country)){
			return true;		
		}
		else{
			return false;	
		}
	}
	
	public String getPosition(){
		return position;	
	}
}

public class LambdaSearch{
	public static void main(String[] args){
		List<HockeyPlayer> roster = new ArrayList<HockeyPlayer>();
		roster.add(new HockeyPlayer("Holtby", "Goalie", "Canada", true, false, false, false, false));
		roster.add(new HockeyPlayer("Ovechkin", "Forward, LW", "Russia", false, false, true, false, true));
		roster.add(new HockeyPlayer("Kuznetsov", "Forward, C", "Russia", false, false, true, true, false));
		roster.add(new HockeyPlayer("Vrana", "Forward, LW", "Czech Republic", false, false, true, true, false));
		roster.add(new HockeyPlayer("Gersich", "Forward, LW", "USA", false, false, true, false, true));
		roster.add(new HockeyPlayer("Walker", "Forward, LW", "Wales", false, false, true, true, false));
		roster.add(new HockeyPlayer("Burakovsky", "Forward, LW", "Austria", false, false, true, true, false));
		roster.add(new HockeyPlayer("Backstrom", "Forward, C", "Sweden", false, false, true, true, false));
		roster.add(new HockeyPlayer("Graovac", "Forward, C", "Canada", false, false, true, true, false));
		roster.add(new HockeyPlayer("Boyd", "Forward, C", "USA", false, false, true, false, true));
		roster.add(new HockeyPlayer("O'Brien", "Forward, C", "Canada", false, false, true, true, false));
		roster.add(new HockeyPlayer("Eller", "Forward, C", "Denmark", false, false, true, true, false));
		roster.add(new HockeyPlayer("Stephenson", "Forward, C", "Canada", false, false, true, true, false));
		roster.add(new HockeyPlayer("Beagle", "Forward, C", "Canada", false, false, true, false, true));
		roster.add(new HockeyPlayer("Oshie", "Forward, RW", "USA", false, false, true, false, true));
		roster.add(new HockeyPlayer("Wilson", "Forward, RW", "Canada", false, false, true, false, true));
		roster.add(new HockeyPlayer("Connolly", "Forward, RW", "Canada", false, false, true, false, true));
		roster.add(new HockeyPlayer("Peluso", "Forward, RW", "Canada", false, false, true, false, true));
		roster.add(new HockeyPlayer("Smith-Pelly", "Forward, RW", "Canada", false, false, true, false, true));
		roster.add(new HockeyPlayer("Chiasson", "Forward, RW", "Canada", false, false, true, false, true));
		roster.add(new HockeyPlayer("Carlson", "Defense", "USA", false, true, false, false, true));
		roster.add(new HockeyPlayer("Orlov", "Defense", "Russia", false, true, false, true, false));
		roster.add(new HockeyPlayer("Niskanen", "Defense", "USA", false, true, false, false, true));
		roster.add(new HockeyPlayer("Djoos", "Defense", "Sweden", false, true, false, true, false));
		roster.add(new HockeyPlayer("Bowey", "Defense", "Canada", false, true, false, false, true));
		roster.add(new HockeyPlayer("Orpik", "Defense", "USA", false, true, false, true, false));
		roster.add(new HockeyPlayer("Chorney", "Defense", "Canada", false, true, false, true, false));
		roster.add(new HockeyPlayer("Jerabek", "Defense", "Czech Republic", false, true, false, true, false));
		roster.add(new HockeyPlayer("Kempny", "Defense", "Czech Republic", false, true, false, true, false));
		roster.add(new HockeyPlayer("Ness", "Defense", "USA", false, true, false, true, false));
		roster.add(new HockeyPlayer("Grubauer", "Goalie", "Germany", true, false, false, false, false));	
		
		System.out.println("\n********************************************************************");
		System.out.println("2017 - 2018 Regular Season Roster:\n");
		
		for(HockeyPlayer h : roster){
			if(h.isForward())
				System.out.println(h.rosterOutput());	
		}
		for(HockeyPlayer h : roster){
			if(h.isDefense())
				System.out.println(h.rosterOutput());
		}
		for(HockeyPlayer h : roster){
			if(h.isGoalie())
				System.out.println(h.rosterOutput());
		}
		
		System.out.println("\n********************************************************************");
		
		System.out.print("Forwards: ");
		print (roster, h -> h.isForward());
		System.out.print("Defense: ");
		print (roster, h -> h.isDefense());
		System.out.print("Goalies: ");
		print (roster, h -> h.isGoalie());
	
		System.out.println("\n********************************************************************");
		
		System.out.print("Born in Russia: ");
		print (roster, h -> h.isBornHere("Russia"));
		System.out.print("Born in Czech Republic: ");
		print (roster, h -> h.isBornHere("Czech Republic"));
		System.out.print("Born in USA: ");
		print (roster, h -> h.isBornHere("USA"));
		System.out.print("Born in Canada: ");
		print (roster, h -> h.isBornHere("Canada"));
		
		System.out.println("\n********************************************************************");
		System.out.print("Shoots Left: ");
		print (roster, h -> h.isLeftShot());
		System.out.print("Shoots Right: ");
		print (roster, h -> h.isRightShot());
	}
	
	private static void print(List<HockeyPlayer> roster, Predicate<HockeyPlayer> predicate){
		for(HockeyPlayer player : roster){
			if(predicate.test(player)){
				System.out.print(player +  ", " );
			}
		}
		System.out.println();
	}
}
