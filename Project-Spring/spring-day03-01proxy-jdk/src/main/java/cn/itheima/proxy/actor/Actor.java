package cn.itheima.proxy.actor;

/**
 * 演员接口
 */
public interface Actor {

    /**
     * 基本表演
     */
    void basicAct(Float money);

    /**
     * 高难度表演
     */
    void difficultyAct(Float money);

    /**
     * 演员名称
     */
    String getActName();
}
