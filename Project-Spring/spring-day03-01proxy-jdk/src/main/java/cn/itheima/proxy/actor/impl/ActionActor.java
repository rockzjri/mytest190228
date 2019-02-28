package cn.itheima.proxy.actor.impl;

import cn.itheima.proxy.actor.Actor;

/**
 * 这是一个动作演员
 */
public class ActionActor  implements Actor{
    /**
     * 基本表演
     *
     * @param money
     */
    public void basicAct(Float money) {
        System.out.println("演员【"+getActName()+"】,收到钱："+money+"，开始基本表演。");
    }

    /**
     * 高难度表演
     *
     * @param money
     */
    public void difficultyAct(Float money) {
        System.out.println("演员【"+getActName()+"】,收到钱："+money+"，开始高难度表演。");
    }

    /**
     * 演员名称
     */
    public String getActName() {
        return "小明";
    }
}
