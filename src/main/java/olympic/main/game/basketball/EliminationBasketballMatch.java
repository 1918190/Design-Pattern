package olympic.main.game.basketball;

import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.Random;

/**
 * 淘汰赛
 */
public class EliminationBasketballMatch extends BasketballMatch {
    private int penaltyScore1, penaltyScore2;

    public EliminationBasketballMatch(BasketballTeam team1, BasketballTeam team2) {
        super(team1, team2);
    }

    /**
     * 随机生成比赛结果
     * 若90分钟内为平局，则进行加时赛；若仍为平局，则互射点球决胜
     */
    @Override
    public void generateResult() {
        Random r = new Random();
        score1 = r.nextInt(5);
        score2 = r.nextInt(5);
        if (score1 == score2) {
            System.out.println("90分钟内双方打平，比分为" + score1 + "-" + score2);
            System.out.println("进入加时赛");
            score1 += r.nextInt(3);
            score2 += r.nextInt(3);
            if (score1 == score2) {
                System.out.println("120分钟内双方打平，比分为" + score1 + "-" + score2);
                System.out.println("进入点球决胜阶段");
                while (penaltyScore1 == penaltyScore2) {
                    penaltyScore1 += r.nextInt(5);
                    penaltyScore2 += r.nextInt(5);
                }
                System.out.println("比赛结束，点球比分为" + penaltyScore1 + "-" + penaltyScore2);
            } else {
                System.out.println("比赛结束，比分为" + score1 + "-" + score2);
            }
        } else {
            System.out.println("比赛结束，比分为" + score1 + "-" + score2);
        }
    }

    /**
     * 设置观察者
     *
     * @param o 观察者
     */
    public void setObserver(Observer o) {
        this.observer = o;
    }

    /**
     * 获取球队1的点球得分
     * @return
     */
    public int getPenaltyScore1() {
        return penaltyScore1;
    }

    /**
     * 获取球队2的点球得分
     * @return
     */
    public int getPenaltyScore2() {
        return penaltyScore2;
    }
}
