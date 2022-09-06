package com.zhaokun.jvmtest.serializable;

/**
 * @author zhaok
 * @Date 2022/3/25 10:21
 */
public class Employee implements java.io.Serializable {

    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }

}