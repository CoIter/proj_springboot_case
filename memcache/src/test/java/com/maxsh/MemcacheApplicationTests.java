package com.maxsh;

import net.rubyeye.xmemcached.MemcachedClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemcacheApplicationTests {

    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    void test() throws Exception{
        memcachedClient.set("hello", 0, "Hello,xmemcached");
        String value = memcachedClient.get("hello");
        System.out.println("hello=" + value);
        memcachedClient.delete("hello");
    }

}
