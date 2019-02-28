package cn.itheima.proxy.play;

import cn.itheima.proxy.actor.Actor;
import cn.itheima.proxy.actor.impl.ActionActor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这是剧组
 */
public class Play {

    public static void main(String[] args) {

        /**
         * 1.剧组直接找到演员开始表演
         */
        // 创建演员对象
        /*Actor actor = new ActionActor();

        // 基本表演
        actor.basicAct(2000f);

        // 高难度表演
        actor.difficultyAct(5000f);*/

        /**
         * 2剧组通过经纪人，找到演员开始表演
         * 实现方式：使用jdk提供的动态代理
         *
         * 涉及到的类：Proxy
         * 涉及得的方法：newProxyInstance()
         * 涉及到的参数：
         *      Classloader：类加载器。（固定写法，不需要关心）
         *      Interfaces：实现的接口列表。（与被代理对象实现相同的接口。不需要关心）
         *      InvocationHandler：如何代理，实现增强功能的地方。
         */
        // 创建目标对象（演员）
        // 匿名内部类访问局部变量，局部变量必须使用final修饰
        final Actor actor = new ActionActor();

        // 创建代理对象（经纪人）
        Actor proxy = (Actor)Proxy.newProxyInstance(
                actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(),

                new InvocationHandler() {
                    /**
                     *回调方法：invoke
                     * 参数：
                     *      proxy：代理对象的引用（不需要关心）
                     *      method：当前执行的方法对象
                     *      args：当前执行的方法的参数列表
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 1.剧组与经纪人联系
                        // 1.1.明确演出需求
                        String methodName = method.getName();
                        // 1.2.明确演出费用
                        Float money = (Float)args[0];

                        // 2.经纪人与演员联系
                        // 是基本表演吗？是高难度表演吗？给多少钱呢？
                        System.out.println("经纪人正在给演员打电话......");

                        // 基本表演，要求5000块钱
                        Object retV = null;
                        if("basicAct".equals(methodName)){
                            if(money >=5000f){
                                System.out.println("剧组钱给到位了，演员收下这个剧本。");

                                // 开始表演
                                 retV = method.invoke(actor, money * 4 / 5);
                            }else{
                                System.out.println("不好意思，最近档期比较满.");
                            }
                        }

                        // 高难度表演。要求10000块
                        if("difficultyAct".equals(methodName)){
                            if(money >=10000f){
                                System.out.println("剧组钱给到位了，演员收下这个剧本。");

                                // 开始表演
                                // actor.difficultyAct(money);
                                retV = method.invoke(actor, money * 4 / 5);
                            }else{
                                System.out.println("高难度表演有生命危险，钱给的太少了。");
                            }
                        }


                        return retV;
                    }
                }
        );

        // 代理对象代替演员开始表演
        // 基本表演
        proxy.basicAct(5000f);

        System.out.println("------------------华丽丽分割线---------------------");

        // 高难度表演
        proxy.difficultyAct(10000f);
    }
}
