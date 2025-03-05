package org.opengear.supa;

import org.opengear.supa.http.IgnoreWrapResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class DemoController {

    @IgnoreWrapResult
    @RequestMapping(value = "/test")
    public Object test() {
        return new Person("jacks",Long.MAX_VALUE,Instant.now());
    }

    record Person(String name, Long l, Instant instant) {}

}
