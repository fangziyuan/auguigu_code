package com.zhaokun.springneo4j.dao;

import com.zhaokun.springneo4j.entity.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaok
 * @Date 2022/9/6 20:32
 */
@Repository
public interface PersonDao extends Neo4jRepository<Person,Long> {

    /**
     *
     * @param from
     * @param relation
     * @param to
     */
//    @Query("match (n:person {name:{})")
//    void createRelation(String from, String relation, String to);


}