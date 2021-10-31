package olympic.main.person.personVisitor;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

public class NovelCoronavirusFilterVisitor extends FilterVisitor{
	@Override
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList
			, String game) {
		ArrayList<IndividualAthlete> finalAthleteList = new ArrayList<>();
		System.out.println("	^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		int count = 0;
		for (IndividualAthlete athlete : individualAthleteList.getAthletes()) {
			if (!athlete.getIsNovelCoronavirus()) {
				finalAthleteList.add(athlete);
			}
			else {
				System.out.println("	^ 运动员" + athlete.getName() + "被检测出了新冠病毒，取消此次比赛资格。");
				count+=1;
				athlete.setRank(game,-1);
			}
		}
		if(count==0)
		{
			System.out.println("	^ 所有运动员均未感染新冠病毒");
		}
		else
		{
			System.out.println("	^ 共有"+count+"位运动员感染了新冠病毒，被取消了比赛资格");
		}
		System.out.println("	^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return finalAthleteList;
	}
	
	@Override
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String game) {
		ArrayList<TeamAthlete> finalTeam = new ArrayList<>();
		System.out.println("	^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		int count = 0;
		for (TeamAthlete team : teamAthleteList.getAthletes()) {
			System.out.println("	^ 现在接受检查的队伍来自" + team.getNation()+"，队伍名为"+team.getName());
			boolean flag = true;
			for (Athlete athlete : team.getAthleteList()) {
				
				if (((IndividualAthlete)athlete).getIsNovelCoronavirus()) {
					flag = false;
					athlete.setRank(game,-1);
				}
			}
			if (flag) {
				finalTeam.add(team);
				System.out.println("	^ 所有队员均未感染新冠病毒");
			} else {
				System.out.println("	^ 队伍中有人感染新冠病毒，该队伍参赛资格作废");
				count += 1;
			}
			System.out.println();
		}
		if(count==0)
		{
			System.out.println("	^ 所有队伍均未感染新冠病毒");
		}
		else
		{
			System.out.println("	^ 共有"+count+"个队伍感染了新冠病，被取消了比赛资格毒");
		}
		System.out.println("	^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return finalTeam;
	}
	
	@Override
	public String getFilterName() {
		return "	【1. 现在进行运动员新冠病毒的检测】";
	}
}
