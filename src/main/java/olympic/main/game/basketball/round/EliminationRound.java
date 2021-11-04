package olympic.main.game.basketball.round;

import olympic.main.game.basketball.ScheduleIterator;
import olympic.main.game.basketball.EliminationBasketballMatch;
import olympic.main.game.basketball.BasketballMatch;
import olympic.main.game.basketball.Observer;
import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * 淘汰赛的一轮
 */
public class EliminationRound extends Round implements Observer {
    private String name = null;

    public EliminationRound(String name) {
        this.name = name;
    }

    /**
     * 进行本轮所有比赛
     */
    @Override
    public void start() {
        advancedTeams.clear();
        System.out.println("classname: (EliminationRound) method: (play) action: (进行足球淘汰赛) ");
        for (int i = 0; i < teams.size(); i += 2) {
            EliminationBasketballMatch g = new EliminationBasketballMatch(teams.get(i), teams.get(i + 1));
            g.setObserver(this);
            schedule.addMatch(g);
        }

        if (name != null) {
            System.out.println("\n【" + name + "】");
        }

        ScheduleIterator it = schedule.iterator();
        while (it.hasNext()) {
            it.next().play();
        }
    }

    /**
     * 根据比赛结果更新晋级名单
     *
     * @param game 结束的比赛
     */
    @Override
    public void update(BasketballMatch game) {
        EliminationBasketballMatch e = (EliminationBasketballMatch) game;
        if (e.getScore1() > e.getScore2()) {
            advancedTeams.add(e.getTeam1());
        } else if (e.getScore1() < e.getScore2()) {
            advancedTeams.add(e.getTeam2());
        } else if (e.getPenaltyScore1() > e.getPenaltyScore2()) {
            advancedTeams.add(e.getTeam1());
        } else {
            advancedTeams.add(e.getTeam2());
        }
    }

}
