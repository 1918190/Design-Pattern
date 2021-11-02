package olympic.main.drawlots;

import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 纸质抽签实现
 */
public class PaperDrawLotsImpl extends DrawLotsImpl {
    /**
     * 抽签开始前输出抽签实现形式，以及参与抽签的运动员或团队（纸质抽签）
     * @param athletes 运动员列表
     */
    @Override
    public void rawDrawLotsStart(List<Athlete> athletes) {
        printSpaces(DrawLotsImpl.START_END_SEPARATOR_LENGTH);
        System.out.println("《纸质抽签开始》");
        printPaperSeparator();
        printSpaces(DrawLotsImpl.BEFORE_SEPARATOR_LENGTH);
        System.out.println("参与抽签的运动员或团队：");
        showBeforeAthletes(athletes);
        System.out.println();
    }

    /**
     * 抽签结束后输出抽签结果，并输出抽签实现形式（纸质抽签）
     * @param athletes  运动员列表
     * @param groupSize 每个小组中的运动员数
     */
    @Override
    public void rawDrawLotsEnd(List<Athlete> athletes, int groupSize) {
        printSpaces(DrawLotsImpl.RESULT_SEPARATOR_LENGTH);
        System.out.println("纸质抽签结果：");
        showAfterAthletes(athletes, groupSize);
        printPaperSeparator();
        printSpaces(DrawLotsImpl.START_END_SEPARATOR_LENGTH);
        System.out.println("《纸质抽签结束》");
    }

    /**
     * 工具函数，输出纸质抽签分割线
     */
    private void printPaperSeparator() {
        for (int i = 0; i < DrawLotsImpl.SEPARATOR_LENGTH; i++) {
            System.out.print('=');
        }
        System.out.println();
    }
}
