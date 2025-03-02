package org.opengear.supa;

import org.opengear.supa.http.IgnoreWrapResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @IgnoreWrapResult
    @RequestMapping(value = "/test")
    public Object test() {
        return new Person("jacks");
    }

    record Person(String name) {}

}
