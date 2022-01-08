package com.zhaokun.config;

import com.zhaokun.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author zhaok
 * 配置类==配置文件
 * @Configuration 告诉Spring 这是一个配置类
 *
 */
@Configuration
@ComponentScan(value = "com.zhaokun")
//@ComponentScan(value = "com.zhaokun",excludeFilters = {
//        // 排除规则，指定注解ANNOTATION、或者ASSIGNABLE_TYPE,，ASPECTJ，REGEX，CUSTOM
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,
//                classes = {
//                Controller.class,
//                Service.class
//        })
//})
//@ComponentScans(
//        value = {
//                @ComponentScan(value = "com.zhaokun", includeFilters = {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
//                                Controller.class
//                        })
//                }, useDefaultFilters = false)
//        }
//)
public class MainConfig {


    @Bean("person")
    public Person person01() {
        return new Person("lisi", 20);
    }


}
