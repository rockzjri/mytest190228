package cn.proxy.test;

import cn.proxy.actor.Actor;
import cn.proxy.impl.ActionActor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PlayJdk {
    public static void main(String[] args) {
        ActionActor actor = new ActionActor();

        Actor proxyaction = (Actor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String methodName = method.getName();
                Float money = (Float) args[0];
                System.out.println("经纪人正在联系演员");

                Object invoke = null;
                if ("basicAct".equals(methodName)) {
                    if (money > 5000 && money <= 10000) {

                        System.out.println("基本表演，剧组钱给到位了。演员收下这个剧本。");
                        invoke = method.invoke(actor, money * 4 / 5);
                    } else {
                        System.out.println("剧组只给了：" + money + "，钱不到位。演员做不了basicAct演出。");
                    }
                }
                if ("difficultyAct".equals(methodName)) {
                    if (money > 10000) {

                        System.out.println("基本表演，剧组钱给到位了。演员收下这个剧本。");
                        invoke = method.invoke(actor, money * 4 / 5);
                    } else {
                        System.out.println("剧组只给了：" + money + "，钱不到位。演员做不了difficultyAct演出。");
                    }

                }

                return invoke;
            }
        });

//        proxyaction.basicAct(5600f);
//        proxyaction.basicAct(40000f);
        System.out.println("========================");

        proxyaction.difficultyAct(5000f);
        proxyaction.difficultyAct(100000);

    }

}
