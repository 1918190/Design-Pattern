package olympic.main.person.personVisitor.VisitFilterChain;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;
import olympic.main.person.personVisitor.FilterVisitor;
import olympic.main.person.personVisitor.NovelCoronavirusFilterVisitor;
import olympic.main.person.personVisitor.UrineFilterVisitor;

import java.util.ArrayList;

/**
 * 过滤器的管理类，管理过滤器和过滤器链
 * 是过滤器模式的一部分
 */
public class FilterManager {
	/**
	 * 过滤链
	 */
	FilterChain filterChain = new FilterChain();
	
	/**
	 * 过滤器的管理类的构造函数。初始化时过滤链中存在两个过滤器，
	 * 分别为新冠病毒过滤器以及尿检过滤器
	 */
	public FilterManager() {
		filterChain.addFilter(new NovelCoronavirusFilterVisitor());
		filterChain.addFilter(new UrineFilterVisitor());
	}
	
	/**
	 * 往过滤链中添加过滤器
	 *
	 * @param filterVisitor 被添加的过滤器
	 */
	public void addFilter(FilterVisitor filterVisitor) {
		filterChain.addFilter(filterVisitor);
	}
	
	/**
	 * 个人运动员列表类的访问函数，用于按照过滤链对个人运动员列表做过滤
	 *
	 * @param individualAthleteList 个人运动员列表类
	 * @param gameName              比赛名
	 * @return 过滤结束以后的个人运动员数组
	 */
	public ArrayList<IndividualAthlete> visit(IndividualAthleteList individualAthleteList, String gameName) {
		return filterChain.visit(individualAthleteList, gameName);
	}
	
	/**
	 * 运动员队伍列表类的访问函数，用于按照过滤链对运动员队伍做过滤
	 *
	 * @param teamAthleteList 运动员队伍列表类
	 * @param gameName        比赛名
	 * @return 过滤结束以后的运动员队伍数组
	 */
	public ArrayList<TeamAthlete> visit(TeamAthleteList teamAthleteList, String gameName) {
		return filterChain.visit(teamAthleteList, gameName);
	}
}