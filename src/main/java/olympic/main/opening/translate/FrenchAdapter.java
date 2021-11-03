package olympic.main.opening.translate;

public class FrenchAdapter implements Translator {
    private Speaker speaker;

    public FrenchAdapter(Speaker speaker) {
        this.speaker = speaker;
    }

    /**
     * 设计模式：适配器模式
     * 接口重写为法语翻译
     */
    @Override
    public void translate() {
        String result = speaker.speak();
        String frenchResult = "主持人说话内容为：Bienvenue aux Jeux olympiques!";
        System.out.println(frenchResult);
    }
}
