package cn.itcast.proxy.actor.impl;

import cn.itcast.proxy.actor.Actor;

public class Actionactor implements Actor {

    @Override
    public void basicAct(Float money) {

        System.out.println("演员【"+getActName()+"】收到钱："+money+"，开始基本表演。");
    }

    @Override
    public void difficultyAct(Float money) {

        System.out.println("演员【"+getActName()+"】收到钱："+money+"，开始高难度表演。");
    }

    @Override
    public String getActName() {
        return "小明";
    }
}
