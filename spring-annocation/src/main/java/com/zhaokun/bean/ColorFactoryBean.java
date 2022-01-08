package com.zhaokun.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是单例？
     * true ，这个bean是单实例，这个对象会添加到容器中
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
