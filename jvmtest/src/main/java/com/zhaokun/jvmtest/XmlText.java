package com.zhaokun.jvmtest;

import cn.hutool.json.JSONUtil;

/**
 * @author zhaok
 * @Date 2022/3/11 18:38
 */
public class XmlText {


    private static final String xml = "<div font-size:14px'>" +
            "<div style='color: #33343D;margin-top: 12px'>骑手配送：" +
            "</div><div style='font-size:14px; color: #575967; " +
            "margin-top4px'><span >若您的收货地址符合配送条件时，可以选择此方式</span>" +
            "<div>配送费：<span style='color:#00A780'>¥{rider}</span>单</div></div>" +
            "</div>";

    public static void main(String[] args) {

        String s = JSONUtil.toJsonStr(xml);
        System.out.println(s);

    }






}