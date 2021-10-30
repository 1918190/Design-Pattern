package olympic.main.game.football;

import olympic.main.game.football.round.EliminationRound;
import olympic.main.game.football.round.GroupRound;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;

/**
 * 足球比赛启动器
 * 调用start方法进行所有比赛
 */
public class FootballStarter {

    public static void start() {
        FootballGameManager footballGameManager = FootballGameManager.getInstance();
        ArrayList<FootballTeam> teamList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            teamList.add(new FootballTeam("Team" + i, "Nation" + i, new ArrayList<Athlete>()));
        }
        // TODO: 替换为从配置文件中读入参赛球队
        footballGameManager.setTeams(teamList);
        footballGameManager.setFirst(new GroupRound()).setNext(new EliminationRound("四分之一决赛")).setNext(new EliminationRound("半决赛")).setNext(new EliminationRound("决赛"));
        footballGameManager.start();
    }
}
