package com.zhaokun.jvmtest;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaok
 * @Date 2022/3/30 14:15
 */
public class TTest<T> {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

//        Class<?> aClass = Class.forName("com.zhaokun.jvmtest.Teacher");
//        Object o = genericMethod(aClass);
//        if (o instanceof Teacher) {
//            System.out.println("teacher");
//        } else {
//            System.out.println("...");
//        }
        User user = new User();
        user.setId(1);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        test(user, userList);

    }


    public static void test(Object obj, List<?> list) {
        if (obj instanceof User) {
            User user = BeanUtil.copyProperties(obj, User.class);
            List<User> users = BeanUtil.copyToList(list, User.class);

            System.out.println(user.getId());
            int id = users.get(0).getId();
            System.out.println(id);
        }
    }

    public static <T> T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        return tClass.newInstance();
    }
}
@Data
class User {
    int id;
}

@Data
class Student {
    int id;
}

@Data
class Teacher {
    int id;
}