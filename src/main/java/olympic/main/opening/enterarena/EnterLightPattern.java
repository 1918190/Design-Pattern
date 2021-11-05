package olympic.main.opening.enterarena;


import olympic.main.person.PersonFactory;
import olympic.main.person.athlete.TeamAthlete;

/**
 * 入场以及传递圣火
 *
 */

public class EnterLightPattern {
    public static void main(String[] args) {
        EnterManager enterManager = EnterManager.getInstance();
        TeamAthlete torchBarer = new TeamAthlete("火炬传递队");

        String[] country = PersonFactory.getInstance().getNations().toArray(new String[0]);

        for (int i = 0; i < 10; i++) {
            int ran = (int) (Math.random() * (47 + 1));

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

    }
}
