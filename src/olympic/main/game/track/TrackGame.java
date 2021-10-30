package olympic.main.game.track;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 使用template method设计模式
 * TrackGame是田径比赛的径赛
 */
public abstract class TrackGame extends Game{

    public TrackGame(List<Athlete> athletes) {
        super();
        this.athletes = athletes;
    }




}