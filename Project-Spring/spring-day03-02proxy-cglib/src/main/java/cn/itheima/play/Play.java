package cn.itheima.play;

import cn.itheima.proxy.actor.ArtActor;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 这里是剧组
 */
public class Play {

    public static void main(String[] args) {
        /**
         * 1.剧组直接找到演员开始表演
         */
     /*   ArtActor actor = new ArtActor();

        // 开始基本表演
        actor.basicAct(2000f);

        // 开始高难度表演
        actor.difficultyAct(5000f);*/

        /**
         * 2.剧组通过经纪人，找到演员开始表演
         * 实现方式：使用第三方的cglib
         * 涉及到的类：
         *          EnHancer
         * 涉及到的方法：
         *          create()
         * 参数列表：
         *         CLass：被代理类的字节码
         *         Callback：回调参数，实现增强的地方，如何代理。相当于jdk中的InvocationHandler
         *
         */
        // 创建目标对象（演员）
        final ArtActor actor = new ArtActor();

        // 创建代理对象（经纪人）
       // Callback back = null;
        ArtActor proxy = (ArtActor)Enhancer.create(
                actor.getClass(),

                new MethodInterceptor() {

                    /**
                     *回调方法：intercept。相当于jdk中的invoke
                     * 参数：
                     *      proxy：代理对象的引用（不需要关心）
                     *      method：当前执行的方法对象
                     *      args：当前执行的方法的参数列表
                     *      methodProxy:当前方法对象的代理引用（不需要关心）
                     */
                    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                        // 1.剧组与经纪人联系
                        // 1.1.明确演出需求
                        String methodName = method.getName();
                        // 1.2.明确出场费用
                        Float money = (Float)args[0];


                        // 2.经纪人与演员联系
                        // 是基本表演吗？是高难度表演吗？给多少钱呢？
                        System.out.println("经纪人正在给演员打电话联系......");

                        // 基本表演。要求5000块钱
                        Object retV = null;
                        if("basicAct".equals(methodName)){
                            if(money >=5000f){
                                System.out.println("剧组钱给到位了，演员收下该剧本。");

                                // 开始表演
                                 retV = method.invoke(actor, money * 4 / 5);
                            }else {
                                System.out.println("不好意思，最近档期太满了。");
                            }
                        }

                        // 高难度表演。要求8000块钱
                        if("difficultyAct".equals(methodName)){
                            if(money >=8000f){
                                System.out.println("剧组钱给到位了，演员收下该剧本。");

                                // 开始表演
                                retV = method.invoke(actor, money * 4 / 5);
                            }else {
                                System.out.println("高难度表演有生命危险，钱太少了。");
                            }
                        }

                        return retV;
                    }
                }
        );

        // 代理对象代替目标对象开始表演
        // 基本表演
        proxy.basicAct(5000f);

        System.out.println("---------------华丽丽分割线-------------------");
        // 高难度表演
        proxy.difficultyAct(7999f);
    }
}
