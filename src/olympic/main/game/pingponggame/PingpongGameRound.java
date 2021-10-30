package olympic.main.game.pingponggame;


import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.PlayPingpong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class PingpongGameRound {

    private String name;

    private HashMap<Athlete, Integer> result = new HashMap<>();

    private Game nextGame;

    private void startOneRound( ) {
        List<Athlete> athletes = new ArrayList<>(result.keySet());
        if (Mode.getShowDetail()) {
            System.out.println(athletes.get(0).getName() + " vs " + athletes.get(1).getName());
            System.out.println("===========================================");
        }
        //可以添加决定发球的方式（如抽签）
        Integer server = new Random().nextInt(2);
        ((PlayPingpong)athletes.get(server)).serve();
        Boolean win = ((PlayPingpong)athletes.get((server + 1) % 2)).playWith(athletes.get(server));
        Integer winner = (win ? ((server + 1) % 2) : server);
        if (Mode.getShowDetail()) {
            System.out.println("本轮结束," + athletes.get(winner).getName() + "赢了");
        }
//        result.get(athletes.get(winner)) = result.get(winner) + 1;
        result.replace(athletes.get(winner), result.get(athletes.get(winner)) + 1);
    }


    public void addAthlete(Athlete athlete) {
        result.put(athlete, 0);
    }

    public void setNextGame(Game nextGame) {
        this.nextGame = nextGame;
    }

    public String getName() {
        return name;
    }

    public Athlete start() {
        System.out.println("classname: (PingpongCame) method: (start) action: (乒乓球比赛一局开始) ");
        while (Math.max((Integer) result.values().toArray()[0], (Integer) result.values().toArray()[1]) < 11 || Math.abs((Integer) result.values().toArray()[0] - (Integer) result.values().toArray()[1]) < 2) {
            startOneRound();
        }
        if ((Integer) result.values().toArray()[0] > (Integer) result.values().toArray()[1]) {
            return (Athlete) result.keySet().toArray()[0];
        } else {
            return (Athlete) result.keySet().toArray()[1];
        }
    }
}

