package cn.itheima.proxy.actor;

/**
 * 这是一个表演艺术家
 */
public class ArtActor {

    /**
     * 基本表演
     */
    public void basicAct(Float money){
        System.out.println("演员【"+getActName()+"】收到钱："+money+",开始基本表演。");
    }

    /**
     * 高难度表演
     */
    public void difficultyAct(Float money){
        System.out.println("演员【"+getActName()+"】收到钱："+money+",开始高难度表演。");
    }

    /**
     * 演员名称
     */
    public String getActName(){
        return "小花";
    }
}
