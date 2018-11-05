import java.util.*;
import java.util.function.*;

class HockeyPlayer{
	private String lastName;
	private String position;
	private String birthplace;
	private String shoots;
	private int[] stats;
		
	public HockeyPlayer(String lastName, String position, String birthplace, String shoots, int... stats){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
		this.shoots = shoots;
		this.stats = stats;
	}

	public boolean isPosition(String playerPosition){
		if(position.contains(playerPosition)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isShot(String leftRight){
		if(shoots.equals(leftRight)){
			return true;	
		}
		else{
			return false;	
		}
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
	
	public int[] getStats(){
		return stats;	
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Roster{
	private ArrayList<HockeyPlayer> roster;

	public Roster(){
		setRoster();	
	}
	
	public void setRoster(){
		roster = new ArrayList<HockeyPlayer>();
		roster.add(new HockeyPlayer("Holtby", "Goalie", "Canada", "NA", 1648, 153, 1495));
		roster.add(new HockeyPlayer("Ovechkin", "Forward, LW", "Russia", "Right", 49, 38, 87, 3));
		roster.add(new HockeyPlayer("Kuznetsov", "Forward, C", "Russia", "Left", 27, 56, 83, 3));
		roster.add(new HockeyPlayer("Vrana", "Forward, LW", "Czech Republic", "Left", 13, 14, 27, 2));
		roster.add(new HockeyPlayer("Gersich", "Forward, LW", "USA", "Left", 0, 1, 1, -1));
		roster.add(new HockeyPlayer("Walker", "Forward, LW", "Wales", "Left", 1, 0, 1, 1));
		roster.add(new HockeyPlayer("Burakovsky", "Forward, LW", "Austria", "Left", 12, 13, 25, 3));
		roster.add(new HockeyPlayer("Backstrom", "Forward, C", "Sweden", "Left", 21, 50, 71, 5));
		roster.add(new HockeyPlayer("Graovac", "Forward, C", "Canada", "Left", 0, 0, 0, -3));
		roster.add(new HockeyPlayer("Boyd", "Forward, C", "USA", "Right", 0, 1, 1, 2));
		roster.add(new HockeyPlayer("O'Brien", "Forward, C", "Canada", "Left", 0, 0, 0, 0));
		roster.add(new HockeyPlayer("Eller", "Forward, C", "Denmark", "Left", 18, 20, 38, -6));
		roster.add(new HockeyPlayer("Stephenson", "Forward, C", "Canada", "Left", 6, 12, 18, 13));
		roster.add(new HockeyPlayer("Beagle", "Forward, C", "Canada", "Right", 7, 15, 22, 3));
		roster.add(new HockeyPlayer("Oshie", "Forward, RW", "USA", "Right", 18, 29, 47, 2));
		roster.add(new HockeyPlayer("Wilson", "Forward, RW", "Canada", "Right", 14, 21, 35, 10));
		roster.add(new HockeyPlayer("Connolly", "Forward, RW", "Canada", "Right", 15, 12, 27, -6));
		roster.add(new HockeyPlayer("Peluso", "Forward, RW", "Canada", "Right", 0, 0, 0, 0));
		roster.add(new HockeyPlayer("Smith-Pelly", "Forward, RW", "Canada", "Right", 7, 9, 16, -6));
		roster.add(new HockeyPlayer("Chiasson", "Forward, RW", "Canada", "Right", 9, 9, 18, 1));
		roster.add(new HockeyPlayer("Carlson", "Defense", "USA", "Right", 15, 53, 68, 0));
		roster.add(new HockeyPlayer("Orlov", "Defense", "Russia", "Left", 10, 21, 31, 10));
		roster.add(new HockeyPlayer("Niskanen", "Defense", "USA", "Right", 7, 22, 29, 24));
		roster.add(new HockeyPlayer("Djoos", "Defense", "Sweden", "Left", 3, 11, 14, 13));
		roster.add(new HockeyPlayer("Bowey", "Defense", "Canada", "Right", 0, 12, 12, -3));
		roster.add(new HockeyPlayer("Orpik", "Defense", "USA", "Left", 0, 10, 10, -9));
		roster.add(new HockeyPlayer("Chorney", "Defense", "Canada", "Left", 1, 3, 4, 8));
		roster.add(new HockeyPlayer("Jerabek", "Defense", "Czech Republic", "Left", 1, 3, 4, -1));
		roster.add(new HockeyPlayer("Kempny", "Defense", "Czech Republic", "Left", 2, 1, 3, 1));
		roster.add(new HockeyPlayer("Ness", "Defense", "USA", "Left", 0, 1, 1, 2));
		roster.add(new HockeyPlayer("Grubauer", "Goalie", "Germany", "NA", 953, 73, 880));	
	}
	
	public ArrayList<HockeyPlayer> getRoster(){
		return roster;	
	}
	
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class LambdaSearchV2{
	public static void main(String[] args){
		Roster r = new Roster();
		
		System.out.println("\n********************************************************************");
		
		String[] positions = {"Forward, LW", "Forward, C", "Forward, RW", "Defense", "Goalie"};
		printRoster(positions, r.getRoster());
		System.out.println("\n********************************************************************");
		
		String[] p = {"Forward", "Forward, LW", "Forward, C", "Forward, RW", "Defense", "Goalie"};
		printLambdaRoster(p, r.getRoster());
		System.out.println("\n********************************************************************");
		
		String[] birthplaces = {"Russia", "Czech Republic", "USA", "Canada", "Wales", "Austria", "Sweden", "Denmark", "Germany"};
		printLambdaBirthplaces(birthplaces, r.getRoster());
		System.out.println("\n********************************************************************");

		String[] shoots = {"Left", "Right"};
		printLambdaShoots(shoots, r.getRoster());
		System.out.println("\n********************************************************************");
		
		//get a stat of defense
		for(HockeyPlayer player : r.getRoster()){
			if(player.isPosition("Defense")){
				System .out.println(player + "'s Points: " + player.getStats()[2]); 	
			}
		}
		System.out.println("\n********************************************************************");
		
		//get a stat of forwards
		for(HockeyPlayer player : r.getRoster()){
			if(player.isPosition("Forward")){
				System .out.println(player + "'s Goals: " + player.getStats()[0]); 	
			}
		}
		System.out.println("\n********************************************************************");
		
		//get a stat of goalies
		for(HockeyPlayer player : r.getRoster()){
			if(player.isPosition("Goalie")){
				System .out.println(player + "'s Shots Against: " + player.getStats()[0]); 	
			}
		}
		System.out.println("\n********************************************************************");
	}
	
	//print method
	private static void print(List<HockeyPlayer> roster, Predicate<HockeyPlayer> predicate){
		try{
			for(HockeyPlayer player : roster){
				if(predicate.test(player)){
					System.out.print(player +  ", " );
				}
			}
			System.out.println();
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
	
	//method to print roster by position w/out lambda expressions
	public static void printRoster(String[] positions, ArrayList<HockeyPlayer> roster){
		System.out.println("2017 - 2018 Regular Season Roster:\n");
		try{
			for(String position : positions){
				for(HockeyPlayer h : roster){
					if(h.isPosition(position))
						System.out.println(h.rosterOutput());	
				}
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}	
	}
	
	//method to filter roster by position
	public static void printLambdaRoster(String[] positions, ArrayList<HockeyPlayer> roster){
		try{
			for(String position : positions){
				System.out.print(position + ": ");
				print (roster, h -> h.isPosition(position));
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
	
	//method to filter players by country of birth
	public static void printLambdaBirthplaces(String[] bp, ArrayList<HockeyPlayer> roster){
		try{
			for(String country: bp){
				System.out.print("Born in " + country + ":  ");
				print (roster, h -> h.isBornHere(country));
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
	
	//method to filter skaters who shoot left/right
	public static void printLambdaShoots(String[] shoots, ArrayList<HockeyPlayer> roster){
		try{
			for(String shot : shoots){
				System.out.print("Shoots " + shot +":  ");
				print(roster, h -> h.isShot(shot));
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
}