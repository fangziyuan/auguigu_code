package com.zhaokun.springneo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.io.Serializable;

/**
 * @author zhaok
 * @Date 2022/9/6 20:34
 */
@Data
@NodeEntity(label = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;
    @Property
    private String from;
    @Property
    private Integer kloutScore;

}