package com.zhaokun.config;

import com.zhaokun.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的声明周期：
 *      bean创建---初始化----销毁的过程
 *
 * 容器管理bean的声明周期：
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义
 *
 * 构造（对象创建）
 *      单实例，在容器启动的时候创建对象
 *      多实例，在每次获取的时候创建对象
 *
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
 * 销毁：
 *      单实例，在容器关闭的时候
 *      多实例，容器不会管理这个bean，容器不会调用销毁方法
 *
 *
 * 遍历得到容器中所有的BeanPostProcessor;挨个执行beforeInitialization,
 * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessBeforeInitialization()
 *
 *BeanPostProcessor原理：
 *populateBean(beanName,mdb, instanceWrapper);给bean进行属性赋值
 *initializeBean
 *{
 * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * invokeInitMethods(beanName, wrappedBean, mbd);
 * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *}
 *
 *
 *
 * 1）、指定初始化和销毁方法：
 *          指定init-method和destroy-method
 * 2）、通过实现InitializingBean，DisposableBean实现初始化和销毁
 *
 * 3）、可以使用JSR250:
 *      @PostConstruct: 在bean创建完成并且属性赋值完成，来执行初始化方法
 *      @PreDestroy： 在容器销毁bean之前通知我们进行清理工作
 * 4）、BeanPostProcessor 【interface】，bean的后置处理器；
 *      postProcessBeforeInitialization: 在初始化之前
 *      postProcessAfterInitialization： 在初始化之后
 *
 * Spring底层对BeanPostProcessor实现
 *
 */
@Configuration
@ComponentScan("com.zhaokun.bean")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }






}
