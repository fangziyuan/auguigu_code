package com.zhaokun.config;

import com.zhaokun.bean.*;
import com.zhaokun.condition.LinuxCondition;
import com.zhaokun.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author zhaok
 * 配置类==配置文件
 * @Configuration 告诉Spring 这是一个配置类
 *
 */
@Configuration
@Import({Color.class, Red.class, Blue.class})
public class MainConfig2 {


    /**
     * 懒加载
     *
     * @return
     */
    @Lazy
    // 默认都是单实例的
//    @Scope("prototype")
    @Scope("singleton")
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person....");
        return new Person("张三", 25);
    }

    /**
     * @Conditional ： 按照一定的条件进行判断，满足条件给容器中注册bean
     * 如果系统是Windows 给容器注册bill
     * 如果是linux系统，给容器注册linus
     */
    @Bean("bill")
    @Conditional(WindowsCondition.class)
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Bean("linus")
    @Conditional(LinuxCondition.class)
    public Person person02() {
        return new Person("linus", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
