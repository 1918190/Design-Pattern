package olympic.main.person.athlete.badminton;

import olympic.main.director.Mode;
import olympic.main.person.athlete.CallBack;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.Strategy;
import olympic.main.person.athlete.badminton.Strategy.BadmintonDefendStrategy;
import olympic.main.person.athlete.badminton.Strategy.BadmintonOffenseStrategy;

import java.util.Random;

public class BadmintonAthlete extends IndividualAthlete implements PlayBadminton {
    public BadmintonAthlete(String name, String nation) {
        super(name, nation);
        if (random.nextInt() % 2 == 0) {
            this.strategy = new BadmintonOffenseStrategy();
            strategy.setOwnerAthlete(this);
        } else {
            this.strategy = new BadmintonDefendStrategy();
            strategy.setOwnerAthlete(this);
        }
        if (nation == "CHN") {
            capacity = 99;
        } else {
            capacity = random.nextInt(8) + 90;
        }
    }

    /**
     * 随机数用于模拟一些概率
     */
    private Random random = new Random();

    /**
     * 运动员的实力
     * 范围0-99，数越大能力越强，实力与接球概率有关
     */
    private Integer capacity;

    /**
     * 运动员采用的比赛策略
     */
    private Strategy strategy;

    @Override
    public Integer getCapacity() {
        return capacity;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 与Oppoend进行对打
     *
     * @param oppoent 对手
     * @return 是否击中球，没有击中球就输了这一小轮
     */
    @Override
    public Boolean playWith(CallBack oppoent) {
        return strategy.playWith(oppoent);
    }

    /**
     * 发球
     */
    @Override
    public void serve() {
        if (Mode.getShowDetail()) {
            System.out.println(this.getName() + " 发乒乓球");
        }
    }

    /**
     * 回调函数，用于对打
     *
     * @param oppoent
     * @return 是否击中球，没有击中球就输了这一小轮
     */
    @Override
    public Boolean call(CallBack oppoent) {
        if (Mode.getShowDetail()) {
            System.out.println("classname: (PingpongAthlete) method: (call) action: (回调模式中选手运用回调函数进行对打) ");
        }
        return this.playWith((BadmintonAthlete) oppoent);
    }
}