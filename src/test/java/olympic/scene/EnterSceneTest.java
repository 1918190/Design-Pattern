package olympic.scene;

import olympic.main.opening.enterarena.EnterIterator;
import olympic.main.opening.enterarena.EnterManager;
import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.TeamAthlete;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@DisplayName("入场仪式场景")
class EnterSceneTest {
    /**
     * 测试EnterScene.play()方法
     */

    @Test
    void testPlay() {
        EnterManager enterManager = EnterManager.getInstance();
        TeamAthlete torchBarer = new TeamAthlete("火炬传递队");

        String[] country;
        country = PersonFactory.getInstance().getNations().toArray(new String[0]);


        for (int i = 0; i < 10; i++) {
//            int ran= 0+(int)(Math.random()*(country.length-1+1));
            int ran = new Random().nextInt(country.length);

            TeamAthlete tempList = new TeamAthlete(PersonFactory.getInstance().getAthleteByNation(country[ran]), country[ran]);
            if (tempList.getNumber() > 0) {
                enterManager.setTeams(tempList);
                torchBarer.addMember(tempList.getFirstAthlete());
            }

        }

        EnterIterator et = enterManager.iterator();
        while (et.hasNext()) {
            TeamAthlete myList = et.next();
            System.out.println("现在向我们走来的是" + myList.getNation() + "队，让我们欢迎他们！");
        }
        System.out.println('\n');
        torchBarer.passFire();
        System.out.println("最后一位使者点燃了奥运圣火！");

        EnterScene enterScene = new EnterScene();
        enterScene.play();

    }
}
