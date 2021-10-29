package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.Collections;
import java.util.List;

/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * SemiFinals是半决赛
 */
public class SemiFinals  extends ContestImpl{
    SemiFinals(List<Athlete> athletes) {
        super(athletes);
        gameType="半决赛";
    }

    /**
     * 对场上的运动员成绩做一个比较
     * @param runners 比赛场上运动员们
     * @param group 第几场小组赛
     */
    private void rank(List<Athlete> runners,int group){
//        System.out.println("现在上场的运动员有：");
        int size=runners.size();
//        for(Athlete temp : runners){
//            System.out.print("目前没有他的名字"+temp+" ");
//        }
        System.out.println("【半决赛赛排名榜】");
        System.out.println("Group "+(group+1)+"\n" +
                "排名\t姓名\t时间\t晋级");
        Collections.shuffle(runners);
        for(int i=0;i<size;i++){

            if(i>=4){
                System.out.println(i+1+"\t"+"姓名"+"\t"+"时间"+"\t"+"否");
            }else{
                System.out.println(i+1+"\t"+"姓名"+"\t"+"时间"+"\t"+"是");
            }
        }
        System.out.println("\n");
    }

    /**
     * 得到初赛的成果
     */
    public  void getResult(){
        List<List<Athlete>> runners=group();
        int size=runners.size();
        System.out.println(gameType+"一共有"+size+"场");
        for(int i=0;i<size;i++){
            System.out.println("第"+(i+1)+"场开始了");
            rank(runners.get(i),i);
        }

    }
}