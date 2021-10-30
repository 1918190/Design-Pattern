package olympic.main.person.athleteList;

import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.personVisitor.Visitor;

import java.util.ArrayList;

public class TeamAthleteList implements AthleteList {
	
	private ArrayList<TeamAthlete> athletes = null;
	
	public TeamAthleteList(ArrayList<TeamAthlete> athletes){
		this.athletes = athletes;
	}
	
	@Override
	public void accept(Visitor v) {
		
		v.visit(this);
	}
	
	public ArrayList<TeamAthlete> getAthletes() {
		return athletes;
	}
}
