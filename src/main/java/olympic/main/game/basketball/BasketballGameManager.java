package olympic.main.game.basketball;

import olympic.Utils.PrintBlockFormat;
import olympic.main.game.AbstractPipeline;
import olympic.main.game.Valve;
import olympic.main.game.basketball.round.Round;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton模式
 * Pipeline模式
 */
public class BasketballGameManager implements AbstractPipeline {
    private static BasketballGameManager singleton = new BasketballGameManager();
    private ArrayList<Athlete> topThreeAthletes = new ArrayList<>();
    public static BasketballGameManager getInstance() {
        return singleton;
    }

    private BasketballGameManager() {
    }

    private List<BasketballTeam> teams = new ArrayList<>();
    private Round first = null;   // 第一段管道

    public Round getFirst() {
        return this.first;
    }

    public Round setFirst(Round first) {
        this.first = first;
        return this.first;
    }

    /**
     * 传入所有参赛球队
     *
     * @param teams 所有参赛球队的列表
     */
    public void setTeams(List<Athlete> teams) {
        for (int i = 0; i < 12; ++i) {
            this.teams.add((BasketballTeam) (teams.get(i)));
        }
    }

    /**
     * 向管道末尾添加比赛
     * @param newGame
     */
    @Override
    public void addContest(Valve newGame) {
        Round r = this.first;
        while (r.getNext() != null) {
            r = r.getNext();
        }
        r.setNext(newGame);
    }

    /**
     * 依次进行所有轮次的比赛
     */
    public void start() {
        System.out.println("\nclassname: (BasketballGameManager) method: (play) action: (进行篮球比赛，使用了Pipeline模式以及Singleton模式) ");
        Round r = this.first;
        List<BasketballTeam> advancedTeams = teams;
        for (int i = 0; i < advancedTeams.size(); ++i) {
            advancedTeams.get(i).setRank("BasketballTeam", 12);
        }
        int rank = 8;
        while (r != null) {
            // 为每支球队写入排名，晋级后更新排名
            r.setTeams(advancedTeams);
            r.start();
            advancedTeams = r.getAdvancedTeams();
            for (int i = 0; i < advancedTeams.size(); ++i) {
                advancedTeams.get(i).setRank("BasketballTeam", rank);
            }
            rank /= 2;
            r = r.getNext();
        }

        advancedTeams.get(0).setRank("BasketballTeam", 1);

        topThreeAthletes.add(null);
        topThreeAthletes.add(null);
        topThreeAthletes.add(null);

        ArrayList<BasketballTeam> tmp = new ArrayList<>();  // 需要打季军赛的2支球队

        for (int i = 0; i < teams.size(); ++i) {
            int k = teams.get(i).getRank("BasketballTeam");
            if (k == 4) {
                tmp.add(teams.get(i));
            } else if (k < 4) {
                topThreeAthletes.set(k - 1, teams.get(i));
            }
        }

        // 季军赛
        PrintBlockFormat.getPrintFormat().addString("季军赛");
        BasketballMatch thirdPlaceGame = new BasketballMatch(tmp.get(0), tmp.get(1));
        thirdPlaceGame.play();
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

        if (thirdPlaceGame.getScore1() > thirdPlaceGame.getScore2()) {
            thirdPlaceGame.getTeam1().setRank("BasketballTeam", 3);
            topThreeAthletes.set(2, thirdPlaceGame.getTeam1());
        } else {
            thirdPlaceGame.getTeam2().setRank("BasketballTeam", 3);
            topThreeAthletes.set(2, thirdPlaceGame.getTeam2());
        }
    }

    public ArrayList<Athlete> getTopThreeAthletes() {
        return topThreeAthletes;
    }
}
