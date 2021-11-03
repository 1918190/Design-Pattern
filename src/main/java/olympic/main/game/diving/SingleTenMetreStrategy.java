package olympic.main.game.diving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 策略模式中单人十米台规则
 */
public class SingleTenMetreStrategy extends Strategy {

    SingleTenMetreStrategy() {
        name = "跳水单人十米跳台";
        scores = new ArrayList<>();
        cycleNumber = 6;
        showStrategy("SingleTenMetreStrategy");
    }

    /**
     * 通过当前策略来决定分数的算法
     *
     * @return score 返回算出的分数
     */
    @Override
    public double decideScore() {
        Random r = new Random();
        for (int i = 0; i < 7; i++) {
            scores.add(r.nextInt(20) * 0.5);
        }
        double difficulty = r.nextInt(40) / 10.0;
        Collections.sort(scores);
        double score = (scores.get(2) + scores.get(3) + scores.get(4)) * difficulty;
        scores.clear();
        return score;
    }

    /**
     * 获取该策略下一场比赛要进行的轮次
     *
     * @return cycleNumber 要进行的轮次
     */
    @Override
    public int getCycleNumber() {
        return this.cycleNumber;
    }
}