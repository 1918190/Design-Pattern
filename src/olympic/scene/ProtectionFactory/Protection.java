package olympic.scene.ProtectionFactory;

/**
 * 设计模式：简单工厂模式
 * 防疫品类
 */
public abstract class Protection{
    protected ProtectionFactory factory;
    /**
     * 设计模式：简单工厂模式
     * 获取防疫品
     * @param num
     */
    public abstract void get(int num);//策略方法，带获取的参数
    /**
     * 设计模式：单例模式
     * 设置防疫品生产的工厂
     * @param factory
     */
    public void setFactory(ProtectionFactory factory)
    {
        this.factory = factory;
    }
}
