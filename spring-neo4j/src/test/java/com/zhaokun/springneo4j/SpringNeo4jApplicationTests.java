package com.zhaokun.springneo4j;


import com.zhaokun.springneo4j.dao.PersonDao;
import com.zhaokun.springneo4j.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SpringNeo4jApplicationTests {

    @Autowired
    private PersonDao personDao;

    @Test
    public void query() {
        Optional<Person> byId = personDao.findById(1262L);
        boolean present = byId.isPresent();
        log.info("result = " + present);
        if (present) {
            Person person = byId.get();
            log.info(person.toString());
        }


    }



}
