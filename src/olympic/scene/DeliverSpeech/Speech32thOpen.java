package olympic.scene.DeliverSpeech;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.PersonFactory;

public class Speech32thOpen extends DeliverSpeech {  //具体子类
    @Override
    String time() {
        return "32";
    }

//    @Override
//    String OOCP() {
//        return "武藤敏郎";
//    }
//
//    @Override
//    String IOCP() {
//        return "托马斯·巴赫";
//    }
//
//    @Override
//    String HP() {
//        return "岸田文雄";
//    }
    /**
     * 设置其为开幕式
     */
    @Override
    public boolean isOpen() {
        return true;
    }
//
//    @Override
//    String athleteRepre() {
//        return "苏炳添";
//    }
//
//    @Override
//    String refereeRepre() {
//        return "Amazon";
//    }

//    public Chairman OOCP = getObject("武藤敏郎") ;
//    public Chairman IOCP = getObject("武藤敏郎") ;
//    public Chairman HP = getObject("武藤敏郎") ;
//    public Athlete athleteRepre = getAthleteByName("苏炳添");
//    public refereeRepre coachRepre = getObject("Amazon");

}
