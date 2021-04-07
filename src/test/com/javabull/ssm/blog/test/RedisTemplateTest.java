package com.javabull.ssm.blog.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Object测试
     */
    @Test
    public void test01() {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
//        opsForValue.set("hello","hello");
//        Object hello = opsForValue.get("hello");
//        System.out.println(hello);
//        opsForValue.set("hello","2");
//        System.out.println(opsForValue.get("hello"));
//        redisTemplate.delete("hello");
//        System.out.println(opsForValue.get("hello"));
        System.out.println("==============================");
        opsForValue.set("list", Arrays.asList(1,2,3,4), 2, TimeUnit.SECONDS);
        System.out.println(opsForValue.get("list"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(opsForValue.get("list"));
        redisTemplate.delete("lsit");
    }

    @Test
    public void test02(){
        ListOperations<String, Object> opsForList = redisTemplate.opsForList();

    }
}
