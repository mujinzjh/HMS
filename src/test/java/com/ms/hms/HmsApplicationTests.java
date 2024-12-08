package com.ms.hms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;

@SpringBootTest
class HmsApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().append("ms", "hello");
    }
}
