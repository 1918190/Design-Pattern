package olympic.main.director;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Director.getInstance().nextScene(() -> System.out.println("奥林匹克运动会开始了！"));

        /**
         * 可以把这行注释掉测试自己的东西
         */
        Director.getInstance().start();

        //FootballStarter.start();

//        Scene divingGame=new DivingGameScene("单人三米");
//        divingGame.play();
//        new FootballScene().play();
//        new ChoreHandlingScene().play();
//        new TrackGameScene("Marathon").play();
//new TrackGameScene("Sprints").play();
//        new TrackGameScene("Hurdling").play();
//        new TrackGameScene("Relays").play();
//        new PingpongGameScene().play();
//        new ReviewQScene().play();
//          new ChoreHandlingScene().play();

        if (Mode.getNeedDetail()){
            //允许输入
        }else{
            //不允许输入
        }

    }
}