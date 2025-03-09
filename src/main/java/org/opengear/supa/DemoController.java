package org.opengear.supa;

import org.opengear.supa.framework.http.IgnoreWrapResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @IgnoreWrapResult
    @RequestMapping(value = "/test")
    public Person test() {
        return new Person("jacks",Long.MAX_VALUE,Instant.now());
    }

    @GetMapping("/test-redis")
    public String testRedis() {
        try {
            redisTemplate.opsForValue().set("test-key", "test-value");
            String value = redisTemplate.opsForValue().get("test-key");
            return "Success: " + value;
        } catch (Exception e) {
            return "Failed: " + e.getMessage();
        }
    }

    @GetMapping("/test-postgres")
    public String testPostgres() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Success";
        } catch (Exception e) {
            return "Failed: " + e.getMessage();
        }
    }

    record Person(String name, Long l, Instant instant) {}

}
